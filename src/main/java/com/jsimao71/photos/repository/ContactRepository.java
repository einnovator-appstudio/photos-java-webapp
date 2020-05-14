package com.jsimao71.photos.repository;

import com.jsimao71.photos.model.Contact;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.repository.RepositoryBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactRepository extends org.einnovator.jpa.repository.RepositoryBase<Contact, Long> {
}
