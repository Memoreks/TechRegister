package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.TechnicDto;
import org.example.techregister.services.TechnicalCRUDService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Техника", description = "API Техники")
@RestController
@RequestMapping("/technic")
public class TechnicalController {
    private final TechnicalCRUDService technicalService;

    public TechnicalController(TechnicalCRUDService technicalService) {
        this.technicalService = technicalService;
    }

    @Operation(summary = "Вывести технику по Id", tags = "Техника")
    @GetMapping("/{id}")
    public TechnicDto getTechnicById(@PathVariable Integer id) {
        return technicalService.getById(id);
    }

    @Operation(summary = "Вывести всю технику по Id", tags = "Техника")
    @GetMapping
    public Collection<TechnicDto> getAllTechnics() {
        return technicalService.getAll();
    }

    @Operation(summary = "Создать технику", tags = "Техника")
    @PostMapping
    public void createTechnic(@RequestBody TechnicDto technicDto) {
        technicalService.create(technicDto);
    }

    @Operation(summary = "Обновить технику по Id", tags = "Техника")
    @PutMapping("/{id}")
    public void updateTechnic(@PathVariable Integer id, @RequestBody TechnicDto technicDto) {
        technicDto.setId(id);
        technicalService.update(technicDto);
    }

    @Operation(summary = "Удалить технику по Id", tags = "Техника")
    @DeleteMapping("/{id}")
    public void deleteTechnic(@PathVariable Integer id) {
        technicalService.delete(id);
    }
}
