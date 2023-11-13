package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ResultatVoteCandidat;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.VoteBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service.CandidatService;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service.VoteService;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public ResponseEntity<List<ResultatVoteCandidat>> obtenirResultats() {
        List<ResultatVoteCandidat> resultats = candidatService.obtenirResultats();
        return ResponseEntity.ok(resultats);
    }
}
