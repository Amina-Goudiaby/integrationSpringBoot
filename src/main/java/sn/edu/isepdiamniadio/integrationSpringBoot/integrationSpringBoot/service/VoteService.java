package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.CandidatBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ElecteurBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.VoteBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.CandidatRepository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.ElecteurRepository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.VoteRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private ElecteurRepository electeurRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    public ResponseEntity<?> enregistrerVote(String voterId, String candidateId) {
        if (voteRepository.existsByElecteur_VoterId(voterId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("L'électeur a déjà voté. Un électeur ne peut voter qu'une seule fois.");
        }

        ElecteurBean electeur = electeurRepository.findByVoterId(voterId)
                .orElseThrow(() -> new RuntimeException("Électeur non trouvé avec l'ID : " + voterId));

        CandidatBean candidat = candidatRepository.findByCandidateId(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + candidateId));

        VoteBean voteBean = new VoteBean(electeur, candidat);
        voteRepository.save(voteBean);

        Map<String, Object> response = new HashMap<>();
        response.put("voterId", voterId);
        response.put("candidateIdVotedFor", candidateId);
        response.put("message", "Votre vote a été enregistré avec succès.");

        return ResponseEntity.ok(response);
    }
}
