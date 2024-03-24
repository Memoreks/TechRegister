package org.example.techregister.repositories;

import org.example.techregister.entity.Fridge;
import org.example.techregister.entity.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Integer> {

    List<Fridge> findAllByTechnicId(int technicId);
}
