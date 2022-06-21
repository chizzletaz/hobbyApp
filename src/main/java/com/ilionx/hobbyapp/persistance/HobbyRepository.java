package com.ilionx.hobbyapp.persistance;

import com.ilionx.hobbyapp.model.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends JpaRepository<Musician, Long> {
}
