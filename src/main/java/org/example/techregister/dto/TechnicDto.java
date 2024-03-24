package org.example.techregister.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.techregister.entity.Technic;
import org.example.techregister.repositories.*;
import org.example.techregister.services.FridgeCRUDService;
import org.example.techregister.services.SmartphoneCRUDService;
import org.example.techregister.services.TVCRUDService;
import org.example.techregister.services.VacuumCleanerCRUDService;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class TechnicDto {

        private int id;
        private String name;
        private String country;
        private String companyName;
        private boolean isOrderOnline;
        private boolean isApplyForLoan;
        private List<PCDto> listPC;
        private List<FridgeDto> listFridge;
        private List<SmartphoneDto> listSmartphone;
        private List<TVDto> listTV;
        private List<VacuumCleanerDto> listVacuumCleaner;


        public Technic mapToEntity() {
                Technic technic = new Technic();
                technic.setId(this.id);
                technic.setName(this.getName());
                technic.setCountry(this.getCountry());
                technic.setCompanyName(this.getCompanyName());
                technic.setOrderOnline(this.isOrderOnline);
                technic.setApplyForLoan(this.isApplyForLoan);
                return technic;
        }
}
