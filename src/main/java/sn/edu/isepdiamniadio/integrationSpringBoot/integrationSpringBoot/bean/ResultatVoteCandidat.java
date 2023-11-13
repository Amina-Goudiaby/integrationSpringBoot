package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean;

public class ResultatVoteCandidat {
    private String candidat;
    private Long nombreDeVoix;

    public ResultatVoteCandidat(String candidat, Long nombreDeVoix) {
        this.candidat = candidat;
        this.nombreDeVoix = nombreDeVoix;
    }

    public String getCandidat() {
        return candidat;
    }

    public Long getNombreDeVoix() {
        return nombreDeVoix;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    public void setNombreDeVoix(Long nombreDeVoix) {
        this.nombreDeVoix = nombreDeVoix;
    }
}
