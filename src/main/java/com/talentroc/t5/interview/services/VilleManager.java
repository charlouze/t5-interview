package com.talentroc.t5.interview.services;

import com.talentroc.t5.interview.entities.Ville;
import com.talentroc.t5.interview.utils.BusinessException;

import java.util.List;

public interface VilleManager {

    void validate(Ville ville) throws BusinessException;

    Ville create(Ville ville) throws BusinessException;

    void update(Ville ville) throws BusinessException;

    void delete(Ville ville) throws BusinessException;

    List<Ville> retrieveAll();

    Ville retrieveById(Long id);
}
