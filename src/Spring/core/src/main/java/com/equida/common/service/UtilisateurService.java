package com.equida.common.service;

import com.equida.common.bdd.entity.Client;
import com.equida.common.bdd.entity.Compte;
import com.equida.common.bdd.entity.DirecteurGeneral;
import com.equida.common.bdd.entity.Pays;
import com.equida.common.bdd.entity.Role;
import com.equida.common.exception.NotFoundException;
import com.equida.common.exception.ServiceException;
import com.equida.common.bdd.entity.Utilisateur;
import com.equida.common.bdd.repository.CompteRepository;
import com.equida.common.bdd.repository.UtilisateurRepository;
import com.equida.common.exception.FieldException;
import com.equida.common.utils.Sha256PasswordEncoder;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	public List<Utilisateur> getAll(PageRequest pageRequest) {
		return utilisateurRepository.findAll(pageRequest);
	}
	
	public List<Utilisateur> getAll() {
		return utilisateurRepository.findAll();
	}
	
	public Utilisateur getById(Long idUtilisateur) throws NotFoundException {
		if(idUtilisateur == null) {
			throw new ServiceException("L'id ne doit pas être null.");
		}
				
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(idUtilisateur);
	
		if(!utilisateur.isPresent()) {
			throw new NotFoundException("L'id de l'utilisateur spécifié n'existe pas.");
		}
		
		return utilisateur.get();
	}
	
	public Utilisateur update(Long idUtilisateur, String nom, String prenom, String rue, String copos, String ville, Long idPays, String mail, String login, String mdp) throws NotFoundException, FieldException {	
		if(idUtilisateur == null) {
			throw new ServiceException("idCheval ne doit pas être null.");
		}
		
		if(nom == null) {
			throw new ServiceException("nom ne doit pas être null");
		}
		
		if(prenom == null) {
			throw new ServiceException("prenom ne doit pas être null");
		}	
		
		if(rue == null) {
			throw new ServiceException("rue ne doit pas être null");
		}
		
		if(copos == null) {
			throw new ServiceException("copos ne doit pas être null");
		}
		
		if(ville == null) {
			throw new ServiceException("ville ne doit pas être null");
		}
		
		if(mail == null) {
			throw new ServiceException("mail ne doit pas être null");
		}
		
		if(login == null) {
			throw new ServiceException("login ne doit pas être null");
		}
		
		if(mdp == null) {
			throw new ServiceException("mdp ne doit pas être null");
		}
				
		Utilisateur utilisateur = getById(idUtilisateur);
		Compte compte = null;
		
		if(utilisateur.getCompte()!=null) {
			compte = compteRepository.findByLogin(utilisateur.getCompte().getLogin()).get();
		} else {
			compte = new Compte();
			compte.setRole(new Role(2L));
		}
		
		if(!login.equals(compte.getLogin())){
			if(compteRepository.findByLogin(login).isPresent()){
				throw new FieldException("Le login existe déjà.");
			}
		}
		
		Sha256PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
		compte.setLogin(login);
		compte.setMdp(passwordEncoder.encode(mdp));
		compte.setDeleted(false);
		
		Compte compteBdd = compteRepository.save(compte);
		
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setRue(rue);
		utilisateur.setCopos(copos);
		utilisateur.setVille(ville);
		utilisateur.setMail(mail);
		utilisateur.setDeleted(false);
		Pays pays = new Pays();
		pays.setId(idPays);
		utilisateur.setPays(pays);
		utilisateur.setDeleted(false);
		
		utilisateur.setCompte(compteBdd);
		
		return save(utilisateur);
	}
	
	public Utilisateur create(String nom, String prenom, String rue, String copos, String ville, Long idPays, String mail, String login, String mdp, Long idRole) throws FieldException {
		if(nom == null) {
			throw new ServiceException("nom ne doit pas être null");
		}
		
		if(prenom == null) {
			throw new ServiceException("prenom ne doit pas être null");
		}	
		
		if(rue == null) {
			throw new ServiceException("rue ne doit pas être null");
		}
		
		if(copos == null) {
			throw new ServiceException("copos ne doit pas être null");
		}
		
		if(ville == null) {
			throw new ServiceException("ville ne doit pas être null");
		}
		
		if(mail == null) {
			throw new ServiceException("mail ne doit pas être null");
		}
		
		if(login == null) {
			throw new ServiceException("login ne doit pas être null");
		}
		
		if(mdp == null) {
			throw new ServiceException("mdp ne doit pas être null");
		}
		
		if(compteRepository.findByLogin(login).isPresent()){
			throw new FieldException("Le login existe déjà.");
		}
		
		Utilisateur utilisateur = null;
		if(idRole == 1){
			utilisateur = new DirecteurGeneral();
		} else if (idRole == 2) {
			utilisateur = new Client();
		} else {
			throw new ServiceException("Le role n'existe pas.");
		}
		utilisateur.setId(null);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setRue(rue);
		utilisateur.setCopos(copos);
		utilisateur.setVille(ville);
		utilisateur.setMail(mail);
		utilisateur.setDeleted(false);
		Pays pays = new Pays();
		pays.setId(idPays);
		utilisateur.setPays(pays);
		Sha256PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();
		Compte compte = new Compte();
		compte.setId(null);
		compte.setLogin(login);
		compte.setMdp(passwordEncoder.encode(mdp));
		Role role = new Role();
		role.setId(idRole);
		compte.setRole(role);
		compte.setDeleted(false);
		
		Compte compteBdd = compteRepository.save(compte);
		
		utilisateur.setCompte(compteBdd);
		
		return this.save(utilisateur);
	}
		
	public void delete(Long idUtilisateur) throws NotFoundException {
		if(idUtilisateur == null) {
			throw new ServiceException("idUtilisateur ne doit pas être null.");
		}
		
		Utilisateur utilisateur = getById(idUtilisateur);
		
		if(!utilisateur.getId().equals(idUtilisateur)) {
			throw new NotFoundException();
		}
		
		if(utilisateur.getCompte()!= null) {
			utilisateur.getCompte().setDeleted(true);
		}
		utilisateur.setDeleted(true);
		save(utilisateur);
	}
	
	public Utilisateur save(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}
	
}