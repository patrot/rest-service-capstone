package com.capstone.restservice.unit.service;

import com.capstone.restservice.respository.ProductDto;
import com.capstone.restservice.respository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class MockProductRepository implements ProductRepository {

    private final  List<ProductDto> productDtos;

    private int findAllInvocationCount;

    public MockProductRepository(List<ProductDto> productDtos) {
        this.productDtos = productDtos;
        findAllInvocationCount = 0;
    }

    public int getFindAllInvocationCount() {
        return findAllInvocationCount;
    }

    @Override
    public List<ProductDto> findAll() {
        findAllInvocationCount++;
        return productDtos;
    }

    @Override
    public List<ProductDto> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductDto> findAllById(Iterable<Long> longs) {
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
    public void delete(ProductDto entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ProductDto> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ProductDto> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProductDto> findById(Long aLong) {
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
    public <S extends ProductDto> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ProductDto> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProductDto getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ProductDto> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductDto> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductDto> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductDto> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductDto> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductDto> boolean exists(Example<S> example) {
        return false;
    }
}
