package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.Fridge;

@NoArgsConstructor
@Getter
@Setter
public class FridgeDto {

    private int id;
    private int technicId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private long cost;
    private int countDoors;
    private int compressorType;
    private boolean isAvailability;

    public FridgeDto(Fridge fridge) {
        this.id = fridge.getId();
        this.technicId = fridge.getTechnicId();
        this.name = fridge.getName();
        this.serialNumber = fridge.getSerialNumber();
        this.color = fridge.getColor();
        this.size = fridge.getSize();
        this.cost = fridge.getCost();
        this.countDoors = fridge.getCountDoors();
        this.compressorType = fridge.getCompressorType();
        this.isAvailability = fridge.isAvailability();
    }

    public Fridge mapToEntity() {
        Fridge fridge = new Fridge();
        fridge.setId(this.getId());
        fridge.setTechnicId(this.getTechnicId());
        fridge.setName(this.getName());
        fridge.setSerialNumber(this.getSerialNumber());
        fridge.setColor(this.getColor());
        fridge.setSize(this.getSize());
        fridge.setCost(this.getCost());
        fridge.setCountDoors(this.getCountDoors());
        fridge.setCompressorType(this.getCompressorType());
        fridge.setAvailability(this.isAvailability);
        return fridge;
    }
}
