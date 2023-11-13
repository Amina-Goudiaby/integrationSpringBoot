package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.CandidatBean;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<CandidatBean, Long> {
    Optional<CandidatBean> findByCandidateId(String candidateId);
}
