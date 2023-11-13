package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ElecteurBean;

import java.util.Optional;

@Repository
public interface ElecteurRepository extends JpaRepository<ElecteurBean, Long> {
    Optional<ElecteurBean> findByVoterId(String voterId);
}
