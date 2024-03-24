package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.PCDto;
import org.example.techregister.services.PCCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Компьютер", description = "API Компьютера")
@RestController
@RequestMapping("/pc")
public class PCController {
    private final PCCRUDService pcService;

    public PCController(PCCRUDService pcService) {
        this.pcService = pcService;
    }

    @Operation(summary = "Вывести комьпютер по Id", tags = "Компьютер")
    @GetMapping("/{id}")
    public PCDto getPCById(@PathVariable Integer id) {
        return pcService.getById(id);
    }

    @Operation(summary = "Вывести все компьютеры", tags = "Компьютер")
    @GetMapping
    public Collection<PCDto> getAllPCs() {
        return pcService.getAll();
    }

    @Operation(summary = "Создать компьютер", tags = "Компьютер")
    @PostMapping
    public void createPC(@RequestBody PCDto pcDto) {
        pcService.create(pcDto);
    }

    @Operation(summary = "Обновить компьютер по Id", tags = "Компьютер")
    @PutMapping("/{id}")
    public void updatePC(@PathVariable Integer id, @RequestBody PCDto pcDto) {
        pcDto.setId(id);
        pcService.update(pcDto);
    }

    @Operation(summary = "Удалить компьютер по Id", tags = "Компьютер")
    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable Integer id) {
        pcService.delete(id);
    }
}
