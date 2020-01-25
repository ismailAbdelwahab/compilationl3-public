/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
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
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
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
        if(node.getLdvOptional() != null)
        {
            node.getLdvOptional().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outAFormProgProgramme(node);
    }

    public void inAListFuncLdf(AListFuncLdf node)
    {
        defaultIn(node);
    }

    public void outAListFuncLdf(AListFuncLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListFuncLdf(AListFuncLdf node)
    {
        inAListFuncLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outAListFuncLdf(node);
    }

    public void inAEpsLdf(AEpsLdf node)
    {
        defaultIn(node);
    }

    public void outAEpsLdf(AEpsLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsLdf(AEpsLdf node)
    {
        inAEpsLdf(node);
        outAEpsLdf(node);
    }

    public void inADefFuncDf(ADefFuncDf node)
    {
        defaultIn(node);
    }

    public void outADefFuncDf(ADefFuncDf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefFuncDf(ADefFuncDf node)
    {
        inADefFuncDf(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getLdvOptional() != null)
        {
            node.getLdvOptional().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        outADefFuncDf(node);
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
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        outAOptVarLdvOptional(node);
    }

    public void inAEpsLdvOptional(AEpsLdvOptional node)
    {
        defaultIn(node);
    }

    public void outAEpsLdvOptional(AEpsLdvOptional node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsLdvOptional(AEpsLdvOptional node)
    {
        inAEpsLdvOptional(node);
        outAEpsLdvOptional(node);
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
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvBis() != null)
        {
            node.getLdvBis().apply(this);
        }
        outALVarLdv(node);
    }

    public void inAEpsLdv(AEpsLdv node)
    {
        defaultIn(node);
    }

    public void outAEpsLdv(AEpsLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsLdv(AEpsLdv node)
    {
        inAEpsLdv(node);
        outAEpsLdv(node);
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
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvBis() != null)
        {
            node.getLdvBis().apply(this);
        }
        outALVarAfterCommaLdvBis(node);
    }

    public void inAEpsLdvBis(AEpsLdvBis node)
    {
        defaultIn(node);
    }

    public void outAEpsLdvBis(AEpsLdvBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsLdvBis(AEpsLdvBis node)
    {
        inAEpsLdvBis(node);
        outAEpsLdvBis(node);
    }

    public void inADefVarDv(ADefVarDv node)
    {
        defaultIn(node);
    }

    public void outADefVarDv(ADefVarDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefVarDv(ADefVarDv node)
    {
        inADefVarDv(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outADefVarDv(node);
    }

    public void inADefVarArrayDv(ADefVarArrayDv node)
    {
        defaultIn(node);
    }

    public void outADefVarArrayDv(ADefVarArrayDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefVarArrayDv(ADefVarArrayDv node)
    {
        inADefVarArrayDv(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getCo() != null)
        {
            node.getCo().apply(this);
        }
        if(node.getNb() != null)
        {
            node.getNb().apply(this);
        }
        if(node.getCf() != null)
        {
            node.getCf().apply(this);
        }
        outADefVarArrayDv(node);
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
        if(node.getAo() != null)
        {
            node.getAo().apply(this);
        }
        if(node.getLi() != null)
        {
            node.getLi().apply(this);
        }
        if(node.getAf() != null)
        {
            node.getAf().apply(this);
        }
        outABlocInstructionBi(node);
    }

    public void inAListInstructionsLi(AListInstructionsLi node)
    {
        defaultIn(node);
    }

    public void outAListInstructionsLi(AListInstructionsLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListInstructionsLi(AListInstructionsLi node)
    {
        inAListInstructionsLi(node);
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        outAListInstructionsLi(node);
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
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        outAInstructionSuivIBis(node);
    }

    public void inAEpsIBis(AEpsIBis node)
    {
        defaultIn(node);
    }

    public void outAEpsIBis(AEpsIBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsIBis(AEpsIBis node)
    {
        inAEpsIBis(node);
        outAEpsIBis(node);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
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
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getThen() != null)
        {
            node.getThen().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getElseBlock() != null)
        {
            node.getElseBlock().apply(this);
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
        if(node.getTq() != null)
        {
            node.getTq().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getDo() != null)
        {
            node.getDo().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
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
        if(node.getReturn() != null)
        {
            node.getReturn().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
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
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
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
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
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
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        outAElseElseBlock(node);
    }

    public void inAEpsElseBlock(AEpsElseBlock node)
    {
        defaultIn(node);
    }

    public void outAEpsElseBlock(AEpsElseBlock node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsElseBlock(AEpsElseBlock node)
    {
        inAEpsElseBlock(node);
        outAEpsElseBlock(node);
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
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getOr() != null)
        {
            node.getOr().apply(this);
        }
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
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
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
        }
        if(node.getAnd() != null)
        {
            node.getAnd().apply(this);
        }
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
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
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outAEqualCompE(node);
    }

    public void inALowerThanCompE(ALowerThanCompE node)
    {
        defaultIn(node);
    }

    public void outALowerThanCompE(ALowerThanCompE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALowerThanCompE(ALowerThanCompE node)
    {
        inALowerThanCompE(node);
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        if(node.getLowerThan() != null)
        {
            node.getLowerThan().apply(this);
        }
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outALowerThanCompE(node);
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
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
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
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
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
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
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
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
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
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        if(node.getParenthE() != null)
        {
            node.getParenthE().apply(this);
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
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getElement() != null)
        {
            node.getElement().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
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
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        outAReadElement(node);
    }

    public void inADefFunctionCallAppFunction(ADefFunctionCallAppFunction node)
    {
        defaultIn(node);
    }

    public void outADefFunctionCallAppFunction(ADefFunctionCallAppFunction node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADefFunctionCallAppFunction(ADefFunctionCallAppFunction node)
    {
        inADefFunctionCallAppFunction(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPo() != null)
        {
            node.getPo().apply(this);
        }
        if(node.getLe() != null)
        {
            node.getLe().apply(this);
        }
        if(node.getPf() != null)
        {
            node.getPf().apply(this);
        }
        outADefFunctionCallAppFunction(node);
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
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getEBis() != null)
        {
            node.getEBis().apply(this);
        }
        outAListExpressionLe(node);
    }

    public void inAEpsLe(AEpsLe node)
    {
        defaultIn(node);
    }

    public void outAEpsLe(AEpsLe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsLe(AEpsLe node)
    {
        inAEpsLe(node);
        outAEpsLe(node);
    }

    public void inAExpressionAfterCommaEBis(AExpressionAfterCommaEBis node)
    {
        defaultIn(node);
    }

    public void outAExpressionAfterCommaEBis(AExpressionAfterCommaEBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpressionAfterCommaEBis(AExpressionAfterCommaEBis node)
    {
        inAExpressionAfterCommaEBis(node);
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getEBis() != null)
        {
            node.getEBis().apply(this);
        }
        outAExpressionAfterCommaEBis(node);
    }

    public void inAEpsEBis(AEpsEBis node)
    {
        defaultIn(node);
    }

    public void outAEpsEBis(AEpsEBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEpsEBis(AEpsEBis node)
    {
        inAEpsEBis(node);
        outAEpsEBis(node);
    }
}
