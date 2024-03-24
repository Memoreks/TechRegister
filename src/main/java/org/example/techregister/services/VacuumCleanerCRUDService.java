package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.VacuumCleanerDto;
import org.example.techregister.entity.VacuumCleaner;
import org.example.techregister.repositories.TechnicRepository;
import org.example.techregister.repositories.VacuumCleanerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class VacuumCleanerCRUDService implements CRUDService<VacuumCleanerDto> {

    private final VacuumCleanerRepository repository;

    @Override
    public VacuumCleanerDto getById(Integer id) {
        log.info("Get by ID: " + id);
        VacuumCleaner vacuumCleaner = repository.findById(id).orElseThrow();
        return new VacuumCleanerDto(vacuumCleaner);
    }

    @Override
    public Collection<VacuumCleanerDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(VacuumCleanerDto::new)
                .toList();
    }

    @Override
    public void create(VacuumCleanerDto vacuumCleanerDto) {
        log.info("Create");
        VacuumCleaner vacuumCleaner = vacuumCleanerDto.mapToEntity();
        repository.save(vacuumCleaner);
    }

    @Override
    public void update(VacuumCleanerDto vacuumCleanerDto) {
        log.info("Update");
        VacuumCleaner vacuumCleaner = vacuumCleanerDto.mapToEntity();
        repository.save(vacuumCleaner);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
}