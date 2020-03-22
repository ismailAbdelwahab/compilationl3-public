import c3a.*;
import nasm.*;
import ts.Ts;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private final NasmRegister ebp = new NasmRegister(Nasm.REG_EBP);
    private final NasmRegister esp = new NasmRegister(Nasm.REG_ESP);
    private static final int INT_SIZE = 4;

    private final C3a c3a;
    private Nasm nasm;
    private final Ts globalTable;
    private int CURRENT_NB_LOCAL_VARS;

    public C3a2nasm(C3a c3a, Ts globalTable) {
        this.c3a = c3a;
        this.globalTable = globalTable;
        this.nasm = new Nasm( this.globalTable);

        this.nasm.setTempCounter( 0 );

        ebp.colorRegister(Nasm.REG_EBP);
        esp.colorRegister(Nasm.REG_ESP);
        NasmRegister eax = new NasmRegister(Nasm.REG_EAX);
        eax.colorRegister(Nasm.REG_EAX);
        NasmRegister ebx = new NasmRegister(Nasm.REG_EBX);
        ebx.colorRegister(Nasm.REG_EBX);

        nasm.ajouteInst(new NasmCall(null, new NasmLabel("main"), ""));
        nasm.ajouteInst(new NasmMov(null, ebx, new NasmConstant(0), " valeur de retour du programme"));
        nasm.ajouteInst(new NasmMov(null, eax, new NasmConstant(1), ""));
        nasm.ajouteInst(new NasmInt(null, ""));

        for(C3aInst inst : c3a.listeInst) {
            inst.accept(this);
        }
    }

    public Nasm getNasm() { return nasm; }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmOperand label = (inst.label !=null) ? inst.label.accept(this) :null;
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        NasmOperand dest =  inst.result.accept(this);
        nasm.ajouteInst( new NasmMov(label, dest,op1,"") );
        nasm.ajouteInst( new NasmAdd(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmConstant returnSpace = new NasmConstant(INT_SIZE);
        nasm.ajouteInst( new NasmSub(null, esp, returnSpace ,"allocation mémoire pour la valeur de retour"));
        NasmLabel functionName = new NasmLabel( inst.op1.getValue().getIdentif() );
        nasm.ajouteInst(new NasmCall(null, functionName, ""));
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst(new NasmPop(null, reg_eax, "récupération de la valeur de retour"));
        NasmConstant space_to_free = new NasmConstant(INT_SIZE * inst.op1.getValue().getNbArgs() );
        nasm.ajouteInst(new NasmAdd(null, esp, space_to_free ,"désallocation des arguments"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        this.CURRENT_NB_LOCAL_VARS= inst.val.getNbArgs();
        String funcName = inst.val.getIdentif();
        NasmLabel funcLabel = new NasmLabel( funcName );
        nasm.ajouteInst( new NasmPush(funcLabel , ebp, "sauvegarde la valeur de ebp"));
        nasm.ajouteInst( new NasmMov(null, ebp, esp, "nouvelle valeur de ebp"));

        NasmOperand shift = new NasmConstant(INT_SIZE * CURRENT_NB_LOCAL_VARS );
        nasm.ajouteInst( new NasmSub(null, esp, shift ,
                "allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return inst.accept( this );
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = (inst.label !=null) ? inst.label.accept(this) :null;
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        NasmOperand dest =  inst.result.accept(this);
        nasm.ajouteInst( new NasmMov(label, dest,op1,"") );
        nasm.ajouteInst( new NasmMul(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = (inst.label !=null) ? inst.label.accept(this) :null;
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        NasmOperand dest =  inst.result.accept(this);
        nasm.ajouteInst( new NasmMov(label, dest,op1,"") );
        nasm.ajouteInst( new NasmSub(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmOperand result = inst.result.accept( this );
        NasmOperand op1 = inst.op1.accept( this );

        nasm.ajouteInst(new NasmMov(null, result, op1, "Affect"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = (inst.label !=null) ? inst.label.accept(this) :null;
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        NasmRegister reg_source = nasm.newRegister();
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        nasm.ajouteInst( new NasmMov(label, reg_eax,op1,"") );
        nasm.ajouteInst( new NasmMov(null, reg_source, op2, ""));
        nasm.ajouteInst( new NasmDiv(null, reg_source, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        nasm.ajouteInst( new NasmAdd(null, esp,
                new NasmConstant(INT_SIZE*CURRENT_NB_LOCAL_VARS), "désallocation des variables locales"));
        nasm.ajouteInst( new NasmPop(null, ebp, "restaure la valeur de ebp"));
        nasm.ajouteInst( new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmLabel label = inst.label != null ? new NasmLabel( inst.label.toString() ) : null;
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        NasmOperand destination =  inst.result.accept( this );
        nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfEqual 1" ));
        nasm.ajouteInst(new NasmJe(null, destination,"JumpIfEqual 2" ));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmLabel label = inst.label != null ? new NasmLabel( inst.label.toString() ) : null;
        NasmOperand op1 = inst.op1.accept( this );
        NasmOperand op2 = inst.op2.accept( this );
        NasmOperand destination =  inst.result.accept( this );
        if( inst.op1 instanceof C3aConstant /* op1 est une constante*/){
            NasmRegister register = nasm.newRegister();
            nasm.ajouteInst(new NasmMov(label, register, op1, "JumpIfEqual 1"));
            nasm.ajouteInst(new NasmCmp(null, register, op2, "on passe par un registre temporaire" ));
        }
        else{
            nasm.ajouteInst(new NasmCmp(label, op1, op2, "JumpIfEqual 1" ));
        }
        nasm.ajouteInst(new NasmJe(null, destination,"JumpIfEqual 2" ));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        NasmLabel label = inst.label != null ? new NasmLabel( inst.label.toString()) : null;
        NasmOperand destination = inst.result.accept( this );
        nasm.ajouteInst( new NasmJmp(label, destination, "Jump") );
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        NasmOperand param = inst.op1.accept( this );
        nasm.ajouteInst( new NasmPush(null, param,"Param"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmOperand return_value = inst.accept( this );
        NasmOperand shift = new NasmConstant(2);
        NasmAddress return_adr = new NasmAddress(ebp,'+', shift);
        nasm.ajouteInst(new NasmMov(null, return_adr, return_value, "ecriture de la valeur de retour") );
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmRegister reg_eax = nasm.newRegister();
        reg_eax.colorRegister(Nasm.REG_EAX);
        nasm.ajouteInst( new NasmMov(null, reg_eax, inst.op1.accept(this), "Write 1" ));
        nasm.ajouteInst( new NasmCall(null, new NasmLabel("iprintLF"),"Write 2"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant( oper.val );
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel( oper.toString() );
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister( oper.num );
    }

    /*
    for array var: t[i]
    t ==> array
    i ==> index in array
    t[i] --> adr => [t + i*4]
                    [NasmLabel + (NasmConst||NasmVar) * 4]
     */

    @Override
    public NasmOperand visit(C3aVar oper) {//TODO check if this works
        //TODO : refactor this code between simple global var AND local var (same return code)
        if( oper.item.portee == globalTable ){ //This var is global
            if( oper.index == null){// check if this is a simple var
                NasmLabel varName = new NasmLabel( oper.item.getIdentif() );
                return new NasmAddress( varName );
            }
            else{ // or an array
                NasmLabel array_name = new NasmLabel(oper.item.getIdentif());
                char direction = oper.item.isParam ? '+' : '-';
                return new NasmAddress( array_name, direction, oper.index.accept(this) );
            }
        }
        //Return the local variable:
        return new NasmLabel( oper.item.getIdentif() );
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return new NasmLabel( oper.toString() );
    }
}
