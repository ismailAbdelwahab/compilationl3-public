/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class TVarType extends Token
{
    public TVarType()
    {
        super.setText("entier");
    }

    public TVarType(int line, int pos)
    {
        super.setText("entier");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TVarType(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTVarType(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TVarType text.");
    }
}