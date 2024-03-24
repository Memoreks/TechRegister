package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.SmartphoneDto;
import org.example.techregister.entity.Smartphone;
import org.example.techregister.repositories.SmartphoneRepository;
import org.example.techregister.repositories.TechnicRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class SmartphoneCRUDService implements CRUDService<SmartphoneDto> {

    private final SmartphoneRepository repository;

    private final TechnicRepository technicRepository;

    @Override
    public SmartphoneDto getById(Integer id) {
        log.info("Get by ID: " + id);
        Smartphone smartphone = repository.findById(id).orElseThrow();
        return new SmartphoneDto(smartphone);
    }

    @Override
    public Collection<SmartphoneDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(SmartphoneDto::new)
                .toList();
    }

    @Override
    public void create(SmartphoneDto smartphoneDto) {
        log.info("Create");
        Smartphone smartphone = smartphoneDto.mapToEntity();
        repository.save(smartphone);
    }

    @Override
    public void update(SmartphoneDto smartphoneDto) {
        log.info("Update");
        Smartphone smartphone = smartphoneDto.mapToEntity();
        repository.save(smartphone);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
}