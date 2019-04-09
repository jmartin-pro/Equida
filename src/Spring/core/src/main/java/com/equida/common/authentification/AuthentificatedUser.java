package com.equida.common.authentification;

import com.equida.common.bdd.entity.Compte;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthentificatedUser implements UserDetails {

	private final Compte compte;
	
	public AuthentificatedUser(Compte compte) {
		this.compte = compte;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> grantedAuthoritys = new ArrayList<>(); 
		grantedAuthoritys.add(new SimpleGrantedAuthority("ROLE_"+compte.getRole().getLibelle()));

		return grantedAuthoritys;
	}
	
	public boolean hasRole(String role) {
		return compte.getRole().getLibelle().equals(role);
	}

	@Override
	public String getPassword() {
		return compte.getMdp();
	}

	@Override
	public String getUsername() {
		return compte.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !compte.getDeleted();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return !compte.getDeleted();
	}

	public Compte getCompte() {
		return compte;
	}
	
}
