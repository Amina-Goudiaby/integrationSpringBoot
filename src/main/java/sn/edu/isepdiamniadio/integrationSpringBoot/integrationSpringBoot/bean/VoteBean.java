package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean;

import jakarta.persistence.*;

@Entity
public class VoteBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "electeur_id")
    private ElecteurBean electeur;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private CandidatBean candidat;

    public VoteBean() {
    }

    public VoteBean(ElecteurBean electeur, CandidatBean candidat) {
        this.electeur = electeur;
        this.candidat = candidat;
    }

    public Long getId() {
        return id;
    }

    public ElecteurBean getElecteur() {
        return electeur;
    }

    public CandidatBean getCandidat() {
        return candidat;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setElecteur(ElecteurBean electeur) {
        this.electeur = electeur;
    }

    public void setCandidat(CandidatBean candidat) {
        this.candidat = candidat;
    }
}
