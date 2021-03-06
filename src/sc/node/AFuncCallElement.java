/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AFuncCallElement extends PElement
{
    private PAppFunction _appFunction_;

    public AFuncCallElement()
    {
        // Constructor
    }

    public AFuncCallElement(
        @SuppressWarnings("hiding") PAppFunction _appFunction_)
    {
        // Constructor
        setAppFunction(_appFunction_);

    }

    @Override
    public Object clone()
    {
        return new AFuncCallElement(
            cloneNode(this._appFunction_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncCallElement(this);
    }

    public PAppFunction getAppFunction()
    {
        return this._appFunction_;
    }

    public void setAppFunction(PAppFunction node)
    {
        if(this._appFunction_ != null)
        {
            this._appFunction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._appFunction_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._appFunction_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._appFunction_ == child)
        {
            this._appFunction_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._appFunction_ == oldChild)
        {
            setAppFunction((PAppFunction) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
