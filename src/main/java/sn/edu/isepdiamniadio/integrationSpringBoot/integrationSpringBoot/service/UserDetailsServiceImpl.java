package sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.bean.ElecteurBean;
import sn.edu.isepdiamniadio.integrationSpringBoot.integrationSpringBoot.repository.ElecteurRepository;

import java.util.ArrayList;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ElecteurRepository electeurRepository;

    @Override
    public UserDetails loadUserByUsername(String voterId) throws UsernameNotFoundException {
        ElecteurBean electeur = electeurRepository.findByVoterId(voterId)
                .orElseThrow(() -> new UsernameNotFoundException("Electeur non trouvé avec l'ID : " + voterId));

        return new User(electeur.getVoterId(), electeur.getPassword(), new ArrayList<>());
    }
}

