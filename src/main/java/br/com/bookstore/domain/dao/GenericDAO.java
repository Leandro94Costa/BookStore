package br.com.bookstore.domain.dao;

import br.com.bookstore.domain.entity.Author;

import java.util.List;

public interface GenericDAO<T, U> {

    List<T> getAll() throws Exception;

    T getById(U id) throws Exception;

    void save(T object) throws Exception;

    void update(T object) throws Exception;

    void delete(U id) throws Exception;
}
