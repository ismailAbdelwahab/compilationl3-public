/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AParenthENegE extends PNegE
{
    private PParenthE _parenthE_;

    public AParenthENegE()
    {
        // Constructor
    }

    public AParenthENegE(
        @SuppressWarnings("hiding") PParenthE _parenthE_)
    {
        // Constructor
        setParenthE(_parenthE_);

    }

    @Override
    public Object clone()
    {
        return new AParenthENegE(
            cloneNode(this._parenthE_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParenthENegE(this);
    }

    public PParenthE getParenthE()
    {
        return this._parenthE_;
    }

    public void setParenthE(PParenthE node)
    {
        if(this._parenthE_ != null)
        {
            this._parenthE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parenthE_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._parenthE_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parenthE_ == child)
        {
            this._parenthE_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parenthE_ == oldChild)
        {
            setParenthE((PParenthE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
