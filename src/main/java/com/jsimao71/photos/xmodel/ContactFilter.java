package com.jsimao71.photos.xmodel;

import org.einnovator.util.model.ToStringCreator;

public class ContactFilter extends ContactOptions {

    private String q;

    public ContactFilter() {
        super();
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getQ() {
        return this.q;
    }

    public ContactFilter withQ(String q) {
        this.q = q;
        return this;
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("q", q);
    }
}
