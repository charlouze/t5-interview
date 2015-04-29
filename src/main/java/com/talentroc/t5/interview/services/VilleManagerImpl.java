package com.talentroc.t5.interview.services;

import com.talentroc.t5.interview.entities.Ville;
import com.talentroc.t5.interview.utils.BusinessException;
import org.apache.tapestry5.jpa.annotations.CommitAfter;

import javax.persistence.EntityManager;
import java.util.List;

public class VilleManagerImpl implements VilleManager {

    private final EntityManager entityManager;

    public VilleManagerImpl(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void validate(final Ville ville) throws BusinessException {
        // TODO - Ecrire le code de validation du contact.
    }

    @Override
    @CommitAfter
    public Ville create(final Ville ville) throws BusinessException {
        if (ville.getId() == null) {
            validate(ville);
            entityManager.persist(ville);
        } else {
            throw new BusinessException("This contact already exists in DB. Use update.");
        }
        return ville;
    }

    @Override
    @CommitAfter
    public void update(final Ville ville) throws BusinessException {
        if (ville.getId() == null) {
            throw new BusinessException("This contact does not exist in DB. Use create.");
        } else {
            validate(ville);
            entityManager.merge(ville);
        }
    }

    @Override
    @CommitAfter
    public void delete(final Ville ville) throws BusinessException {
        entityManager.remove(ville);
    }

    @Override
    public List<Ville> retrieveAll() {
        return entityManager.createNamedQuery(Ville.RETRIEVE_ALL).getResultList();
    }

    @Override
    public Ville retrieveById(final Long id) {
        return entityManager.find(Ville.class, id);
    }
}
