package com.ilionx.hobbyapp.service;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.persistance.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepository hobbyRepository;

    public List<Musician> findAll() {
        return hobbyRepository.findAll();
    }

    public List<Musician> findAll(Sort sort) {
        return hobbyRepository.findAll(sort);
    }

    public Musician save(Musician entity) {
        return hobbyRepository.save(entity);
    }

    public Optional<Musician> findById(Long aLong) {
        return hobbyRepository.findById(aLong);
    }


    public long count() {
        return hobbyRepository.count();
    }

    public void deleteById(Long aLong) {
        hobbyRepository.deleteById(aLong);
    }

}
