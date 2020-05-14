package com.jsimao71.photos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.einnovator.util.model.ToStringCreator;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class Contact extends org.einnovator.jpa.model.EntityBase<Long> {

    @Column()
    private String name;

    @Column()
    private String email;

    @Column()
    private String comment;

    public Contact() {
        super();
    }

    public Contact(Object obj) {
        super(obj);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    @Override()
    public ToStringCreator toString0(ToStringCreator creator) {
        return super.toString0(creator);
    }

    @Override()
    public ToStringCreator toString1(ToStringCreator creator) {
        return super.toString1(creator)
                    .append("name", name)
                    .append("email", email)
                    .append("comment", comment);
    }

    @Override()
    public ToStringCreator toString2(ToStringCreator creator) {
        return super.toString2(creator);
    }
}
