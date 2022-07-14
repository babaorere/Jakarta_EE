package com.app.repository;

import java.io.Serializable;
import java.util.Optional;

public interface GenericDAO<T, K extends Serializable> {

    Optional<T> findById(K id);

    void create(T entity);

    T save(T entity);

    void deleteById(Long id);

    void delete(T entity);

}
