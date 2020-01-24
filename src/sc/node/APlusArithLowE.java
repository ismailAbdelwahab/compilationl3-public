/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class APlusArithLowE extends PArithLowE
{
    private PArithLowE _arithLowE_;
    private TPlus _plus_;
    private PArithHighE _arithHighE_;

    public APlusArithLowE()
    {
        // Constructor
    }

    public APlusArithLowE(
        @SuppressWarnings("hiding") PArithLowE _arithLowE_,
        @SuppressWarnings("hiding") TPlus _plus_,
        @SuppressWarnings("hiding") PArithHighE _arithHighE_)
    {
        // Constructor
        setArithLowE(_arithLowE_);

        setPlus(_plus_);

        setArithHighE(_arithHighE_);

    }

    @Override
    public Object clone()
    {
        return new APlusArithLowE(
            cloneNode(this._arithLowE_),
            cloneNode(this._plus_),
            cloneNode(this._arithHighE_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPlusArithLowE(this);
    }

    public PArithLowE getArithLowE()
    {
        return this._arithLowE_;
    }

    public void setArithLowE(PArithLowE node)
    {
        if(this._arithLowE_ != null)
        {
            this._arithLowE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arithLowE_ = node;
    }

    public TPlus getPlus()
    {
        return this._plus_;
    }

    public void setPlus(TPlus node)
    {
        if(this._plus_ != null)
        {
            this._plus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._plus_ = node;
    }

    public PArithHighE getArithHighE()
    {
        return this._arithHighE_;
    }

    public void setArithHighE(PArithHighE node)
    {
        if(this._arithHighE_ != null)
        {
            this._arithHighE_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arithHighE_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arithLowE_)
            + toString(this._plus_)
            + toString(this._arithHighE_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arithLowE_ == child)
        {
            this._arithLowE_ = null;
            return;
        }

        if(this._plus_ == child)
        {
            this._plus_ = null;
            return;
        }

        if(this._arithHighE_ == child)
        {
            this._arithHighE_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arithLowE_ == oldChild)
        {
            setArithLowE((PArithLowE) newChild);
            return;
        }

        if(this._plus_ == oldChild)
        {
            setPlus((TPlus) newChild);
            return;
        }

        if(this._arithHighE_ == oldChild)
        {
            setArithHighE((PArithHighE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
