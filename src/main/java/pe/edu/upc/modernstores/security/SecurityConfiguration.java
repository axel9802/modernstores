package pe.edu.upc.modernstores.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;

	@Autowired
	private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http);
		http
		.authorizeRequests()
				.antMatchers("/modernstores/starter.html").permitAll()
				.antMatchers("/modernstores/tendencia").hasRole("CLIENTE")
				.antMatchers("/modernstores/tendencia/listarCompras").hasAnyRole("CLIENTE","COMERCIANTE")
				.antMatchers("/modernstores/ropacarrito/listarRopaCarrito").hasRole("CLIENTE")
				.antMatchers("/modernstores/clientes").hasAnyRole("CLIENTE","ADMINISTRADOR")
				.antMatchers("/modernstores/clientes/edit/**").hasAnyRole("ADMINISTRADOR","CLIENTE")
				.antMatchers("/modernstores/clientes/del").hasRole("ADMINISTRADOR")
				.antMatchers("/modernstores/clientes/new").hasRole("CLIENTE")
				.antMatchers("/modernstores/comerciantes").hasAnyRole("COMERCIANTE","ADMINISTRADOR")
				.antMatchers("/modernstores/comerciantes/edit").hasRole("ADMINISTRADOR")
				.antMatchers("/modernstores/comerciantes/del").hasRole("ADMINISTRADOR")
				.antMatchers("/modernstores/comerciantes/new").hasRole("COMERCIANTE")
				.antMatchers("/modernstores/suscripciones").hasRole("ADMINISTRADOR")
		.and()
		.formLogin()
				.loginProcessingUrl("/signin")
				.loginPage("/modernstores/inicio/login")
				.usernameParameter("inputUsername")
				.passwordParameter("inputPassword")
		.and()
		.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/modernstores/inicio")
				
		.and()
		.rememberMe()
				.tokenValiditySeconds(6000000)
				.key("Cl4v3.")
				.rememberMeParameter("checkRememberMe")
				.userDetailsService(usuarioDetailsService)
		.and()
			
				.exceptionHandling()
				.accessDeniedHandler(loggingAccessDeniedHandler)
				
				;
				
		

	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Aqui se crea el vinculo entre el spring security y el passwordEncoder y
	// UsuarioDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		return daoAuthenticationProvider;
	}

}
