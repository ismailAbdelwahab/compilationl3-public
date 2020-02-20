import sc.analysis.DepthFirstAdapter;
import sc.node.*;
import sa.*;

//test with:
// javac Compiler.java && java Compiler ../test/input/add1.l

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	public SaNode getRoot() { return this.returnValue; }

	@Override
	public void caseStart(Start node) { super.caseStart(node); }

    public void caseAAffectI(AAffectI node) {
        node.getVar().apply(this);
        SaVar id = (SaVar) this.returnValue;
        node.getE().apply(this);
        SaExp value = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(id, value);
	}
	public void caseAArrayElement(AArrayElement node) {
        String id = node.getId().getText();
        node.getE().apply(this);
        SaExp value = (SaExp) this.returnValue;
        this.returnValue = new SaVarIndicee(id, value);
	}
    //AArrayVar//
	public void caseAArrayVar(AArrayVar node) {
        String id = node.getId().getText();
		node.getNb().apply(this);
        SaExp indice = (SaExp) this.returnValue;
		this.returnValue = new SaVarIndicee(id, indice);
	}
	public void caseADivArithHighE(ADivArithHighE node) {
        node.getArithHighE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getNegE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1, op2);
		System.out.println(" -> division");
	}

	//AEpsEBis//
	public void caseAEpsEBis(AEpsEBis node) {
	    this.returnValue = null;
    }
	//AEpsElseBlock//
	public void caseAEpsElseBlock(AEpsElseBlock node) {
	    this.returnValue = null;
    }
	//AEpsIBis//
	public void caseAEpsIBis(AEpsIBis node) {
	    this.returnValue = null;
    }
	//AEpsLdf//
	public void caseAEpsLdf(AEpsLdf node) {
	    this.returnValue = null;
    }
	//AEpsLdv//
	public void caseAEpsLdv(AEpsLdv node) {
	    this.returnValue = null;
    }
	//AEpsLdvBis//
	public void caseAEpsLdvBis(AEpsLdvBis node) {
	    this.returnValue = null;
    }
	//AEpsLdvOptional//
	public void caseAEpsLdvOptional(AEpsLdvOptional node) {
	    this.returnValue = null;
    }
	//AEpsLe//
	public void caseAEpsLe(AEpsLe node) {
	    this.returnValue = null;
    }
	public void caseAEqualCompE(AEqualCompE node) {
        node.getCompE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getArithLowE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
		System.out.println(" -> equal");
	}
	public void caseAFuncCallElement(AFuncCallElement node) {
        node.getAppFunction().apply(this);
        SaAppel val = (SaAppel) this.returnValue;
        this.returnValue = new SaExpAppel(val);
	}

	public void caseAFuncCallI(AFuncCallI node) {
        String id = node.getId().getText();
        node.getLe().apply(this);
        SaLExp params = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(id, params);
	}

	public void caseAIfI(AIfI node) {
        node.getE().apply(this);
        SaExp test = (SaExp) this.returnValue;
        node.getBi().apply(this);
        SaInst alors = (SaInst) this.returnValue;
        node.getElseBlock().apply(this);
        SaInst sinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(test, alors, sinon);
	}
	public void caseALowerThanCompE(ALowerThanCompE node) {
        node.getCompE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getArithLowE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1, op2);
		System.out.println(" ->  < (lower)");
	}
	public void caseAMoinsArithLowE(AMoinsArithLowE node) {
        node.getArithLowE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getArithHighE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
		System.out.println(" -> soustraction");
	}
	public void caseAMultArithHighE(AMultArithHighE node) {
        node.getArithHighE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getNegE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
		System.out.println(" -> multiplication");
	}
	public void caseANumberElement(ANumberElement node) {
		//node.getNb().apply(this);
        //SaExpInt nb = (SaExpInt) this.returnValue;
        int value = Integer.parseInt(node.getNb().getText());
		this.returnValue = new SaExpInt( value );
		System.out.println("ALAIDE Valeur trouvée");
	}
	/* TOUT les "APASS" sont ici */
	public void caseAPassAndE(APassAndE node) {
	    this.returnValue = null;
		System.out.println(" -> passed and");
    }
	public void caseAPassArithHighE(APassArithHighE node) {
	    this.returnValue = null;
		System.out.println(" -> passed arith high");
    }
	public void caseAPassArithLowE(APassArithLowE node) {
	    this.returnValue = null;
		System.out.println(" -> passed arith low");
    }
	public void caseAPassCompE(APassCompE node) {
	    this.returnValue = null;
		System.out.println(" -> passed comparaison");
    }
	public void caseAPassE(APassE node) {
	    this.returnValue = null;
		System.out.println(" -> passed or");
    }
	public void caseAPassNegE(APassNegE node) {
	    this.returnValue = null;
		System.out.println(" -> passed negation");
    }
	public void caseAPassParenthE(APassParenthE node) {
	    this.returnValue = null;
		System.out.println(" -> passed parentheses");
    }

	public void caseAPlusArithLowE(APlusArithLowE node) {
		node.getArithLowE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		node.getArithHighE().apply(this);
        SaExp op2= (SaExp) this.returnValue;
		this.returnValue = new SaExpAdd(op1, op2);
		System.out.println(" -> addition");
	}

	public void caseAProgProgramme(AProgProgramme node) {
		node.getLdvOptional().apply(this);
        SaLDec ldvo = (SaLDec) this.returnValue;
		node.getLdf().apply(this);
        SaLDec ldf = (SaLDec) this.returnValue;
		this.returnValue = new SaProg(ldvo, ldf);
	}
	public void caseAReadElement(AReadElement node) {
		this.returnValue = new SaExpLire();
	}
	public void caseARegularAndE(ARegularAndE node) {
		node.getAndE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		node.getCompE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpAnd(op1, op2);
		System.out.println(" -> AND");
	}
	public void caseARegularAppFunction(ARegularAppFunction node) {
		String id = node.getId().getText();
		node.getLe().apply(this);
        SaLExp le = (SaLExp) this.returnValue;
		SaAppel appel = new SaAppel(id, le);
		this.returnValue = new SaExpAppel(appel);
	}

	public void caseARegularArrayDv(ARegularArrayDv node) {
        String id = node.getId().getText();
        int size = Integer.parseInt( node.getNb().getText() );
		this.returnValue = new SaDecTab(id, size );
	}
	public void caseARegularBi(ARegularBi node) {
		node.getLi().apply(this);
        SaLInst li = (SaLInst) this.returnValue;
		this.returnValue = new SaInstBloc(li);
	}
	public void caseARegularDf(ARegularDf node) {
        String id = node.getId().getText();
		node.getLdv().apply(this);
        SaLDec params = (SaLDec) this.returnValue;
		node.getLdvOptional().apply(this);
        SaLDec vars = (SaLDec) this.returnValue;
		node.getBi().apply(this);
        SaInst iBloc = (SaInst) this.returnValue;
		this.returnValue = new SaDecFonc(id, params, vars, iBloc);
	}
	public void caseARegularE(ARegularE node) {
		node.getE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		node.getAndE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpOr(op1, op2);
		System.out.println(" -> Or");
	}
	//ARegularEBis//
	public void caseARegularEBis(ARegularEBis node) {
	    this.returnValue = null;
    }
	//ARegularElseBlock//
	public void caseARegularElseBlock(ARegularElseBlock node) {
	    this.returnValue = null;
    }
	//ARegularIBis//
	public void caseARegularIBis(ARegularIBis node) {
	    this.returnValue = null;
    }
	public void caseARegularLdf(ARegularLdf node) {
		node.getDf().apply(this);
        SaDec df = (SaDec) this.returnValue;
		node.getLdf().apply(this);
        SaLDec ldf = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(df, ldf);
	}
	public void caseARegularLdv(ARegularLdv node) {
		node.getDv().apply(this);
        SaDec dv = (SaDec) this.returnValue;
		node.getLdvBis().apply(this);
        SaLDec ldv = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(dv, ldv);
	}
	//ARegularLdvBis//
	public void caseARegularLdvBis(ARegularLdvBis node) {
	    this.returnValue = null;
    }
	//ARegularLdvOptional//
	public void ARegularLdvOptional(ARegularLdvOptional node) {
	    node.getLdv().apply(this); //TODO : check this method
    }
	public void caseARegularLe(ARegularLe node) {
		node.getE().apply(this);
        SaExp e = (SaExp) this.returnValue;
		node.getEBis().apply(this);
        SaLExp e_bis = (SaLExp) this.returnValue;
		this.returnValue = new SaLExp(e, e_bis);
	}
	public void caseARegularLi(ARegularLi node) {
		node.getI().apply(this);
        SaInst head = (SaInst) this.returnValue;
		node.getIBis().apply(this);
        SaLInst tail = (SaLInst) this.returnValue;
		this.returnValue = new SaLInst(head, tail);
	}
	public void caseARegularNegE(ARegularNegE node) {
		node.getParenthE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		this.returnValue = new SaExpNot(op1);
		System.out.println(" -> negation");
	}
	//ARegularParenthE//
	public void caseARegularParenthE(ARegularParenthE node) {
	    node.getE().apply( this );
		System.out.println(" -> parentheses");
    }
	//ARegularVar//
	public void caseARegularVar(ARegularVar node) {
	    String id = node.getId().getText();
		this.returnValue = new SaVarSimple(id);
	    //this.returnValue = null;
    }
	public void caseARegularVariableDv(ARegularVariableDv node) {
		String id = node.getId().getText();
		this.returnValue = new SaDecVar( id );
	}
	public void caseAReturnI(AReturnI node) {
		node.getE().apply(this);
        SaExp val = (SaExp) this.returnValue;
		this.returnValue = new SaInstRetour(val);
	}
	public void caseAVariableElement(AVariableElement node) {
		node.getId().apply(this);
        SaVarSimple val = (SaVarSimple) this.returnValue;
		this.returnValue = new SaExpVar(val);
	}
	public void caseAWhileI(AWhileI node) {
		node.getE().apply(this);
        SaExp test = (SaExp) this.returnValue;
		node.getBi().apply(this);
        SaInst bi = (SaInst) this.returnValue;
		this.returnValue = new SaInstTantQue(test, bi);
	}
	public void caseAWriteI(AWriteI node) {
		node.getE().apply(this);
        SaExp arg = (SaExp) this.returnValue;
		this.returnValue = new SaInstEcriture(arg);
		System.out.println("ALAIDE ecriture");
	}


	//////////////////////////////////////////////////////////////
}