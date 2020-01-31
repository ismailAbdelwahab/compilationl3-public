package sa;

import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	public void caseAAffectI(AAffectI node) {
		SaVar id = null;
		SaExp value = null;
		node.getVar().apply(this);
		id = (SaVar) this.returnValue;
		node.getE().apply(this);
		value = (SaExp) this.returnValue;
		this.returnValue = new SaInstAffect(id, value);
	}
//AArrayElement//
//AArrayVar//
	public void caseADivArithHighE(ADivArithHighE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getArithHighE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getNegE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpDiv(op1, op2);
	}

	// AEpsEBis//
	//AEpsElseBlock//
	//AEpsIBis//
	//AEpsLdf//
	//AEpsLdv//
	//AEpsLdvBis//
	//AEpsLdvOptional//
	//AEpsLe//
	public void caseAEqualCompE(AEqualCompE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getCompE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getArithLowE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpEqual(op1, op2);
	}
	//AFuncCallElement//

	public void caseAFuncCallI(AFuncCallI node) {
		SaVarIndicee op1 = null;
		SaLExp op2 = null;
		node.getId().apply(this);
		op1 = (SaVarIndicee) this.returnValue;
		node.getLe().apply(this);
		op2 = (SaLExp) this.returnValue;
		this.returnValue = new SaAppel(op1.getNom(), op2);
	}
	public void caseAIfI(AIfI node) {
		SaExp test = null;
		SaInst alors = null;
		SaInst sinon = null;
		node.getE().apply(this);
		test = (SaExp) this.returnValue;
		node.getBi().apply(this);
		alors = (SaInst) this.returnValue;
		node.getElseBlock().apply(this);
		sinon = (SaInst) this.returnValue;
		this.returnValue = new SaInstSi( test, alors, sinon);
	}
	public void caseALowerThanCompE(ALowerThanCompE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getCompE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getArithLowE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpInf(op1, op2);
	}
	public void caseAMoinsArithLowE(AMoinsArithLowE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getArithLowE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getArithHighE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpSub(op1, op2);
	}
	public void caseAMultArithHighE(AMultArithHighE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getArithHighE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getNegE().apply(this);
		op2 = (SaExp) this.returnValue;
		this.returnValue = new SaExpMult(op1, op2);
	}
	//ANumberElement//
	/* TOUT les "APASS" sont ici */

	public void caseAPlusArithLowE(APlusArithLowE node) {
		SaExp op1 = null;
		SaExp op2 = null;
		node.getArithLowE().apply(this);
		op1 = (SaExp) this.returnValue;
		node.getArithHighE().apply(this);
		op2 = (SaExp) this.returnValue;
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
	//TODO from ARegularArrayDv
	//////////////////////////////////////////////////////////////
}