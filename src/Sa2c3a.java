import c3a.*;
import sa.*;
import ts.Ts;
import ts.TsItemVar;

public class Sa2c3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts globalTable;

    public Sa2c3a(SaNode root, Ts globalTable) {
        this.c3a = new C3a();
        this.globalTable = globalTable;
        root.accept(this);
    }

    public C3a getC3a() { return c3a; }

    public C3aOperand visit(SaProg node ){
        node.getFonctions().accept( this );
        return null;
    }


    public C3aOperand visit( SaAppel node ){
        if( node.getArguments() != null ) {
            SaLExp arguments = node.getArguments();
            while (arguments != null) {
                C3aOperand param = arguments.getTete().accept(this);
                c3a.ajouteInst(new C3aInstParam(param, ""));
                arguments = arguments.getQueue();
            }
            System.out.println("C3A SaAPPEL ==> ts item ==> " + node.tsItem);
        }
        return new C3aFunction( node.tsItem );
    }
/////////////////////////// SaExp are here ////////////////////////////////////////////
    public C3aOperand visit ( SaExpAdd node ){
        C3aOperand op1 = node.getOp1().accept( this );
        C3aOperand op2 = node.getOp2().accept( this );
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstAdd(op1, op2, tmp, "") );
        return tmp;
    }
    public C3aOperand visit( SaExpInt node ){
        C3aOperand op = new C3aConstant( node.getVal() );
        return op;
    }
    public C3aOperand visit ( SaExpAppel node ){
        C3aFunction op1 =(C3aFunction) node.getVal().accept( this );
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstCall(op1, tmp, "") );
        System.out.println("C3A ==> SaEXPappel FIN");
        return tmp;
    }
    public C3aOperand visit ( SaExpDiv node ){
        C3aOperand op1 = node.getOp1().accept( this );
        C3aOperand op2 = node.getOp2().accept( this );
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstDiv(op1, op2, tmp, "") );
        return tmp;
    }
    public C3aOperand visit ( SaExpLire node ){
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstRead( tmp, "") );
        return tmp;
    }
    public C3aOperand visit ( SaExpMult node ){
        C3aOperand op1 = node.getOp1().accept( this );
        C3aOperand op2 = node.getOp2().accept( this );
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstMult(op1, op2, tmp, "") );
        return tmp;
    }
    public C3aOperand visit ( SaExpSub node ){
        C3aOperand op1 = node.getOp1().accept( this );
        C3aOperand op2 = node.getOp2().accept( this );
        C3aTemp tmp = c3a.newTemp();
        c3a.ajouteInst( new C3aInstSub(op1, op2, tmp, "") );
        return tmp;
    }
    public C3aOperand visit ( SaExpVar node ){
        return node.getVar().accept( this );
    }

    public C3aOperand visit ( SaExpAnd node ){
        C3aOperand t0 = c3a.newTemp();

        C3aLabel continuation_of_prog = c3a.newAutoLabel();
        C3aLabel test_is_false = c3a.newAutoLabel();

        C3aOperand left = node.getOp1().accept( this );
        C3aOperand right = node.getOp2().accept( this );

        c3a.ajouteInst( new C3aInstJumpIfEqual( left, c3a.False, test_is_false, "" ));
        c3a.ajouteInst( new C3aInstJumpIfEqual( right, c3a.False, test_is_false, "" ));
        c3a.ajouteInst( new C3aInstAffect(c3a.True, t0, "") );
        c3a.ajouteInst( new C3aInstJump(continuation_of_prog, "") );
        c3a.addLabelToNextInst(test_is_false);
        c3a.ajouteInst( new C3aInstAffect(c3a.False, t0, "") );
        c3a.addLabelToNextInst(continuation_of_prog);
        return t0;
    }
    public C3aOperand visit ( SaExpOr node ){
        C3aOperand t0 = c3a.newTemp();

        C3aLabel continuation_of_prog = c3a.newAutoLabel();
        C3aLabel test_is_false = c3a.newAutoLabel();

        C3aOperand left = node.getOp1().accept( this );
        C3aOperand right = node.getOp2().accept( this );

        c3a.ajouteInst( new C3aInstJumpIfNotEqual( left, c3a.False, test_is_false, "" ));
        c3a.ajouteInst( new C3aInstJumpIfNotEqual( right, c3a.False, test_is_false, "" ));
        c3a.ajouteInst( new C3aInstAffect(c3a.False, t0, "") );
        c3a.ajouteInst( new C3aInstJump(continuation_of_prog, "") );
        c3a.addLabelToNextInst(test_is_false);
        c3a.ajouteInst( new C3aInstAffect(c3a.True, t0, "") );
        c3a.addLabelToNextInst(continuation_of_prog);
        return t0;
    }

    public C3aOperand visit ( SaExpInf node ){
        C3aOperand t0 = c3a.newTemp();
        C3aLabel continuation_of_prog = c3a.newAutoLabel();

        C3aOperand left = node.getOp1().accept( this );
        C3aOperand right = node.getOp2().accept( this );

        c3a.ajouteInst( new C3aInstAffect(c3a.True, t0, "") );

        c3a.ajouteInst( new C3aInstJumpIfLess( left, right, continuation_of_prog, "" ));

        c3a.ajouteInst( new C3aInstAffect(c3a.False, t0, "") );

        c3a.addLabelToNextInst(continuation_of_prog);
        return t0;
    }
//////////////// SaInst are here ////////////////////////////////////////////////
    public C3aOperand visit( SaInstEcriture node ){
        System.out.println("SaInstEcriture detected:");
        C3aOperand op = (C3aOperand) node.getArg().accept( this );
        System.out.println( "op ==> "+ op.toString() );
        c3a.ajouteInst( new C3aInstWrite( op, "" ) );
        return null;
    }
    public C3aOperand visit ( SaInstAffect node ){
        System.out.println("///////////////AFFECTION SA Starting");
        C3aVar left = (C3aVar) node.getLhs().accept( this );
        System.out.println("///////////////\t left is found Affect SA ");
        C3aOperand right = node.getRhs().accept( this );
        System.out.println("///////////////\t right is found Affect SA ");
        c3a.ajouteInst( new C3aInstAffect(right, left, "") );
        System.out.println("///////////////AFFECTION SA done..");
        return left;
    }
    public C3aOperand visit ( SaInstRetour node ){
        System.out.println( "#############Start inst retour .");
        C3aOperand op1 = node.getVal().accept( this );
        c3a.ajouteInst( new C3aInstReturn(op1, "") );
        System.out.println( "#############SA int retour DONE !!");
        return op1;
    }
    public C3aOperand visit ( SaInstBloc node ){
        //node.getVal().getTete().accept( this );
        node.getVal().accept( this );
        return null;
    }
    public C3aOperand visit ( SaInstSi node ){ // SI E alors B1 sinon B2
        C3aLabel else_label = c3a.newAutoLabel();
        C3aLabel continuation_of_prog = c3a.newAutoLabel();
        C3aOperand test_value = node.getTest().accept( this );

        if (node.getSinon() != null ) {
            c3a.ajouteInst( new C3aInstJumpIfEqual(test_value, c3a.False, else_label, "") ); // {if to = 0 goto l0}
            node.getAlors().accept( this );                            // { [Instructions of B1] }
            c3a.ajouteInst( new C3aInstJump(continuation_of_prog, ""));    // {goto l1}

            c3a.addLabelToNextInst(else_label);                      // add label to next block (it's l0)
            node.getSinon().accept(this);                            // { [Instructions of B2] }
            c3a.addLabelToNextInst( continuation_of_prog );
        }
        else{ // There is no Else block
            c3a.ajouteInst( new C3aInstJumpIfEqual(test_value, c3a.False, continuation_of_prog, "") ); // {if to = 0 goto l0}
            node.getAlors().accept( this );   // { [Instructions of B1] }
            c3a.addLabelToNextInst(continuation_of_prog );
        }
        return null;
    }
    public C3aOperand visit ( SaInstTantQue node ){
        C3aLabel loop_back = c3a.newAutoLabel();            // l0
        C3aLabel continuation_of_prog = c3a.newAutoLabel(); // l1
        C3aLabel test_is_true = c3a.newAutoLabel();         // l2

        C3aOperand t0 = c3a.newTemp();
        c3a.addLabelToNextInst( loop_back );
        c3a.ajouteInst( new C3aInstAffect(c3a.True, t0, "") ); // {to = 1}
        C3aOperand test_left_part = ((SaExpInf) node.getTest()).getOp1().accept( this );
        C3aOperand test_right_part = ((SaExpInf) node.getTest()).getOp2().accept( this );
        //{ if test_tant_que goto l2 }
        c3a.ajouteInst( new C3aInstJumpIfLess( test_left_part, test_right_part, test_is_true, "") );
        c3a.ajouteInst( new C3aInstAffect(c3a.False, t0, "") ); //{to = 1}

        c3a.addLabelToNextInst( test_is_true );
        // { if t0 = 0 goto l1 }
        c3a.ajouteInst( new C3aInstJumpIfEqual( t0, c3a.False, continuation_of_prog, ""));
        node.getFaire().accept( this ); // [ Instruction Block of while ]
        c3a.ajouteInst( new C3aInstJump( loop_back, "") );

        c3a.addLabelToNextInst( continuation_of_prog );
        return null;
    }
///////////////// SaDec are here ////////////////////////
    public C3aOperand visit ( SaDecVar node ){
        TsItemVar tsItemVar = globalTable.getVar( node.getNom() );
        return new C3aVar(tsItemVar, null);
    }
    public C3aOperand visit ( SaDecTab node ){
        TsItemVar tsItemVar = globalTable.getVar( node.getNom() );
        C3aConstant size =  new C3aConstant( node.getTaille() );
        return new C3aVar(tsItemVar, size);
    }
    public C3aOperand visit( SaDecFonc node ){
        c3a.ajouteInst( new C3aInstFBegin(node.tsItem, "entree fonction"));
        node.getCorps().accept( this );
        c3a.ajouteInst( new C3aInstFEnd(""));
        return null;
    }

    public C3aOperand visit( SaVarSimple node ){
        //TsItemVar tsItemVar = globalTable.getVar( node.getNom() );
        TsItemVar tsItemVar = node.tsItem;
        System.out.println("SaVarSimple case used to get here. => " + node.getNom()+" && node : "+ node );
        System.out.println("\t tsItemVar => "+ tsItemVar);
        C3aVar var =  new C3aVar(tsItemVar, null);
        System.out.println("\tVar generated => "+ var);
        return var;
    }
    public C3aOperand visit( SaVarIndicee node ){
        TsItemVar tsItemVar = node.tsItem;
        C3aOperand index = node.getIndice().accept( this );
        return new C3aVar(tsItemVar, index);
    }

}
