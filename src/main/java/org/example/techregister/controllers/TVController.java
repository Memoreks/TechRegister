package org.example.techregister.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.techregister.dto.TVDto;
import org.example.techregister.services.TVCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Tag(name = "Телевизор", description = "API Телевизора")
@RestController
@RequestMapping("/tv")
public class TVController {
    private final TVCRUDService tvService;

    public TVController(TVCRUDService tvService) {
        this.tvService = tvService;
    }

    @Operation(summary = "Вывести телевизор по Id", tags = "Телевизор")
    @GetMapping("/{id}")
    public TVDto getTVById(@PathVariable Integer id) {
        return tvService.getById(id);
    }

    @Operation(summary = "Вывести все телевизоры", tags = "Телевизор")
    @GetMapping
    public Collection<TVDto> getAllTVs() {
        return tvService.getAll();
    }

    @Operation(summary = "Создать телевизор", tags = "Телевизор")
    @PostMapping
    public void createTV(@RequestBody TVDto tvDto) {
        tvService.create(tvDto);
    }

    @Operation(summary = "Обновить телевизор по Id", tags = "Телевизор")
    @PutMapping("/{id}")
    public void updateTV(@PathVariable Integer id, @RequestBody TVDto tvDto) {
        tvDto.setId(id);
        tvService.update(tvDto);
    }

    @Operation(summary = "Удалить телевизор по Id", tags = "Телевизор")
    @DeleteMapping("/{id}")
    public void deleteTV(@PathVariable Integer id) {
        tvService.delete(id);
    }
}
