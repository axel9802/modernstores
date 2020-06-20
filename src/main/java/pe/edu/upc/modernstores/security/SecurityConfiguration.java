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
		auth.authenticationProvider(authenticationProvider() );
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/modernstores/starter/inicio.html").permitAll()
		.antMatchers("/modernstores/tendencia").permitAll()
		.antMatchers("/modernstores/ropacarrito/listarRopaCarrito").hasRole("CLIENTE")
		.antMatchers("/modernstores/tendencia/listarCompras").hasRole("CLIENTE")
		.antMatchers("/modernstores/tendencia/nuevo/**").hasAuthority("ACCESS_ADDNEWPURCHASE")
		.antMatchers("/modernstores/ropacarrito/nuevo").hasAuthority("ACCESS_ADDCARTPURCHASE")
//		.antMatchers(method)
		.and()
		.formLogin()
    	    .loginProcessingUrl("/signin")
		    .loginPage("/modernstores/starter/login")
		    .usernameParameter("inputUsername")
		    .passwordParameter("inputPassword")
	    .and()
	    .logout()
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/modernstores/starter/login")
	    .and()
	    .rememberMe()
		    .tokenValiditySeconds(2592000)
		    .key("Cl4v3.")
		    .rememberMeParameter("checkRememberMe")
		    .userDetailsService(usuarioDetailsService)
	    .and()
		    .exceptionHandling()
		    .accessDeniedHandler(loggingAccessDeniedHandler);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();		
	}
	
	DaoAuthenticationProvider authenticationProvider () {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();	
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);
		return daoAuthenticationProvider; 
	}
	
	
}
