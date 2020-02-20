import sc.analysis.DepthFirstAdapter;
import sc.node.*;
import sa.*;

public class Sc2sa extends DepthFirstAdapter {
	private SaNode returnValue;

	public SaNode getRoot() { return returnValue; }

	@Override
	public void caseStart(Start node) {
		super.caseStart(node);
	}

	public void caseAAffectI(AAffectI node) {
		SaVar id = null;
		SaExp value = null;
		node.getVar().apply(this);
		id = (SaVar) this.returnValue;
		node.getE().apply(this);
		value = (SaExp) this.returnValue;
		this.returnValue = new SaInstAffect(id, value);
	}
	public void caseAArrayElement(AArrayElement node) {
		SaVarSimple nom = null;
		SaExp indice = null;
		node.getId().apply(this);
		nom = (SaVarSimple) this.returnValue;
		node.getE().apply(this);
		indice = (SaExp) this.returnValue;
		this.returnValue = new SaVarIndicee(nom.getNom(), indice);
	}
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

	//AEpsEBis//
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
		SaVarSimple id = null;
		SaLDec params = null;
		SaLDec vars = null;
		SaInst corps = null;
		node.getId().apply(this);
		id = (SaVarSimple) this.returnValue;
		node.getLdv().apply(this);
		params = (SaLDec) this.returnValue;
		node.getLdvOptional().apply(this);
		vars = (SaLDec) this.returnValue;
		node.getBi().apply(this);
		corps = (SaInst) this.returnValue;
		this.returnValue = new SaDecFonc(id.getNom(), params, vars, corps);
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
	//ARegularElseBlock//
	//ARegularIBis//
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
	//ARegularLdvOptional//
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
	//ARegularVar//
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
		SaVarSimple var = null;
		node.getId().apply(this);
		var = (SaVarSimple) this.returnValue;
		this.returnValue = new SaVarSimple(var.getNom());
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