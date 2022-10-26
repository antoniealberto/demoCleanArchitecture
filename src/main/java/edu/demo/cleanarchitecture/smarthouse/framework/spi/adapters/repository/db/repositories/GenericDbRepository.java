package edu.demo.cleanarchitecture.smarthouse.framework.spi.adapters.repository.db.repositories;

import java.util.Set;

public interface GenericDbRepository <T> {

    // Save method
    public void save(T t);

    // Find a entity by its id
    public T findEntityById(Long id);

    Set<T> findAll();
}
