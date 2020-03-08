import sc.analysis.DepthFirstAdapter;
import sc.node.*;
import sa.*;

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

	public void caseAArrayVarI(AArrayVarI node) {
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
	}

	/* Cases with epsilon */
	public void caseAEpsEBis(AEpsEBis node)               { this.returnValue = null; }
	public void caseAEpsElseBlock(AEpsElseBlock node)     { this.returnValue = null; }
	public void caseAEpsIBis(AEpsIBis node)               { this.returnValue = null; }
	public void caseAEpsLdf(AEpsLdf node)                 { this.returnValue = null; }
	public void caseAEpsLdv(AEpsLdv node)                 { this.returnValue = null; }
	public void caseAEpsLdvBis(AEpsLdvBis node)           { this.returnValue = null; }
	public void caseAEpsLdvOptional(AEpsLdvOptional node) { this.returnValue = null; }
	public void caseAEpsLe(AEpsLe node)                   { this.returnValue = null; }

	public void caseAEqualCompE(AEqualCompE node) {
        node.getCompE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getArithLowE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1, op2);
	}
	public void caseAFuncCallElement(AFuncCallElement node) {
        node.getAppFunction().apply(this);
        SaAppel funcName = (SaAppel) this.returnValue;
        this.returnValue = new SaExpAppel(funcName);
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
	}

	public void caseAMoinsArithLowE(AMoinsArithLowE node) {
        node.getArithLowE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getArithHighE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1, op2);
	}
	public void caseAMultArithHighE(AMultArithHighE node) {
        node.getArithHighE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
        node.getNegE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1, op2);
	}
	public void caseANumberElement(ANumberElement node) {
        int value = Integer.parseInt( node.getNb().getText() );
		this.returnValue = new SaExpInt( value );
	}

	/* Cases with Pass --> Equivalent to : "Going down the elevator in expressions" */
	public void caseAPassAndE(APassAndE node)             { node.getCompE().apply( this );      }
	public void caseAPassArithHighE(APassArithHighE node) { node.getNegE().apply( this );       }
	public void caseAPassArithLowE(APassArithLowE node)   { node.getArithHighE().apply( this ); }
	public void caseAPassCompE(APassCompE node)           { node.getArithLowE().apply( this );  }
	public void caseAPassE(APassE node)                   { node.getAndE().apply( this );       }
	public void caseAPassNegE(APassNegE node)             { node.getParenthE().apply( this );   }
	public void caseAPassParenthE(APassParenthE node)     { node.getElement().apply( this );    }

	public void caseAPlusArithLowE(APlusArithLowE node) {
		node.getArithLowE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		node.getArithHighE().apply(this);
        SaExp op2= (SaExp) this.returnValue;
		this.returnValue = new SaExpAdd(op1, op2);
	}

	public void caseAProgProgramme(AProgProgramme node) {
		node.getLdvOptional().apply(this);
        SaLDec ldvo = (SaLDec) this.returnValue;
		node.getLdf().apply(this);
        SaLDec ldf = (SaLDec) this.returnValue;
		this.returnValue = new SaProg(ldvo, ldf);
	}

	public void caseAReadElement(AReadElement node) { this.returnValue = new SaExpLire(); }

	public void caseARegularAndE(ARegularAndE node) {
		node.getAndE().apply(this);
        SaExp op1 = (SaExp) this.returnValue;
		node.getCompE().apply(this);
        SaExp op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpAnd(op1, op2);
	}

	public void caseARegularAppFunction(ARegularAppFunction node) {
		String id = node.getId().getText();
		node.getLe().apply(this);
        SaLExp le = (SaLExp) this.returnValue;
		this.returnValue = new SaAppel(id, le);
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
	}

	public void caseARegularEBis(ARegularEBis node) {
	    node.getE().apply( this );
	    SaExp currExp = (SaExp) this.returnValue;
	    node.getEBis().apply( this );
	    SaLExp tail = (SaLExp) this.returnValue;
		this.returnValue = new SaLExp( currExp, tail);
    }

	public void caseARegularElseBlock(ARegularElseBlock node) { node.getBi().apply(this); }

	public void caseARegularIBis(ARegularIBis node) {
		node.getI().apply(this);
		SaInst head = (SaInst) this.returnValue;
		node.getIBis().apply(this);
		SaLInst tail = (SaLInst) this.returnValue;
		this.returnValue = new SaLInst(head, tail);
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

	public void caseARegularLdvBis(ARegularLdvBis node) {
		node.getDv().apply(this);
		SaDec dv = (SaDec) this.returnValue;
		node.getLdvBis().apply(this);
		SaLDec ldv = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(dv, ldv);
    }

	public void ARegularLdvOptional(ARegularLdvOptional node) { node.getLdv().apply(this); }

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
	}

	public void caseARegularParenthE(ARegularParenthE node) { node.getE().apply( this ); }

	public void caseARegularVarI(ARegularVarI node) {
	    String id = node.getId().getText();
		this.returnValue = new SaVarSimple(id);
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
		node.getVar().apply( this );
		SaVar var = (SaVar) this.returnValue;
		this.returnValue =new SaExpVar( var );
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
	}

	public void caseARegularVar(ARegularVar node){
		String id = node.getId().getText();
		this.returnValue = new SaVarSimple( id );
	}

	public void caseAArrayVar(AArrayVar node){
		String id = node.getId().getText();
		node.getE().apply( this );
		SaExp index = (SaExp) this.returnValue;
		this.returnValue = new SaVarIndicee( id, index );
	}
	@Override
	public void caseEOF(EOF node){}
}