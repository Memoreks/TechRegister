package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.TV;

@NoArgsConstructor
@Getter
@Setter
public class TVDto {

    private int id;
    private int technicId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private long cost;
    private int category;
    private int technology;
    private boolean isAvailability;

    public TVDto(TV tv) {
        this.id = tv.getId();
        this.technicId = tv.getTechnicId();
        this.name = tv.getName();
        this.serialNumber = tv.getSerialNumber();
        this.color = tv.getColor();
        this.size = tv.getSize();
        this.cost = tv.getCost();
        this.category = tv.getCategory();
        this.technology = tv.getTechnology();
        this.isAvailability = tv.isAvailability();
    }

    public TV mapToEntity() {
        TV tv = new TV();
        tv.setId(this.id);
        tv.setTechnicId(this.technicId);
        tv.setName(this.name);
        tv.setSerialNumber(this.serialNumber);
        tv.setColor(this.color);
        tv.setSize(this.size);
        tv.setCost(this.cost);
        tv.setCategory(this.category);
        tv.setTechnology(this.getTechnology());
        tv.setAvailability(this.isAvailability());
        return tv;
    }
}
