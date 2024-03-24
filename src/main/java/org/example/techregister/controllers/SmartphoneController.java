package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.SmartphoneDto;
import org.example.techregister.services.SmartphoneCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Смартфон", description = "API Смартфона")
@RestController
@RequestMapping("/smartphone")
public class SmartphoneController {
    private final SmartphoneCRUDService smartphoneService;

    public SmartphoneController(SmartphoneCRUDService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @Operation(summary = "Вывести смартфон по Id", tags = "Смартфон")
    @GetMapping("/{id}")
    public SmartphoneDto getSmartphoneById(@PathVariable Integer id) {
        return smartphoneService.getById(id);
    }

    @Operation(summary = "Вывести все смартфоны", tags = "Смартфон")
    @GetMapping
    public Collection<SmartphoneDto> getAllSmartphones() {
        return smartphoneService.getAll();
    }

    @Operation(summary = "Создать смартфон по Id", tags = "Смартфон")
    @PostMapping
    public void createSmartphone(@RequestBody SmartphoneDto smartphoneDto) {
        smartphoneService.create(smartphoneDto);
    }

    @Operation(summary = "Обновить смартфон по Id", tags = "Смартфон")
    @PutMapping("/{id}")
    public void updateSmartphone(@PathVariable Integer id, @RequestBody SmartphoneDto smartphoneDto) {
        smartphoneDto.setId(id);
        smartphoneService.update(smartphoneDto);
    }

    @Operation(summary = "Удалить смартфон по Id", tags = "Смартфон")
    @DeleteMapping("/{id}")
    public void deletePC(@PathVariable Integer id) {
        smartphoneService.delete(id);
    }
}
