/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.parser;

import sc.node.*;
import sc.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTId(@SuppressWarnings("unused") TId node)
    {
        this.index = 0;
    }

    @Override
    public void caseTNb(@SuppressWarnings("unused") TNb node)
    {
        this.index = 1;
    }

    @Override
    public void caseTPo(@SuppressWarnings("unused") TPo node)
    {
        this.index = 2;
    }

    @Override
    public void caseTPf(@SuppressWarnings("unused") TPf node)
    {
        this.index = 3;
    }

    @Override
    public void caseTCo(@SuppressWarnings("unused") TCo node)
    {
        this.index = 4;
    }

    @Override
    public void caseTCf(@SuppressWarnings("unused") TCf node)
    {
        this.index = 5;
    }

    @Override
    public void caseTAo(@SuppressWarnings("unused") TAo node)
    {
        this.index = 6;
    }

    @Override
    public void caseTAf(@SuppressWarnings("unused") TAf node)
    {
        this.index = 7;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 8;
    }

    @Override
    public void caseTSemicolon(@SuppressWarnings("unused") TSemicolon node)
    {
        this.index = 9;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 10;
    }

    @Override
    public void caseTAnd(@SuppressWarnings("unused") TAnd node)
    {
        this.index = 11;
    }

    @Override
    public void caseTOr(@SuppressWarnings("unused") TOr node)
    {
        this.index = 12;
    }

    @Override
    public void caseTNot(@SuppressWarnings("unused") TNot node)
    {
        this.index = 13;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 14;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 15;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 16;
    }

    @Override
    public void caseTEqual(@SuppressWarnings("unused") TEqual node)
    {
        this.index = 17;
    }

    @Override
    public void caseTLowerThan(@SuppressWarnings("unused") TLowerThan node)
    {
        this.index = 18;
    }

    @Override
    public void caseTInt(@SuppressWarnings("unused") TInt node)
    {
        this.index = 19;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 20;
    }

    @Override
    public void caseTThen(@SuppressWarnings("unused") TThen node)
    {
        this.index = 21;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 22;
    }

    @Override
    public void caseTTq(@SuppressWarnings("unused") TTq node)
    {
        this.index = 23;
    }

    @Override
    public void caseTDo(@SuppressWarnings("unused") TDo node)
    {
        this.index = 24;
    }

    @Override
    public void caseTLire(@SuppressWarnings("unused") TLire node)
    {
        this.index = 25;
    }

    @Override
    public void caseTEcrire(@SuppressWarnings("unused") TEcrire node)
    {
        this.index = 26;
    }

    @Override
    public void caseTReturn(@SuppressWarnings("unused") TReturn node)
    {
        this.index = 27;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 28;
    }
}
