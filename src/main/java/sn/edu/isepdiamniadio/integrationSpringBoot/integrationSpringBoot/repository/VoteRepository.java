package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.CandidatBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.VoteBean;

@Repository
public interface VoteRepository extends JpaRepository<VoteBean, Long> {
    boolean existsByElecteur_VoterId(String voterId);
    long countByCandidat(CandidatBean candidat);
}
