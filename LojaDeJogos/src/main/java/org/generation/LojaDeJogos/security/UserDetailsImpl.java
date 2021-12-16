package org.generation.LojaDeJogos.security;

import java.util.Collection;
import java.util.List;

import org.generation.LojaDeJogos.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long seriaVersionUID = 1L;
	
	private String Name;
	private String Password;
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Usuario usuario) {
		this.Name = usuario.getUsuario();
		this.Password = usuario.getSenha();
	}
	
	public UserDetailsImpl() { 
	
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return Password;
	}

	@Override
	public String getUsername() {

		return Name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}