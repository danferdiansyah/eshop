package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Car;

import java.util.List;

public interface BaseService<T> {
    T create(T item);
    List<T> findAll();
    T findById(String id);
    void update(String Id, T item);
    void deleteById(String id);
}
