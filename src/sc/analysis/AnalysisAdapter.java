/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEE(AEE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndEE(AAndEE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndEAndE(AAndEAndE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACompEAndE(ACompEAndE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqualCompE(AEqualCompE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArithLowECompE(AArithLowECompE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPlusArithLowE(APlusArithLowE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMoinsArithLowE(AMoinsArithLowE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArithHighEArithLowE(AArithHighEArithLowE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultArithHighE(AMultArithHighE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivArithHighE(ADivArithHighE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegEArithHighE(ANegEArithHighE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExclamationMarkNegE(AExclamationMarkNegE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParenthENegE(AParenthENegE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParenthesisParenthE(AParenthesisParenthE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElementParenthE(AElementParenthE node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumberElement(ANumberElement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallElement(AFunctionCallElement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAReadElement(AReadElement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallDefAppFunction(AFunctionCallDefAppFunction node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListExpressionLe(AListExpressionLe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALe(ALe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultipleElementsEBis(AMultipleElementsEBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEBis(AEBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAffectationI(AAffectationI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfI(AIfI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWhileI(AWhileI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseARetI(ARetI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFunctionCallI(AFunctionCallI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAWriteI(AWriteI node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseElseBlock(AElseElseBlock node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAElseBlock(AElseBlock node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABlocInstructionBi(ABlocInstructionBi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListInstructionLi(AListInstructionLi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstructionSuivIBis(AInstructionSuivIBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIBis(AIBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFormProgProgramme(AFormProgProgramme node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALFoncLdf(ALFoncLdf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdf(ALdf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFoncDf(AFoncDf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOptVarLdvOptional(AOptVarLdvOptional node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdvOptional(ALdvOptional node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALVarLdv(ALVarLdv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdv(ALdv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDv(AVarDv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADv(ADv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALVarAfterCommaLdvBis(ALVarAfterCommaLdvBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdvBis(ALdvBis node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNb(TNb node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPo(TPo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPf(TPf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCo(TCo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCf(TCf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAo(TAo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAf(TAf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTq(TTq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemicolon(TSemicolon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDo(TDo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLire(TLire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEcrire(TEcrire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTReturn(TReturn node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEps(TEps node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEspaces(TEspaces node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentaire(TCommentaire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}