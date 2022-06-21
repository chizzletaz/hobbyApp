package com.ilionx.hobbyapp.service;

import com.ilionx.hobbyapp.model.Musician;
import com.ilionx.hobbyapp.persistance.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    @Transactional
    public Musician save(Musician entity) {
        return hobbyRepository.save(entity);
    }

    public Optional<Musician> findById(Long aLong) {
        return hobbyRepository.findById(aLong);
    }

    public long count() {
        return hobbyRepository.count();
    }


    @Transactional
    public Musician updateByID(long id, Musician source) {
        Optional<Musician> optionalMusician = findById(id);
        if (optionalMusician.isPresent()) {
            Musician target = optionalMusician.get();
            target.setName(source.getName());
            target.setAge(source.getAge());
            target.setInstrument(source.getInstrument());

            return save(target);
        } else {
            return null;
        }
    }

    @Transactional
    public void deleteByID(long id) {
        Optional<Musician> optionalMusician = findById(id);
        if(optionalMusician.isPresent()) {
            hobbyRepository.deleteById(id);
        }
    }
}
