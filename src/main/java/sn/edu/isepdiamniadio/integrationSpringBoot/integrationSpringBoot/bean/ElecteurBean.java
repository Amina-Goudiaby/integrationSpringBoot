package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@Entity
public class ElecteurBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationalId;
    private String dateOfBirth;
    private String voterId;
    private String password;
    @OneToOne(mappedBy = "electeur", cascade = CascadeType.ALL)
    private VoteBean vote;

    public ElecteurBean() {
    }

    public ElecteurBean(Long id, String name, String nationalId, String dateOfBirth, String voterId, String password, VoteBean vote) {
        this.id = id;
        this.name = name;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.voterId = voterId;
        this.password = password;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getPassword() {
        return password;
    }

    public VoteBean getVote() {
        return vote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVote(VoteBean vote) {
        this.vote = vote;
    }
}
