package org.example.techregister.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PC")
@Setter
@Getter
public class PC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "technic_id")
    private int technicId;

    @Column(name = "name")
    private String name;

    @Column(name = "selial_number")
    private String serialNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "cost")
    private long cost;

    @Column(name = "category")
    private int category;

    @Column(name = "core_type")
    private int coreType;

    @Column(name = "is_availability")
    private boolean isAvailability;
}