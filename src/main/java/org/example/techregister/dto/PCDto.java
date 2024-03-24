package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.PC;

@NoArgsConstructor
@Getter
@Setter
public class PCDto {

    private int id;
    private int technicId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private long cost;
    private int category;
    private int coreType;
    private Boolean isAvailability;

    public PCDto(PC pc) {
        this.id = pc.getId();
        this.technicId = pc.getTechnicId();
        this.name = pc.getName();
        this.serialNumber = pc.getSerialNumber();
        this.color = pc.getColor();
        this.size = pc.getSize();
        this.cost = pc.getCost();
        this.category = pc.getCategory();
        this.coreType = pc.getCoreType();
        this.isAvailability = pc.isAvailability();
    }

    public PC mapToEntity() {
        PC pc = new PC();
        pc.setId(this.id);
        pc.setTechnicId(this.technicId);
        pc.setName(this.name);
        pc.setSerialNumber(this.serialNumber);
        pc.setColor(this.color);
        pc.setSize(this.size);
        pc.setCost(this.cost);
        pc.setCategory(this.category);
        pc.setCoreType(this.coreType);
        pc.setAvailability(this.isAvailability);
        return pc;
    }
}
