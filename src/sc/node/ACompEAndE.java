/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ACompEAndE extends PAndE
{
    private PCompE _compE_;

    public ACompEAndE()
    {
        // Constructor
    }

    public ACompEAndE(
        @SuppressWarnings("hiding") PCompE _compE_)
    {
        // Constructor
        setCompE(_compE_);

    }

    @Override
    public Object clone()
    {
        return new ACompEAndE(
            cloneNode(this._compE_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACompEAndE(this);
    }

    public PCompE getCompE()
    {
        return this._compE_;
    }

    public void setCompE(PCompE node)
    {
        if(this._compE_ != null)
        {
            this._compE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._compE_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._compE_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._compE_ == child)
        {
            this._compE_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._compE_ == oldChild)
        {
            setCompE((PCompE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}