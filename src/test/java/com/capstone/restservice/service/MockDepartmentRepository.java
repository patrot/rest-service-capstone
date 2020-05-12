package com.capstone.restservice.service;

import com.capstone.restservice.domain.Department;
import com.capstone.restservice.respository.DepartmentRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockDepartmentRepository implements DepartmentRepository {

    private  final List<Department> departments = new ArrayList<>();

    public  MockDepartmentRepository() {
        departments.add(new Department(100, "Shirt"));
        departments.add(new Department(200, "Trousers"));

    }

    @Override
    public List<Department> findAll() {
        return departments;
    }

    @Override
    public List<Department> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Department> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Department entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Department> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Department> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Department> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Department> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Department> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Department> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Department getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Department> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Department> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Department> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Department> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Department> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Department> boolean exists(Example<S> example) {
        return false;
    }
}
