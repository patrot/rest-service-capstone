package com.capstone.restservice.service;

import com.capstone.restservice.respository.DepartmentDto;
import com.capstone.restservice.respository.DepartmentRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockDepartmentRepository implements DepartmentRepository {

    private  final List<DepartmentDto> departmentDtos = new ArrayList<>();

    public  MockDepartmentRepository() {
        departmentDtos.add(new DepartmentDto("Shirt"));
        departmentDtos.add(new DepartmentDto("Trousers"));

    }

    @Override
    public List<DepartmentDto> findAll() {
        return departmentDtos;
    }

    @Override
    public List<DepartmentDto> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<DepartmentDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<DepartmentDto> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(DepartmentDto entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends DepartmentDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends DepartmentDto> S save(S entity) {
        return null;
    }

    @Override
    public <S extends DepartmentDto> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<DepartmentDto> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends DepartmentDto> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<DepartmentDto> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DepartmentDto getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends DepartmentDto> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends DepartmentDto> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DepartmentDto> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DepartmentDto> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DepartmentDto> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DepartmentDto> boolean exists(Example<S> example) {
        return false;
    }
}
