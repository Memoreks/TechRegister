package org.example.techregister.repositories;

import org.example.techregister.entity.Technic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicRepository extends JpaRepository<Technic, Integer> {

}
