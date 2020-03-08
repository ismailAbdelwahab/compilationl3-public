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
        node.getPProgramme().apply(this);
        outStart(node);
    }

    public void inAProgProgramme(AProgProgramme node)
    {
        defaultIn(node);
    }

    public void outAProgProgramme(AProgProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProgProgramme(AProgProgramme node)
    {
        inAProgProgramme(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getLdvOptional() != null)
        {
            node.getLdvOptional().apply(this);
        }
        outAProgProgramme(node);
    }

    public void inARegularLdf(ARegularLdf node)
    {
        defaultIn(node);
    }

    public void outARegularLdf(ARegularLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLdf(ARegularLdf node)
    {
        inARegularLdf(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        outARegularLdf(node);
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

    public void inARegularDf(ARegularDf node)
    {
        defaultIn(node);
    }

    public void outARegularDf(ARegularDf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularDf(ARegularDf node)
    {
        inARegularDf(node);
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
        outARegularDf(node);
    }

    public void inARegularLdvOptional(ARegularLdvOptional node)
    {
        defaultIn(node);
    }

    public void outARegularLdvOptional(ARegularLdvOptional node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLdvOptional(ARegularLdvOptional node)
    {
        inARegularLdvOptional(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        outARegularLdvOptional(node);
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

    public void inARegularLdv(ARegularLdv node)
    {
        defaultIn(node);
    }

    public void outARegularLdv(ARegularLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLdv(ARegularLdv node)
    {
        inARegularLdv(node);
        if(node.getLdvBis() != null)
        {
            node.getLdvBis().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        outARegularLdv(node);
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

    public void inARegularLdvBis(ARegularLdvBis node)
    {
        defaultIn(node);
    }

    public void outARegularLdvBis(ARegularLdvBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLdvBis(ARegularLdvBis node)
    {
        inARegularLdvBis(node);
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
        outARegularLdvBis(node);
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

    public void inARegularVariableDv(ARegularVariableDv node)
    {
        defaultIn(node);
    }

    public void outARegularVariableDv(ARegularVariableDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularVariableDv(ARegularVariableDv node)
    {
        inARegularVariableDv(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        outARegularVariableDv(node);
    }

    public void inARegularArrayDv(ARegularArrayDv node)
    {
        defaultIn(node);
    }

    public void outARegularArrayDv(ARegularArrayDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularArrayDv(ARegularArrayDv node)
    {
        inARegularArrayDv(node);
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
        if(node.getVarType() != null)
        {
            node.getVarType().apply(this);
        }
        outARegularArrayDv(node);
    }

    public void inARegularBi(ARegularBi node)
    {
        defaultIn(node);
    }

    public void outARegularBi(ARegularBi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularBi(ARegularBi node)
    {
        inARegularBi(node);
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
        outARegularBi(node);
    }

    public void inARegularLi(ARegularLi node)
    {
        defaultIn(node);
    }

    public void outARegularLi(ARegularLi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLi(ARegularLi node)
    {
        inARegularLi(node);
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        outARegularLi(node);
    }

    public void inARegularIBis(ARegularIBis node)
    {
        defaultIn(node);
    }

    public void outARegularIBis(ARegularIBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularIBis(ARegularIBis node)
    {
        inARegularIBis(node);
        if(node.getIBis() != null)
        {
            node.getIBis().apply(this);
        }
        if(node.getI() != null)
        {
            node.getI().apply(this);
        }
        outARegularIBis(node);
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

    public void inAAffectI(AAffectI node)
    {
        defaultIn(node);
    }

    public void outAAffectI(AAffectI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAffectI(AAffectI node)
    {
        inAAffectI(node);
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getEqual() != null)
        {
            node.getEqual().apply(this);
        }
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAAffectI(node);
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
        if(node.getWhile() != null)
        {
            node.getWhile().apply(this);
        }
        outAWhileI(node);
    }

    public void inAReturnI(AReturnI node)
    {
        defaultIn(node);
    }

    public void outAReturnI(AReturnI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAReturnI(AReturnI node)
    {
        inAReturnI(node);
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
        outAReturnI(node);
    }

    public void inAFuncCallI(AFuncCallI node)
    {
        defaultIn(node);
    }

    public void outAFuncCallI(AFuncCallI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncCallI(AFuncCallI node)
    {
        inAFuncCallI(node);
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
        outAFuncCallI(node);
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
        if(node.getWrite() != null)
        {
            node.getWrite().apply(this);
        }
        outAWriteI(node);
    }

    public void inARegularVarI(ARegularVarI node)
    {
        defaultIn(node);
    }

    public void outARegularVarI(ARegularVarI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularVarI(ARegularVarI node)
    {
        inARegularVarI(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outARegularVarI(node);
    }

    public void inAArrayVarI(AArrayVarI node)
    {
        defaultIn(node);
    }

    public void outAArrayVarI(AArrayVarI node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayVarI(AArrayVarI node)
    {
        inAArrayVarI(node);
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
        outAArrayVarI(node);
    }

    public void inARegularElseBlock(ARegularElseBlock node)
    {
        defaultIn(node);
    }

    public void outARegularElseBlock(ARegularElseBlock node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularElseBlock(ARegularElseBlock node)
    {
        inARegularElseBlock(node);
        if(node.getBi() != null)
        {
            node.getBi().apply(this);
        }
        if(node.getElse() != null)
        {
            node.getElse().apply(this);
        }
        outARegularElseBlock(node);
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

    public void inARegularE(ARegularE node)
    {
        defaultIn(node);
    }

    public void outARegularE(ARegularE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularE(ARegularE node)
    {
        inARegularE(node);
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
        outARegularE(node);
    }

    public void inAPassE(APassE node)
    {
        defaultIn(node);
    }

    public void outAPassE(APassE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassE(APassE node)
    {
        inAPassE(node);
        if(node.getAndE() != null)
        {
            node.getAndE().apply(this);
        }
        outAPassE(node);
    }

    public void inARegularAndE(ARegularAndE node)
    {
        defaultIn(node);
    }

    public void outARegularAndE(ARegularAndE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularAndE(ARegularAndE node)
    {
        inARegularAndE(node);
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
        outARegularAndE(node);
    }

    public void inAPassAndE(APassAndE node)
    {
        defaultIn(node);
    }

    public void outAPassAndE(APassAndE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassAndE(APassAndE node)
    {
        inAPassAndE(node);
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        outAPassAndE(node);
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
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        if(node.getLowerThan() != null)
        {
            node.getLowerThan().apply(this);
        }
        if(node.getCompE() != null)
        {
            node.getCompE().apply(this);
        }
        outALowerThanCompE(node);
    }

    public void inAPassCompE(APassCompE node)
    {
        defaultIn(node);
    }

    public void outAPassCompE(APassCompE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassCompE(APassCompE node)
    {
        inAPassCompE(node);
        if(node.getArithLowE() != null)
        {
            node.getArithLowE().apply(this);
        }
        outAPassCompE(node);
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

    public void inAPassArithLowE(APassArithLowE node)
    {
        defaultIn(node);
    }

    public void outAPassArithLowE(APassArithLowE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassArithLowE(APassArithLowE node)
    {
        inAPassArithLowE(node);
        if(node.getArithHighE() != null)
        {
            node.getArithHighE().apply(this);
        }
        outAPassArithLowE(node);
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

    public void inAPassArithHighE(APassArithHighE node)
    {
        defaultIn(node);
    }

    public void outAPassArithHighE(APassArithHighE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassArithHighE(APassArithHighE node)
    {
        inAPassArithHighE(node);
        if(node.getNegE() != null)
        {
            node.getNegE().apply(this);
        }
        outAPassArithHighE(node);
    }

    public void inARegularNegE(ARegularNegE node)
    {
        defaultIn(node);
    }

    public void outARegularNegE(ARegularNegE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularNegE(ARegularNegE node)
    {
        inARegularNegE(node);
        if(node.getParenthE() != null)
        {
            node.getParenthE().apply(this);
        }
        if(node.getNot() != null)
        {
            node.getNot().apply(this);
        }
        outARegularNegE(node);
    }

    public void inAPassNegE(APassNegE node)
    {
        defaultIn(node);
    }

    public void outAPassNegE(APassNegE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassNegE(APassNegE node)
    {
        inAPassNegE(node);
        if(node.getParenthE() != null)
        {
            node.getParenthE().apply(this);
        }
        outAPassNegE(node);
    }

    public void inARegularParenthE(ARegularParenthE node)
    {
        defaultIn(node);
    }

    public void outARegularParenthE(ARegularParenthE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularParenthE(ARegularParenthE node)
    {
        inARegularParenthE(node);
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
        outARegularParenthE(node);
    }

    public void inAPassParenthE(APassParenthE node)
    {
        defaultIn(node);
    }

    public void outAPassParenthE(APassParenthE node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPassParenthE(APassParenthE node)
    {
        inAPassParenthE(node);
        if(node.getElement() != null)
        {
            node.getElement().apply(this);
        }
        outAPassParenthE(node);
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

    public void inAVariableElement(AVariableElement node)
    {
        defaultIn(node);
    }

    public void outAVariableElement(AVariableElement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVariableElement(AVariableElement node)
    {
        inAVariableElement(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVariableElement(node);
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
        if(node.getRead() != null)
        {
            node.getRead().apply(this);
        }
        outAReadElement(node);
    }

    public void inAFuncCallElement(AFuncCallElement node)
    {
        defaultIn(node);
    }

    public void outAFuncCallElement(AFuncCallElement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFuncCallElement(AFuncCallElement node)
    {
        inAFuncCallElement(node);
        if(node.getAppFunction() != null)
        {
            node.getAppFunction().apply(this);
        }
        outAFuncCallElement(node);
    }

    public void inARegularVar(ARegularVar node)
    {
        defaultIn(node);
    }

    public void outARegularVar(ARegularVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularVar(ARegularVar node)
    {
        inARegularVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outARegularVar(node);
    }

    public void inAArrayVar(AArrayVar node)
    {
        defaultIn(node);
    }

    public void outAArrayVar(AArrayVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayVar(AArrayVar node)
    {
        inAArrayVar(node);
        if(node.getCf() != null)
        {
            node.getCf().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        if(node.getCo() != null)
        {
            node.getCo().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAArrayVar(node);
    }

    public void inARegularAppFunction(ARegularAppFunction node)
    {
        defaultIn(node);
    }

    public void outARegularAppFunction(ARegularAppFunction node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularAppFunction(ARegularAppFunction node)
    {
        inARegularAppFunction(node);
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
        outARegularAppFunction(node);
    }

    public void inARegularLe(ARegularLe node)
    {
        defaultIn(node);
    }

    public void outARegularLe(ARegularLe node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularLe(ARegularLe node)
    {
        inARegularLe(node);
        if(node.getEBis() != null)
        {
            node.getEBis().apply(this);
        }
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        outARegularLe(node);
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

    public void inARegularEBis(ARegularEBis node)
    {
        defaultIn(node);
    }

    public void outARegularEBis(ARegularEBis node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARegularEBis(ARegularEBis node)
    {
        inARegularEBis(node);
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
        outARegularEBis(node);
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
