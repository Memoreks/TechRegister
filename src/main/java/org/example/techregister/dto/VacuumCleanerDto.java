package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.VacuumCleaner;

@NoArgsConstructor
@Getter
@Setter
public class VacuumCleanerDto {

    private int id;
    private int technicId;
    private String name;
    private String serialNumber;
    private String color;
    private String size;
    private long cost;
    private int volumeDustContainer;
    private int countModes;
    private boolean isAvailability;

    public VacuumCleanerDto(VacuumCleaner vacuumCleaner) {
        this.id = vacuumCleaner.getId();
        this.technicId = vacuumCleaner.getTechnicId();
        this.name = vacuumCleaner.getName();
        this.serialNumber = vacuumCleaner.getSerialNumber();
        this.color = vacuumCleaner.getColor();
        this.size = vacuumCleaner.getSize();
        this.cost = vacuumCleaner.getCost();
        this.volumeDustContainer = vacuumCleaner.getVolumeDustContainer();
        this.countModes = vacuumCleaner.getCountModes();
        this.isAvailability = vacuumCleaner.isAvailability();
    }

    public VacuumCleaner mapToEntity() {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        vacuumCleaner.setId(this.id);
        vacuumCleaner.setTechnicId(this.technicId);
        vacuumCleaner.setName(this.name);
        vacuumCleaner.setSerialNumber(this.serialNumber);
        vacuumCleaner.setColor(this.color);
        vacuumCleaner.setSize(this.size);
        vacuumCleaner.setCost(this.cost);
        vacuumCleaner.setVolumeDustContainer(this.volumeDustContainer);
        vacuumCleaner.setCountModes(this.countModes);
        vacuumCleaner.setAvailability(this.isAvailability);
        return vacuumCleaner;
    }
}
