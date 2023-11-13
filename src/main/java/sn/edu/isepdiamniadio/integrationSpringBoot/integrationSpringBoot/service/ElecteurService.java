package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ElecteurBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.ElecteurRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ElecteurService {
    @Autowired
    private ElecteurRepository electeurRepository;
    public ResponseEntity<?> registerElecteur(ElecteurBean electeurBean){
        Optional<ElecteurBean> existingElecteur = electeurRepository.findByVoterId(electeurBean.getVoterId());
        if (existingElecteur.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Un électeur avec cet identifiant de vote existe déjà.");
        }
        ElecteurBean savedElecteur = electeurRepository.save(electeurBean);

        Map<String, Object> response = new HashMap<>();
        response.put("voterId", savedElecteur.getVoterId());
        response.put("message", "Enregistré avec succès");

        return ResponseEntity.ok(response);
    }
}
