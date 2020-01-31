/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AAffectInArrayI extends PI
{
    private TId _id_;
    private TCo _co_;
    private TNb _nb_;
    private TCf _cf_;
    private TEqual _equal_;
    private PE _e_;
    private TSemicolon _semicolon_;

    public AAffectInArrayI()
    {
        // Constructor
    }

    public AAffectInArrayI(
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TCo _co_,
        @SuppressWarnings("hiding") TNb _nb_,
        @SuppressWarnings("hiding") TCf _cf_,
        @SuppressWarnings("hiding") TEqual _equal_,
        @SuppressWarnings("hiding") PE _e_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setId(_id_);

        setCo(_co_);

        setNb(_nb_);

        setCf(_cf_);

        setEqual(_equal_);

        setE(_e_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new AAffectInArrayI(
            cloneNode(this._id_),
            cloneNode(this._co_),
            cloneNode(this._nb_),
            cloneNode(this._cf_),
            cloneNode(this._equal_),
            cloneNode(this._e_),
            cloneNode(this._semicolon_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAffectInArrayI(this);
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    public TCo getCo()
    {
        return this._co_;
    }

    public void setCo(TCo node)
    {
        if(this._co_ != null)
        {
            this._co_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._co_ = node;
    }

    public TNb getNb()
    {
        return this._nb_;
    }

    public void setNb(TNb node)
    {
        if(this._nb_ != null)
        {
            this._nb_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nb_ = node;
    }

    public TCf getCf()
    {
        return this._cf_;
    }

    public void setCf(TCf node)
    {
        if(this._cf_ != null)
        {
            this._cf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cf_ = node;
    }

    public TEqual getEqual()
    {
        return this._equal_;
    }

    public void setEqual(TEqual node)
    {
        if(this._equal_ != null)
        {
            this._equal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equal_ = node;
    }

    public PE getE()
    {
        return this._e_;
    }

    public void setE(PE node)
    {
        if(this._e_ != null)
        {
            this._e_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._id_)
            + toString(this._co_)
            + toString(this._nb_)
            + toString(this._cf_)
            + toString(this._equal_)
            + toString(this._e_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        if(this._co_ == child)
        {
            this._co_ = null;
            return;
        }

        if(this._nb_ == child)
        {
            this._nb_ = null;
            return;
        }

        if(this._cf_ == child)
        {
            this._cf_ = null;
            return;
        }

        if(this._equal_ == child)
        {
            this._equal_ = null;
            return;
        }

        if(this._e_ == child)
        {
            this._e_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(this._co_ == oldChild)
        {
            setCo((TCo) newChild);
            return;
        }

        if(this._nb_ == oldChild)
        {
            setNb((TNb) newChild);
            return;
        }

        if(this._cf_ == oldChild)
        {
            setCf((TCf) newChild);
            return;
        }

        if(this._equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(this._e_ == oldChild)
        {
            setE((PE) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}