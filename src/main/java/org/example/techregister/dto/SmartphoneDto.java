package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.Smartphone;

@NoArgsConstructor
@Getter
@Setter
public class SmartphoneDto {

    private int id;
    private int technicId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private long cost;
    private int memory;
    private int core;
    private boolean isAvailability;

    public SmartphoneDto(Smartphone smartphone) {
        this.id = smartphone.getId();
        this.technicId = smartphone.getTechnicId();
        this.name = smartphone.getName();
        this.serialNumber = smartphone.getSerialNumber();
        this.color = smartphone.getColor();
        this.size = smartphone.getSize();
        this.cost = smartphone.getCost();
        this.memory = smartphone.getMemory();
        this.core = smartphone.getCore();
        this.isAvailability = smartphone.isAvailability();
    }

    public Smartphone mapToEntity() {
        Smartphone smartphone = new Smartphone();
        smartphone.setId(this.id);
        smartphone.setTechnicId(this.technicId);
        smartphone.setName(this.name);
        smartphone.setSerialNumber(this.serialNumber);
        smartphone.setColor(this.color);
        smartphone.setSize(this.size);
        smartphone.setCost(this.cost);
        smartphone.setMemory(this.getMemory());
        smartphone.setCore(this.getCore());
        smartphone.setAvailability(this.isAvailability());
        return smartphone;
    }
}
