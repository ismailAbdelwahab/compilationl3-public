/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AElseI extends PI
{
    private TElse _else_;
    private PBi _bi_;

    public AElseI()
    {
        // Constructor
    }

    public AElseI(
        @SuppressWarnings("hiding") TElse _else_,
        @SuppressWarnings("hiding") PBi _bi_)
    {
        // Constructor
        setElse(_else_);

        setBi(_bi_);

    }

    @Override
    public Object clone()
    {
        return new AElseI(
            cloneNode(this._else_),
            cloneNode(this._bi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAElseI(this);
    }

    public TElse getElse()
    {
        return this._else_;
    }

    public void setElse(TElse node)
    {
        if(this._else_ != null)
        {
            this._else_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._else_ = node;
    }

    public PBi getBi()
    {
        return this._bi_;
    }

    public void setBi(PBi node)
    {
        if(this._bi_ != null)
        {
            this._bi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._bi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._else_)
            + toString(this._bi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._else_ == child)
        {
            this._else_ = null;
            return;
        }

        if(this._bi_ == child)
        {
            this._bi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._else_ == oldChild)
        {
            setElse((TElse) newChild);
            return;
        }

        if(this._bi_ == oldChild)
        {
            setBi((PBi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
