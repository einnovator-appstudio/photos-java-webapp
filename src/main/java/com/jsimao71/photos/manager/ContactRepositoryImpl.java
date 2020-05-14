package com.jsimao71.photos.manager;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.jsimao71.photos.model.Contact;
import com.jsimao71.photos.repository.ContactRepository;
import com.jsimao71.photos.xmodel.ContactFilter;
import org.einnovator.jpa.manager.ManagerBaseImpl3;
import org.einnovator.util.PageOptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service()
public class ContactManagerImpl extends ManagerBaseImpl3<Contact> implements ContactManager {

    public final String CONTACT_RESOURCE_JSON = "data/Contact.json";

    public final String CONTACT_RESOURCE_XML = "data/Contact.xml";

    public final String CONTACT_RESOURCE_XLS = "data/Contact.xls";

    @Autowired()
    private ContactRepository repository;

    private boolean init;

    public ContactRepository getRepository() {
        return repository;
    }

    public Page<Contact> findAll(ContactFilter filter, Pageable pageable) {
        populate();
        Page<Contact> page = null;
        ;
        if (page == null)
            page = repository.findAll(pageable);
        else
            ;
        return processAfterLoad(page, filter);
    }

    public Page<Contact> findAll(ContactFilter filter, PageOptions pageable) {
        return findAll(filter, pageable);
    }

    public long count(ContactFilter filter) {
        ;
        return repository.count();
    }

    public void populate() {
        populate(false);
    }

    public void populate(boolean force) {
        populate(Contact.class, force, CONTACT_RESOURCE_JSON);
    }
}
