/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ALowerThanCompE extends PCompE
{
    private PCompE _compE_;
    private TLowerThan _lowerThan_;
    private PArithLowE _arithLowE_;

    public ALowerThanCompE()
    {
        // Constructor
    }

    public ALowerThanCompE(
        @SuppressWarnings("hiding") PCompE _compE_,
        @SuppressWarnings("hiding") TLowerThan _lowerThan_,
        @SuppressWarnings("hiding") PArithLowE _arithLowE_)
    {
        // Constructor
        setCompE(_compE_);

        setLowerThan(_lowerThan_);

        setArithLowE(_arithLowE_);

    }

    @Override
    public Object clone()
    {
        return new ALowerThanCompE(
            cloneNode(this._compE_),
            cloneNode(this._lowerThan_),
            cloneNode(this._arithLowE_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALowerThanCompE(this);
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

    public TLowerThan getLowerThan()
    {
        return this._lowerThan_;
    }

    public void setLowerThan(TLowerThan node)
    {
        if(this._lowerThan_ != null)
        {
            this._lowerThan_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lowerThan_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._compE_)
            + toString(this._lowerThan_)
            + toString(this._arithLowE_);
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

        if(this._lowerThan_ == child)
        {
            this._lowerThan_ = null;
            return;
        }

        if(this._arithLowE_ == child)
        {
            this._arithLowE_ = null;
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

        if(this._lowerThan_ == oldChild)
        {
            setLowerThan((TLowerThan) newChild);
            return;
        }

        if(this._arithLowE_ == oldChild)
        {
            setArithLowE((PArithLowE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
