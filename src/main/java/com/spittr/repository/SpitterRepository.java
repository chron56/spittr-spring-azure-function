package com.spittr.repository;

import com.spittr.model.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpitterRepository extends JpaRepository<Spitter, Integer> {
}