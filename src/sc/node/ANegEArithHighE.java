/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ANegEArithHighE extends PArithHighE
{
    private PNegE _negE_;

    public ANegEArithHighE()
    {
        // Constructor
    }

    public ANegEArithHighE(
        @SuppressWarnings("hiding") PNegE _negE_)
    {
        // Constructor
        setNegE(_negE_);

    }

    @Override
    public Object clone()
    {
        return new ANegEArithHighE(
            cloneNode(this._negE_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANegEArithHighE(this);
    }

    public PNegE getNegE()
    {
        return this._negE_;
    }

    public void setNegE(PNegE node)
    {
        if(this._negE_ != null)
        {
            this._negE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._negE_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._negE_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._negE_ == child)
        {
            this._negE_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._negE_ == oldChild)
        {
            setNegE((PNegE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}