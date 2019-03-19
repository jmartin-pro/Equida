package com.equida.rest.authentification;

import com.equida.common.bdd.entity.Compte;
import com.equida.common.bdd.repository.CompteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements UserDetailsService {
 
    @Autowired
    private CompteRepository compteRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Compte> compte = compteRepository.findByLogin(username);
		
        if (!compte.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
		
        return new AuthentificatedUser(compte.get());
    }
}
