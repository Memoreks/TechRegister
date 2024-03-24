package org.example.techregister.repositories;

import java.util.List;

import org.example.techregister.entity.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Integer> {

    List<VacuumCleaner> findAllByTechnicId(int technicId);
}
