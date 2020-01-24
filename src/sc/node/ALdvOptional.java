/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ALdvOptional extends PLdvOptional
{
    private TEps _eps_;

    public ALdvOptional()
    {
        // Constructor
    }

    public ALdvOptional(
        @SuppressWarnings("hiding") TEps _eps_)
    {
        // Constructor
        setEps(_eps_);

    }

    @Override
    public Object clone()
    {
        return new ALdvOptional(
            cloneNode(this._eps_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALdvOptional(this);
    }

    public TEps getEps()
    {
        return this._eps_;
    }

    public void setEps(TEps node)
    {
        if(this._eps_ != null)
        {
            this._eps_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eps_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._eps_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._eps_ == child)
        {
            this._eps_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._eps_ == oldChild)
        {
            setEps((TEps) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}