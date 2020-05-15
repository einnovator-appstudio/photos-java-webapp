package com.jsimao71.photos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.einnovator.jpa.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

/**
 * A {@code Contact}.
 *
 * @author Jorge Simao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Contact extends EntityBase<Long> {

    @JsonColumn("Name")
    @NotNull 
    @Column(unique = true)
    private String name;

    @JsonColumn("Email")
    @NotNull 
    @Column(unique = true)
    private String email;

    @JsonColumn("Comment")
    @Column(unique = true)
    private String comment;

    /**
     * Create instance of {@code Contact}.
     */
    public Contact() {
        super();
    }

    /**
     * Create instance of {@code Contact}.
     *
     * @param obj a prototype
     */
    public Contact(Object obj) {
        super(obj);
    }

    /**
     * Set value of property {@code name}.
     *
     * @param name the value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get value of property {@code name}.
     *
     * @return name the {@code name}
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set value of property {@code email}.
     *
     * @param email the value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get value of property {@code email}.
     *
     * @return email the {@code email}
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set value of property {@code comment}.
     *
     * @param comment the value of comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get value of property {@code comment}.
     *
     * @return comment the {@code comment}
     */
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
