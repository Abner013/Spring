package br.org.generation.blogpessoal.security;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpol implements UserDetalis{

	private String userName;
	privete String password;
	private List<GrantedAuthority> authorites;
	
	public UserDetaisImpl(Usuario usuario) {
		this.userName = usuario.getUsuario();
		this.password = usuario.getSenha();
	}
	public UserDetailsImpl() {	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return userName;
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
