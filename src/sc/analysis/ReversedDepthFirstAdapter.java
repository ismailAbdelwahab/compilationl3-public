/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPE().apply(this);
        outStart(node);
    }

    public void inAEE(AEE node)
    {
        defaultIn(node);
    }

    public void outAEE(AEE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEE(AEE node)
    {
        inAEE(node);
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
        }
        if(node.getOr() != null)
        {
            node.getOr().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        outAEE(node);
    }

    public void inAAndEE(AAndEE node)
    {
        defaultIn(node);
    }

    public void outAAndEE(AAndEE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndEE(AAndEE node)
    {
        inAAndEE(node);
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
        }
        outAAndEE(node);
    }

    public void inAAndEAndE(AAndEAndE node)
    {
        defaultIn(node);
    }

    public void outAAndEAndE(AAndEAndE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndEAndE(AAndEAndE node)
    {
        inAAndEAndE(node);
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
        }
        outAAndEAndE(node);
    }

    public void inACompEAndE(ACompEAndE node)
    {
        defaultIn(node);
    }

    public void outACompEAndE(ACompEAndE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACompEAndE(ACompEAndE node)
    {
        inACompEAndE(node);
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        outACompEAndE(node);
    }

    public void inAEqualCompE(AEqualCompE node)
    {
        defaultIn(node);
    }

    public void outAEqualCompE(AEqualCompE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqualCompE(AEqualCompE node)
    {
        inAEqualCompE(node);
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        outAEqualCompE(node);
    }

    public void inAArithLowECompE(AArithLowECompE node)
    {
        defaultIn(node);
    }

    public void outAArithLowECompE(AArithLowECompE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArithLowECompE(AArithLowECompE node)
    {
        inAArithLowECompE(node);
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outAArithLowECompE(node);
    }

    public void inAPlusArithLowE(APlusArithLowE node)
    {
        defaultIn(node);
    }

    public void outAPlusArithLowE(APlusArithLowE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusArithLowE(APlusArithLowE node)
    {
        inAPlusArithLowE(node);
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outAPlusArithLowE(node);
    }

    public void inAMoinsArithLowE(AMoinsArithLowE node)
    {
        defaultIn(node);
    }

    public void outAMoinsArithLowE(AMoinsArithLowE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMoinsArithLowE(AMoinsArithLowE node)
    {
        inAMoinsArithLowE(node);
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outAMoinsArithLowE(node);
    }

    public void inAArithHighEArithLowE(AArithHighEArithLowE node)
    {
        defaultIn(node);
    }

    public void outAArithHighEArithLowE(AArithHighEArithLowE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArithHighEArithLowE(AArithHighEArithLowE node)
    {
        inAArithHighEArithLowE(node);
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        outAArithHighEArithLowE(node);
    }

    public void inAMultArithHighE(AMultArithHighE node)
    {
        defaultIn(node);
    }

    public void outAMultArithHighE(AMultArithHighE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultArithHighE(AMultArithHighE node)
    {
        inAMultArithHighE(node);
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        outAMultArithHighE(node);
    }

    public void inADivArithHighE(ADivArithHighE node)
    {
        defaultIn(node);
    }

    public void outADivArithHighE(ADivArithHighE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivArithHighE(ADivArithHighE node)
    {
        inADivArithHighE(node);
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        outADivArithHighE(node);
    }

    public void inANegEArithHighE(ANegEArithHighE node)
    {
        defaultIn(node);
    }

    public void outANegEArithHighE(ANegEArithHighE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegEArithHighE(ANegEArithHighE node)
    {
        inANegEArithHighE(node);
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
        }
        outANegEArithHighE(node);
    }

    public void inAExclamationMarkNegE(AExclamationMarkNegE node)
    {
        defaultIn(node);
    }

    public void outAExclamationMarkNegE(AExclamationMarkNegE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExclamationMarkNegE(AExclamationMarkNegE node)
    {
        inAExclamationMarkNegE(node);
        if(node.getParenthE() != null)
        {
            node.getParenthE().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        outAExclamationMarkNegE(node);
    }

    public void inAParenthENegE(AParenthENegE node)
    {
        defaultIn(node);
    }

    public void outAParenthENegE(AParenthENegE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParenthENegE(AParenthENegE node)
    {
        inAParenthENegE(node);
        if(node.getParenthE() != null)
        {
            node.getParenthE().apply(this);
        }
        outAParenthENegE(node);
    }

    public void inAParenthesisParenthE(AParenthesisParenthE node)
    {
        defaultIn(node);
    }

    public void outAParenthesisParenthE(AParenthesisParenthE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParenthesisParenthE(AParenthesisParenthE node)
    {
        inAParenthesisParenthE(node);
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getElement() != null)
        {
            node.getElement().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        outAParenthesisParenthE(node);
    }

    public void inAElementParenthE(AElementParenthE node)
    {
        defaultIn(node);
    }

    public void outAElementParenthE(AElementParenthE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElementParenthE(AElementParenthE node)
    {
        inAElementParenthE(node);
        if(node.getElement() != null)
        {
            node.getElement().apply(this);
        }
        outAElementParenthE(node);
    }

    public void inANumberElement(ANumberElement node)
    {
        defaultIn(node);
    }

    public void outANumberElement(ANumberElement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberElement(ANumberElement node)
    {
        inANumberElement(node);
        if(node.getNb() != null)
        {
            node.getNb().apply(this);
        }
        outANumberElement(node);
    }

    public void inAFunctionCallElement(AFunctionCallElement node)
    {
        defaultIn(node);
    }

    public void outAFunctionCallElement(AFunctionCallElement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunctionCallElement(AFunctionCallElement node)
    {
        inAFunctionCallElement(node);
        if(node.getAppFunction() != null)
        {
            node.getAppFunction().apply(this);
        }
        outAFunctionCallElement(node);
    }

    public void inAReadElement(AReadElement node)
    {
        defaultIn(node);
    }

    public void outAReadElement(AReadElement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAReadElement(AReadElement node)
    {
        inAReadElement(node);
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        outAReadElement(node);
    }

    public void inAFunctionCallDefAppFunction(AFunctionCallDefAppFunction node)
    {
        defaultIn(node);
    }

    public void outAFunctionCallDefAppFunction(AFunctionCallDefAppFunction node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunctionCallDefAppFunction(AFunctionCallDefAppFunction node)
    {
        inAFunctionCallDefAppFunction(node);
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAFunctionCallDefAppFunction(node);
    }

    public void inAListExpressionLe(AListExpressionLe node)
    {
        defaultIn(node);
    }

    public void outAListExpressionLe(AListExpressionLe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListExpressionLe(AListExpressionLe node)
    {
        inAListExpressionLe(node);
        if(node.getEBis() != null)
        {
            node.getEBis().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        outAListExpressionLe(node);
    }

    public void inALe(ALe node)
    {
        defaultIn(node);
    }

    public void outALe(ALe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALe(ALe node)
    {
        inALe(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outALe(node);
    }

    public void inAMultipleElementsEBis(AMultipleElementsEBis node)
    {
        defaultIn(node);
    }

    public void outAMultipleElementsEBis(AMultipleElementsEBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultipleElementsEBis(AMultipleElementsEBis node)
    {
        inAMultipleElementsEBis(node);
        if(node.getEBis() != null)
        {
            node.getEBis().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outAMultipleElementsEBis(node);
    }

    public void inAEBis(AEBis node)
    {
        defaultIn(node);
    }

    public void outAEBis(AEBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEBis(AEBis node)
    {
        inAEBis(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outAEBis(node);
    }

    public void inAAffectationI(AAffectationI node)
    {
        defaultIn(node);
    }

    public void outAAffectationI(AAffectationI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAffectationI(AAffectationI node)
    {
        inAAffectationI(node);
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAAffectationI(node);
    }

    public void inAIfI(AIfI node)
    {
        defaultIn(node);
    }

    public void outAIfI(AIfI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfI(AIfI node)
    {
        inAIfI(node);
        if(node.getElseBlock() != null)
        {
            node.getElseBlock().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfI(node);
    }

    public void inAWhileI(AWhileI node)
    {
        defaultIn(node);
    }

    public void outAWhileI(AWhileI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWhileI(AWhileI node)
    {
        inAWhileI(node);
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getTq() != null)
        {
            node.getTq().apply(this);
        }
        outAWhileI(node);
    }

    public void inARetI(ARetI node)
    {
        defaultIn(node);
    }

    public void outARetI(ARetI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARetI(ARetI node)
    {
        inARetI(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
        }
        outARetI(node);
    }

    public void inAFunctionCallI(AFunctionCallI node)
    {
        defaultIn(node);
    }

    public void outAFunctionCallI(AFunctionCallI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFunctionCallI(AFunctionCallI node)
    {
        inAFunctionCallI(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAFunctionCallI(node);
    }

    public void inAWriteI(AWriteI node)
    {
        defaultIn(node);
    }

    public void outAWriteI(AWriteI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWriteI(AWriteI node)
    {
        inAWriteI(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        outAWriteI(node);
    }

    public void inAElseElseBlock(AElseElseBlock node)
    {
        defaultIn(node);
    }

    public void outAElseElseBlock(AElseElseBlock node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseElseBlock(AElseElseBlock node)
    {
        inAElseElseBlock(node);
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        outAElseElseBlock(node);
    }

    public void inAElseBlock(AElseBlock node)
    {
        defaultIn(node);
    }

    public void outAElseBlock(AElseBlock node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseBlock(AElseBlock node)
    {
        inAElseBlock(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outAElseBlock(node);
    }

    public void inABlocInstructionBi(ABlocInstructionBi node)
    {
        defaultIn(node);
    }

    public void outABlocInstructionBi(ABlocInstructionBi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABlocInstructionBi(ABlocInstructionBi node)
    {
        inABlocInstructionBi(node);
        if(node.getAf() != null)
        {
            node.getAf().apply(this);
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        if(node.getAo() != null)
        {
            node.getAo().apply(this);
        }
        outABlocInstructionBi(node);
    }

    public void inAListInstructionLi(AListInstructionLi node)
    {
        defaultIn(node);
    }

    public void outAListInstructionLi(AListInstructionLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListInstructionLi(AListInstructionLi node)
    {
        inAListInstructionLi(node);
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        outAListInstructionLi(node);
    }

    public void inAInstructionSuivIBis(AInstructionSuivIBis node)
    {
        defaultIn(node);
    }

    public void outAInstructionSuivIBis(AInstructionSuivIBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstructionSuivIBis(AInstructionSuivIBis node)
    {
        inAInstructionSuivIBis(node);
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        outAInstructionSuivIBis(node);
    }

    public void inAIBis(AIBis node)
    {
        defaultIn(node);
    }

    public void outAIBis(AIBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIBis(AIBis node)
    {
        inAIBis(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outAIBis(node);
    }

    public void inAFormProgProgramme(AFormProgProgramme node)
    {
        defaultIn(node);
    }

    public void outAFormProgProgramme(AFormProgProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFormProgProgramme(AFormProgProgramme node)
    {
        inAFormProgProgramme(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getLdvOptional() != null)
        {
            node.getLdvOptional().apply(this);
        }
        outAFormProgProgramme(node);
    }

    public void inALFoncLdf(ALFoncLdf node)
    {
        defaultIn(node);
    }

    public void outALFoncLdf(ALFoncLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALFoncLdf(ALFoncLdf node)
    {
        inALFoncLdf(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        outALFoncLdf(node);
    }

    public void inALdf(ALdf node)
    {
        defaultIn(node);
    }

    public void outALdf(ALdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdf(ALdf node)
    {
        inALdf(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outALdf(node);
    }

    public void inAFoncDf(AFoncDf node)
    {
        defaultIn(node);
    }

    public void outAFoncDf(AFoncDf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFoncDf(AFoncDf node)
    {
        inAFoncDf(node);
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getLdvOptional() != null)
        {
            node.getLdvOptional().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAFoncDf(node);
    }

    public void inAOptVarLdvOptional(AOptVarLdvOptional node)
    {
        defaultIn(node);
    }

    public void outAOptVarLdvOptional(AOptVarLdvOptional node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOptVarLdvOptional(AOptVarLdvOptional node)
    {
        inAOptVarLdvOptional(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        outAOptVarLdvOptional(node);
    }

    public void inALdvOptional(ALdvOptional node)
    {
        defaultIn(node);
    }

    public void outALdvOptional(ALdvOptional node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdvOptional(ALdvOptional node)
    {
        inALdvOptional(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outALdvOptional(node);
    }

    public void inALVarLdv(ALVarLdv node)
    {
        defaultIn(node);
    }

    public void outALVarLdv(ALVarLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALVarLdv(ALVarLdv node)
    {
        inALVarLdv(node);
        if(node.getLdvBis() != null)
        {
            node.getLdvBis().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        outALVarLdv(node);
    }

    public void inALdv(ALdv node)
    {
        defaultIn(node);
    }

    public void outALdv(ALdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdv(ALdv node)
    {
        inALdv(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outALdv(node);
    }

    public void inAVarDv(AVarDv node)
    {
        defaultIn(node);
    }

    public void outAVarDv(AVarDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarDv(AVarDv node)
    {
        inAVarDv(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAVarDv(node);
    }

    public void inADv(ADv node)
    {
        defaultIn(node);
    }

    public void outADv(ADv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADv(ADv node)
    {
        inADv(node);
        if(node.getCf() != null)
        {
            node.getCf().apply(this);
        }
        if(node.getNb() != null)
        {
            node.getNb().apply(this);
        }
        if(node.getCo() != null)
        {
            node.getCo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outADv(node);
    }

    public void inALVarAfterCommaLdvBis(ALVarAfterCommaLdvBis node)
    {
        defaultIn(node);
    }

    public void outALVarAfterCommaLdvBis(ALVarAfterCommaLdvBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALVarAfterCommaLdvBis(ALVarAfterCommaLdvBis node)
    {
        inALVarAfterCommaLdvBis(node);
        if(node.getLdvBis() != null)
        {
            node.getLdvBis().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        outALVarAfterCommaLdvBis(node);
    }

    public void inALdvBis(ALdvBis node)
    {
        defaultIn(node);
    }

    public void outALdvBis(ALdvBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdvBis(ALdvBis node)
    {
        inALdvBis(node);
        if(node.getEps() != null)
        {
            node.getEps().apply(this);
        }
        outALdvBis(node);
    }
}
