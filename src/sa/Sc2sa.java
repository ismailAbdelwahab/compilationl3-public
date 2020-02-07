package sa;

import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	public SaNode getRoot(){
		return returnValue;
	}

	public void caseAAffectI(AAffectI node) {
		SaVar id = null;
		SaExp value = null;
		if(node.getVar() != null && node.getE() != null){
			node.getVar().apply(this);
			id = (SaVar) this.returnValue;
			node.getE().apply(this);
			value = (SaExp) this.returnValue;

			this.returnValue = new SaInstAffect(id, value);
		}
	}
	public void caseAArrayElement(AArrayElement node) {
		SaVarIndicee id = null;
		SaExp value = null;
		if( node.getId() != null && node.getE() != null ) {
			node.getId().apply(this);
			id = (SaVarIndicee) this.returnValue;
			node.getE().apply(this);
			value = (SaExp) this.returnValue;
			SaVarIndicee var = new SaVarIndicee(id.getNom(), value);
			this.returnValue = new SaExpVar(var);
		}
	}
	public void caseAArrayVar(AArrayVar node) {}
	public void caseADivArithHighE(ADivArithHighE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		if( node.getNegE() != null && node.getArithHighE() != null) {
			node.getArithHighE().apply(this);
			op1 = (SaExp) this.returnValue;
			node.getNegE().apply(this);
			op2 = (SaExp) this.returnValue;
			this.returnValue = new SaExpDiv(op1, op2);
		}
	}

	//AEpsEBis//
	public void caseAEpsEBis(AEpsEBis node) {}
	//AEpsElseBlock//
	public void caseAEpsElseBlock(AEpsElseBlock node) {}
	//AEpsIBis//
	public void caseAEpsIBis(AEpsIBis node) {}
	//AEpsLdf//
	public void caseAEpsLdf(AEpsLdf node) {}
	//AEpsLdv//
	public void caseAEpsLdv(AEpsLdv node) {}
	//AEpsLdvBis//
	public void caseAEpsLdvBis(AEpsLdvBis node) {}
	//AEpsLdvOptional//
	public void caseAEpsLdvOptional(AEpsLdvOptional node) {}
	//AEpsLe//
	public void caseAEpsLe(AEpsLe node) {}
	public void caseAEqualCompE(AEqualCompE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		if( node.getCompE() != null && node.getArithLowE()!= null ) {
			node.getCompE().apply(this);
			op1 = (SaExp) this.returnValue;
			node.getArithLowE().apply(this);
			op2 = (SaExp) this.returnValue;
			this.returnValue = new SaExpEqual(op1, op2);
		}
	}
	public void caseAFuncCallElement(AFuncCallElement node) {
		SaAppel val = null;
		if( node.getAppFunction() != null ) {
			node.getAppFunction().apply(this);
			val = (SaAppel) this.returnValue;
			this.returnValue = new SaExpAppel(val);
		}
	}

	public void caseAFuncCallI(AFuncCallI node) {
		SaVarIndicee op1 = null;
		SaLExp op2 = null;
		if( node.getId() != null && node.getLe()!=null) {
			node.getId().apply(this);
			op1 = (SaVarIndicee) this.returnValue;
			node.getLe().apply(this);
			op2 = (SaLExp) this.returnValue;
			this.returnValue = new SaAppel(op1.getNom(), op2);
		}
	}
	public void caseAIfI(AIfI node) {
		SaExp test = null;
		SaInst alors = null;
		SaInst sinon = null;
		if( node.getE() != null && node.getBi() != null) { // maybe to continue
			node.getE().apply(this);
			test = (SaExp) this.returnValue;
			node.getBi().apply(this);
			alors = (SaInst) this.returnValue;
			node.getElseBlock().apply(this);
			sinon = (SaInst) this.returnValue;
			this.returnValue = new SaInstSi(test, alors, sinon);
		}
	}
	public void caseALowerThanCompE(ALowerThanCompE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		if( node.getCompE() != null && node.getArithLowE() != null) {
			node.getCompE().apply(this);
			op1 = (SaExp) this.returnValue;
			node.getArithLowE().apply(this);
			op2 = (SaExp) this.returnValue;
			this.returnValue = new SaExpInf(op1, op2);
		}
	}
	public void caseAMoinsArithLowE(AMoinsArithLowE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		if( node.getArithHighE() != null && node.getArithLowE() != null ) {
			node.getArithLowE().apply(this);
			op1 = (SaExp) this.returnValue;
			node.getArithHighE().apply(this);
			op2 = (SaExp) this.returnValue;
			this.returnValue = new SaExpSub(op1, op2);
		}
	}
	public void caseAMultArithHighE(AMultArithHighE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		if( node.getArithHighE() != null && node.getNegE() != null ) {
			node.getArithHighE().apply(this);
			op1 = (SaExp) this.returnValue;
			node.getNegE().apply(this);
			op2 = (SaExp) this.returnValue;
			this.returnValue = new SaExpMult(op1, op2);
		}
	}////////////////////////////// TODO continue from here
	public void caseANumberElement(ANumberElement node) {
		SaExpInt nb = null;
		node.getNb().apply(this);
		nb = (SaExpInt) this.returnValue;
		this.returnValue = new SaExpInt( nb.getVal() );
	}
	/* TOUT les "APASS" sont ici */
	public void caseAPassAndE(APassAndE node) {}
	public void caseAPassArithHighE(APassArithHighE node) {}
	public void caseAPassArithLowE(APassArithLowE node) {}
	public void caseAPassCompE(APassCompE node) {}
	public void caseAPassE(APassE node) {}
	public void caseAPassNegE(APassNegE node) {}
	public void caseAPassParenthE(APassParenthE node) {}

	public void caseAPlusArithLowE(APlusArithLowE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getArithLowE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getArithHighE().apply(this);
		op2= (SaExp) this.returnValue;
		this.returnValue = new SaExpAdd(op1, op2);
	}
	public void caseAProgProgramme(AProgProgramme node) {
		SaLDec ldvo = null;
		SaLDec ldf = null;
		node.getLdvOptional().apply(this);
		ldvo = (SaLDec) this.returnValue;
		node.getLdf().apply(this);
		ldf = (SaLDec) this.returnValue;
		this.returnValue = new SaProg(ldvo, ldf);
	}
	public void caseAReadElement(AReadElement node) {
		this.returnValue = new SaExpLire();
	}
	public void caseARegularAndE(ARegularAndE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getAndE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getCompE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpAnd(op1, op2);
	}
	public void caseARegularAppFunction(ARegularAppFunction node) {
		SaVarSimple nom = null;
		SaLExp le = null;
		node.getId().apply(this);
		nom = (SaVarSimple) this.returnValue;
		node.getLe().apply(this);
		le = (SaLExp) this.returnValue;
		SaAppel appel = new SaAppel(nom.getNom(), le);
		this.returnValue = new SaExpAppel(appel);
	}

	public void caseARegularArrayDv(ARegularArrayDv node) {
		SaVarIndicee nom = null;
		SaExpInt size = null;
		node.getId().apply(this);
		nom = (SaVarIndicee) this.returnValue;
		node.getNb().apply(this);
		size = (SaExpInt) this.returnValue;
		this.returnValue = new SaDecTab(nom.getNom(), size.getVal() );
	}
	public void caseARegularBi(ARegularBi node) {
		SaLInst li = null;
		node.getLi().apply(this);
		li = (SaLInst) this.returnValue;
		this.returnValue = new SaInstBloc(li);
	}
	public void caseARegularDf(ARegularDf node) {
		SaVarSimple nom = null;
		SaLDec params = null;
		SaLDec vars = null;
		SaInst corps = null;
		node.getId().apply(this);
		nom = (SaVarSimple) this.returnValue;
		node.getLdv().apply(this);
		params = (SaLDec) this.returnValue;
		node.getLdvOptional().apply(this);
		vars = (SaLDec) this.returnValue;
		node.getBi().apply(this);
		corps = (SaInst) this.returnValue;
		this.returnValue = new SaDecFonc(nom.getNom(), params, vars, corps);
	}
	public void caseARegularE(ARegularE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getAndE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpOr(op1, op2);
	}
	//ARegularEBis//
	public void caseARegularEBis(ARegularEBis node) {}
	//ARegularElseBlock//
	public void caseARegularElseBlock(ARegularElseBlock node) {}
	//ARegularIBis//
	public void caseARegularIBis(ARegularIBis node) {}
	public void caseARegularLdf(ARegularLdf node) {
		SaDec df = null;
		SaLDec ldf = null;
		node.getDf().apply(this);
		df = (SaDec) this.returnValue;
		node.getLdf().apply(this);
		ldf = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(df, ldf);
	}
	public void caseARegularLdv(ARegularLdv node) {
		SaDec dv = null;
		SaLDec ldv = null;
		node.getDv().apply(this);
		dv = (SaDec) this.returnValue;
		node.getLdvBis().apply(this);
		ldv = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(dv, ldv);
	}
	//ARegularLdvBis//
	public void caseARegularLdvBis(ARegularLdvBis node) {}
	//ARegularLdvOptional//
	public void ARegularLdvOptional(ARegularLdvOptional node) {}
	public void caseARegularLe(ARegularLe node) {
		SaDec e = null;
		SaLDec e_bis = null;
		node.getE().apply(this);
		e = (SaDec) this.returnValue;
		node.getEBis().apply(this);
		e_bis = (SaLDec) this.returnValue;
		this.returnValue = new SaLDec(e, e_bis);
	}
	public void caseARegularLi(ARegularLi node) {
		SaInst head = null;
		SaLInst tail = null;
		node.getI().apply(this);
		head = (SaInst) this.returnValue;
		node.getIBis().apply(this);
		tail = (SaLInst) this.returnValue;
		this.returnValue = new SaLInst(head, tail);
	}
	public void caseARegularNegE(ARegularNegE node) {
		SaExp op1 = null;
		node.getParenthE().apply(this);
		op1 = (SaExp) this.returnValue;
		this.returnValue = new SaExpNot(op1);
	}
	//ARegularParenthE//
	public void caseARegularParenthE(ARegularParenthE node) {}
	//ARegularVar//
	public void caseARegularVar(ARegularVar node) {}
	public void caseARegularVariableDv(ARegularVariableDv node) {
		SaVarSimple nom = null;
		node.getId().apply(this);
		nom = (SaVarSimple) this.returnValue;
		this.returnValue = new SaDecVar(nom.getNom());
	}
	public void caseAReturnI(AReturnI node) {
		SaExp val = null;
		node.getE().apply(this);
		val = (SaExp) this.returnValue;
		this.returnValue = new SaInstRetour(val);
	}
	public void caseAVariableElement(AVariableElement node) {
		SaVarSimple val = null;
		node.getId().apply(this);
		val = (SaVarSimple) this.returnValue;
		this.returnValue = new SaExpVar(val);
	}
	public void caseAWhileI(AWhileI node) {
		SaExp test = null;
		SaInst bi = null;
		node.getE().apply(this);
		test = (SaExp) this.returnValue;
		node.getBi().apply(this);
		bi = (SaInst) this.returnValue;
		this.returnValue = new SaInstTantQue(test, bi);
	}
	public void caseAWriteI(AWriteI node) {
		SaExp arg = null;
		node.getE().apply(this);
		arg = (SaExp) this.returnValue;
		this.returnValue = new SaInstEcriture(arg);
	}
	//////////////////////////////////////////////////////////////
}