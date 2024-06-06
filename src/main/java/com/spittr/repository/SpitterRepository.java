package com.spittr.repository;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Integer> {
    List<Spitter> findAll();
}