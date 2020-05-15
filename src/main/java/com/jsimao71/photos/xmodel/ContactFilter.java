package com.jsimao71.photos.xmodel;

import org.einnovator.util.model.ToStringCreator;

public class ContactFilter extends ContactOptions {

    private String q;

    /**
     * Create instance of {@code ContactFilter}.
     */
    public ContactFilter() {
        super();
    }

    /**
     * Set value of property {@code q}.
     *
     * @param q the value of q
     */
    public void setQ(String q) {
        this.q = q;
    }

    /**
     * Get value of property {@code q}.
     *
     * @return q the {@code q}
     */
    public String getQ() {
        return this.q;
    }

    /**
     * Set value of property {@code q}.
     *
     * @param q the value of q
     * @return {@code this}
     */
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
