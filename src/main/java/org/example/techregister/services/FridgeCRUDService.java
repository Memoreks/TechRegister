package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.FridgeDto;
import org.example.techregister.entity.Fridge;
import org.example.techregister.repositories.FridgeRepository;
import org.example.techregister.repositories.TechnicRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Slf4j
@Service
public class FridgeCRUDService implements CRUDService<FridgeDto> {

    private final FridgeRepository repository;

    @Override
    public FridgeDto getById(Integer id) {
        log.info("Get by ID: " + id);
        Fridge fridge = repository.findById(id).orElseThrow();
        return new FridgeDto(fridge);
    }

    @Override
    public Collection<FridgeDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(FridgeDto::new)
                .toList();
    }

    @Override
    public void create(FridgeDto fridgeDto) {
        log.info("Create");
        Fridge fridge = fridgeDto.mapToEntity();
        repository.save(fridge);
    }

    @Override
    public void update(FridgeDto fridgeDto) {
        log.info("Update");
        Fridge fridge = fridgeDto.mapToEntity();
        repository.save(fridge);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }
}
