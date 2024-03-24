package org.example.techregister.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Technic")
public class Technic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "is_order_online")
    private boolean isOrderOnline;

    @Column(name = "is_apply_for_loan")
    private boolean isApplyForLoan;

    @OneToMany
    @JoinColumn(name = "pc_technicId")
    private List<PC> listPC;

    @OneToMany
    @JoinColumn(name = "fridge_technicId")
    private List<Fridge> listFridge;

    @OneToMany
    @JoinColumn(name = "smartphone_technicId")
    private List<Smartphone> listSmartphone;

    @OneToMany
    @JoinColumn(name = "tv_technicId")
    private List<TV> listTV;

    @OneToMany
    @JoinColumn(name = "vacumcleaner_technicId")
    private List<VacuumCleaner> listVacuumCleaner;
}
