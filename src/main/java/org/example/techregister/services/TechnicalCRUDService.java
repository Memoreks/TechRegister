package org.example.techregister.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.techregister.dto.*;
import org.example.techregister.entity.Technic;
import org.example.techregister.repositories.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class TechnicalCRUDService implements CRUDService<TechnicDto> {

    private final TechnicRepository repository;
    private final PCRepository pcRepository;
    private final TVRepository tvRepository;
    private final VacuumCleanerRepository vacuumCleanerRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final FridgeRepository fridgeRepository;

    @Override
    public TechnicDto getById(Integer id) {
        log.info("Get by ID: " + id);
        Technic technic = repository.findById(id).orElseThrow();
        return mapToDto(technic);
    }

    @Override
    public Collection<TechnicDto> getAll() {
        log.info("Get all");
        return repository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void create(TechnicDto technicDto) {
        log.info("Create");
        Technic technic = technicDto.mapToEntity();
        repository.save(technic);
    }

    @Override
    public void update(TechnicDto technicDto) {
        log.info("Update");
        Technic technic = technicDto.mapToEntity();
        repository.save(technic);
    }

    @Override
    public void delete(Integer id) {
        log.info("Delete");
        repository.deleteById(id);
    }

    public TechnicDto mapToDto(Technic technic) {
        TechnicDto technicDto = new TechnicDto();
        technicDto.setId(technic.getId());
        technicDto.setName(technic.getName());
        technicDto.setCountry(technic.getCountry());
        technicDto.setCompanyName(technic.getCompanyName());
        technicDto.setOrderOnline(technic.isOrderOnline());
        technicDto.setApplyForLoan(technic.isApplyForLoan());
        technicDto.setListPC(pcRepository.findAllByTechnicId(technic.getId()).stream()
                .map(PCDto::new)
                        .filter(PCDto::getIsAvailability)
                .collect(Collectors.toList()));
        technicDto.setListFridge(fridgeRepository.findAllByTechnicId(technic.getId()).stream()
                .map(FridgeDto::new)
                        .filter(FridgeDto::isAvailability)
                .collect(Collectors.toList()));
        technicDto.setListTV(tvRepository.findAllByTechnicId(technic.getId()).stream()
                .map(TVDto::new)
                .collect(Collectors.toList()));
        technicDto.setListSmartphone(smartphoneRepository.findAllByTechnicId(technic.getId()).stream()
                .map(SmartphoneDto::new)
                .collect(Collectors.toList()));
        technicDto.setListVacuumCleaner(vacuumCleanerRepository.findAllByTechnicId(technic.getId()).stream()
                .map(VacuumCleanerDto::new)
                .collect(Collectors.toList()));
        return technicDto;
    }
}