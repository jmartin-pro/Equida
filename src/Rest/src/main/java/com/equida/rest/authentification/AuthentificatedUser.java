package com.equida.rest.authentification;

import com.equida.rest.bdd.entity.Compte;
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
	
}
