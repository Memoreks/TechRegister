package org.example.techregister.repositories;

import org.example.techregister.entity.Smartphone;
import org.example.techregister.entity.TV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVRepository extends JpaRepository<TV, Integer> {

    List<TV> findAllByTechnicId(int technicId);
}
