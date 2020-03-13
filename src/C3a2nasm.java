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
    }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        //nasm.ajouteInst( new NasmAdd(null, dest, src, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        this.CURRENT_NB_LOCAL_VARS= inst.val.getNbArgs();
        String funcName = inst.val.getIdentif();
        NasmLabel funcLabel = new NasmLabel( funcName );
        nasm.ajouteInst( new NasmPush(funcLabel , ebp, ""));
        nasm.ajouteInst( new NasmMov(null, ebp, esp, ""));

        NasmOperand shift = new NasmConstant(INT_SIZE * CURRENT_NB_LOCAL_VARS );
        nasm.ajouteInst( new NasmSub(null, esp, shift ,
                "allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        nasm.ajouteInst( new NasmAdd(null, esp,
                new NasmConstant(INT_SIZE*CURRENT_NB_LOCAL_VARS),
                "désallocation des variables locales"));
        nasm.ajouteInst( new NasmPop(null, ebp,
                "restaure la valeur de ebp"));
        nasm.ajouteInst( new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
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
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
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
    public NasmOperand visit(C3aVar oper) {//TODO finish this method
        if( oper.item.portee == globalTable ){
            //Global var found
            if( oper.index == null){// check if this is a simple var (oper.index == null)

            }
            else{ // or an array

            }
        }
        String varName = oper.item.identif;
        if( globalTable.getVar( varName ) != null){
            return new NasmLabel( varName );
        }
        else{
            char direction = oper.item.isParam ? '+' : '-';
            int adr =   CURRENT_NB_LOCAL_VARS - oper.item.adresse;
            NasmConstant offset = new NasmConstant( adr );
            return new NasmAddress(ebp,direction,offset);
        }
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        return new NasmLabel( oper.toString() );
    }
}
