package com.talentroc.t5.interview.services;

import com.talentroc.t5.interview.entities.Contact;
import com.talentroc.t5.interview.entities.Ville;
import com.talentroc.t5.interview.utils.BusinessException;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

import javax.persistence.EntityManager;
import java.util.List;

public class ContactManagerImpl implements ContactManager {

    private final EntityManager entityManager;

    public ContactManagerImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void validate(final Contact contact) throws BusinessException {
        // TODO - Ecrire le code de validation du contact.
    }

    @Override
    @CommitAfter
    public void create(final Contact contact) throws BusinessException {
        if (contact.getId() == null) {
            validate(contact);
            entityManager.persist(contact);
        } else {
            throw new BusinessException("This contact already exists in DB. Use update.");
        }
    }

    @Override
    @CommitAfter
    public void update(final Contact contact) throws BusinessException {
        if (contact.getId() == null) {
            throw new BusinessException("This contact does not exist in DB. Use create.");
        } else {
            validate(contact);
            entityManager.merge(contact);
        }
    }

    @Override
    @CommitAfter
    public void delete(final Contact contact) throws BusinessException {
        entityManager.remove(contact);
    }

    @Override
    public List<Contact> retrieveAll() {
        return entityManager.createNamedQuery(Contact.RETRIEVE_ALL).getResultList();
    }

    @Override
    public Contact retrieveById(final Long id) {
        return entityManager.find(Contact.class, id);
    }

    @Override
    public List<Contact> findByVille(final Ville ville) {
        return null;
    }
}
