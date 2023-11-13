package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CandidatBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateId;
    private String name;
    private String Party;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL)
    private List<VoteBean> votes;

    public CandidatBean() {
    }

    public CandidatBean(String candidateId, String name, String party, List<VoteBean> votes) {
        this.candidateId = candidateId;
        this.name = name;
        Party = party;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return Party;
    }

    public List<VoteBean> getVotes() {
        return votes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParty(String party) {
        Party = party;
    }

    public void setVotes(List<VoteBean> votes) {
        this.votes = votes;
    }
}