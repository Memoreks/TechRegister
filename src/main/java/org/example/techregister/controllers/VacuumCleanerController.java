package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.VacuumCleanerDto;
import org.example.techregister.services.VacuumCleanerCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Пылесос", description = "API Пылесоса")
@RestController
@RequestMapping("/vacuumcleaner")
public class VacuumCleanerController {
    private final VacuumCleanerCRUDService vacuumCleanerService;

    public VacuumCleanerController(VacuumCleanerCRUDService vacuumCleanerService) {
        this.vacuumCleanerService = vacuumCleanerService;
    }

    @Operation(summary = "Вывести пылесос по Id", tags = "Пылесос")
    @GetMapping("/{id}")
    public VacuumCleanerDto getVacuumCleanerById(@PathVariable Integer id) {
        return vacuumCleanerService.getById(id);
    }

    @Operation(summary = "Вывести все пылесосы", tags = "Пылесос")
    @GetMapping
    public Collection<VacuumCleanerDto> getAllVacuumCleaners() {
        return vacuumCleanerService.getAll();
    }

    @Operation(summary = "Создать пылесос", tags = "Пылесос")
    @PostMapping
    public void createVacuumCleaner(@RequestBody VacuumCleanerDto vacuumCleanerDto) {
        vacuumCleanerService.create(vacuumCleanerDto);
    }

    @Operation(summary = "Обновить пылесос по Id", tags = "Пылесос")
    @PutMapping("/{id}")
    public void updateVacuumCleaner(@PathVariable Integer id, @RequestBody VacuumCleanerDto vacuumCleanerDto) {
        vacuumCleanerDto.setId(id);
        vacuumCleanerService.update(vacuumCleanerDto);
    }

    @Operation(summary = "Удалить пылесос по Id", tags = "Пылесос")
    @DeleteMapping("/{id}")
    public void deleteVacuumCleaner(@PathVariable Integer id) {
        vacuumCleanerService.delete(id);
    }
}
