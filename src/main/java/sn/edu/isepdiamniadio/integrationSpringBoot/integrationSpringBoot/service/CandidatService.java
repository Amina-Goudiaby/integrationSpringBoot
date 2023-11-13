package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.CandidatBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ResultatVoteCandidat;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.VoteBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.CandidatRepository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.VoteRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CandidatService {
    @Autowired
    private CandidatRepository candidatRepository;

    @Autowired
    private VoteRepository voteRepository;

    public List<ResultatVoteCandidat> obtenirResultats() {
        List<CandidatBean> candidats = candidatRepository.findAll();
        Map<String, Long> resultats = new HashMap<>();

        for (CandidatBean candidat : candidats) {
            long nombreDeVoix = voteRepository.countByCandidat(candidat);
            resultats.put(candidat.getName(), nombreDeVoix);
        }

        resultats = resultats.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<ResultatVoteCandidat> resultatVotes = new ArrayList<>();
        resultats.forEach((candidat, nombreDeVoix) -> {
            resultatVotes.add(new ResultatVoteCandidat(candidat, nombreDeVoix));
        });

        return resultatVotes;
    }
}
