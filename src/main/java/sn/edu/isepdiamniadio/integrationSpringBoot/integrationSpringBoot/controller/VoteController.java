package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service.VoteService;

import java.util.Map;

@RestController
@RequestMapping("/api/voting/")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("cast-vote")
    public ResponseEntity<?> voterCandidat(@RequestBody Map<String, String> request) {
        String voterId = request.get("voterId");
        String candidateId = request.get("candidateId");
        return voteService.enregistrerVote(voterId, candidateId);
    }

}
