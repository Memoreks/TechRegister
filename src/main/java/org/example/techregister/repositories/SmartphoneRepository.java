package org.example.techregister.repositories;

import org.example.techregister.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {

    List<Smartphone> findAllByTechnicId(int technicId);
}

