package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.TVDto;
import org.example.techregister.entity.TV;
import org.example.techregister.repositories.TVRepository;
import org.example.techregister.repositories.TechnicRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class TVCRUDService implements CRUDService<TVDto> {

    private final TVRepository repository;

    private final TechnicRepository technicRepository;

    @Override
    public TVDto getById(Integer id) {
        log.info("Get by ID: " + id);
        TV tv = repository.findById(id).orElseThrow();
        return new TVDto(tv);
    }

    @Override
    public Collection<TVDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(TVDto::new)
                .toList();
    }

    @Override
    public void create(TVDto tvDto) {
        log.info("Create");
        TV tv = tvDto.mapToEntity();
        repository.save(tv);
    }

    @Override
    public void update(TVDto tvDto) {
        log.info("Update");
        TV tv = tvDto.mapToEntity();
        repository.save(tv);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
}