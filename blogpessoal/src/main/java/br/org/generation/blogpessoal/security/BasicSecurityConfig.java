package br.org.generation.blogpessoal.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
public class BasicSecurityConfig extends WebSecurityConfigurerAdaper{

	@Autowired
	private UserDetalisService userDetalisService;
	
	protected void configure (AuthenticationManagerBuider auth) throws Exception {
		
		auth.userDetailsService(userDetalisService);
		auth.inMemoryAuthentication()
			.withUser("root")
			.passaword(passwordEncoder().escode("root"))
			.authorities("ROLE_USER");
	}

	@Bean
	public PasswordEncocer passwordEncocer() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Excetion {
		
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}
	
	

}
