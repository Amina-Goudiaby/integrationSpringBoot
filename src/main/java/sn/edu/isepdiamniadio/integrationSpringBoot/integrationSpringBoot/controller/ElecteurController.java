package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ElecteurBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service.ElecteurService;

@RestController
@RequestMapping("/api/voters/")
public class ElecteurController {
    @Autowired
    ElecteurService electeurService;
    @PostMapping("register")
    public ResponseEntity<?> registerElecteur(@RequestBody ElecteurBean electeurBean) {
        return electeurService.registerElecteur(electeurBean);
    }
}
