package org.example.techregister.repositories;

import org.example.techregister.entity.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PCRepository extends JpaRepository<PC, Integer> {

    List<PC> findAllByTechnicId(int technicId);
}
