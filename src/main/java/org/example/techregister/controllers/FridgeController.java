package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.FridgeDto;
import org.example.techregister.services.FridgeCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Холодильник", description = "API Холодильника")
@RestController
@RequestMapping("/fridge")
public class FridgeController {
    private final FridgeCRUDService fridgeService;

    public FridgeController(FridgeCRUDService fridgeService) {
        this.fridgeService = fridgeService;
    }

    @Operation(summary = "Вывести холодильник по Id", tags = "Холодильник")
    @GetMapping("/{id}")
    public FridgeDto getFridgeById(@PathVariable Integer id) {
        return fridgeService.getById(id);
    }

    @Operation(summary = "Вывести все холодильники", tags = "Холодильник")
    @GetMapping
    public Collection<FridgeDto> getAllFridges() {
        return fridgeService.getAll();
    }

    @Operation(summary = "Создать холодильник", tags = "Холодильник")
    @PostMapping
    public void createFridge(@RequestBody FridgeDto fridgeDto) {
        fridgeService.create(fridgeDto);
    }

    @Operation(summary = "Обновить холодильник по Id", tags = "Холодильник")
    @PutMapping("/{id}")
    public void updatePC(@PathVariable Integer id, @RequestBody FridgeDto fridgeDto) {
        fridgeDto.setId(id);
        fridgeService.update(fridgeDto);
    }

    @Operation(summary = "Удалить холодильник по Id", tags = "Холодильник")
    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable Integer id) {
        fridgeService.delete(id);
    }
}
