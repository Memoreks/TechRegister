package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.PCDto;
import org.example.techregister.entity.PC;
import org.example.techregister.repositories.PCRepository;
import org.example.techregister.repositories.TechnicRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class PCCRUDService implements CRUDService<PCDto> {

    private final PCRepository repository;

    @Override
    public PCDto getById(Integer id) {
        log.info("Get by ID: " + id);
        PC pc = repository.findById(id).orElseThrow();
        return new PCDto(pc);
    }

    @Override
    public Collection<PCDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(pc -> new PCDto(pc))
                .toList();
    }

    @Override
    public void create(PCDto pcDto) {
        log.info("Create");
        PC pc = pcDto.mapToEntity();
        repository.save(pc);
    }

    @Override
    public void update(PCDto pcDto) {
        log.info("Update");
        PC pc = pcDto.mapToEntity();
        repository.save(pc);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
}