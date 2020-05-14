package com.jsimao71.photos.manager;

import com.jsimao71.photos.model.Contact;
import com.jsimao71.photos.xmodel.ContactFilter;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.manager.ManagerBase;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactRepository extends ManagerBase<Contact, Long> {

    /**
     * Find instances of {@code Contact} matching specified filter condition.
     */
    public Page<Contact> findAll(ContactFilter filter, Pageable pageable);

    /**
     * Find instances of {@code Contact} matching specified filter condition.
     *
     * @param filter the value of filter
     * @param pageable the value of pageable
     * @return the result
     */
    public Page<Contact> findAll(ContactFilter filter, PageOptions pageable);

    public long count(ContactFilter filter);

    public void populate();

    public void populate(boolean force);
}
