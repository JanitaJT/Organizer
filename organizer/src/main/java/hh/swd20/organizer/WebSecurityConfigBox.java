package hh.swd20.organizer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import hh.swd20.organizer.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigBox extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/styles/**").permitAll() 
		// Jotta css toimii, static/styles
		.and().authorizeRequests().antMatchers("/home","/h2-console/**").permitAll()
		.and().csrf().ignoringAntMatchers("/h2-console/**")
		.and()
		.headers().frameOptions().sameOrigin()
		.and().authorizeRequests().antMatchers("/auth/*").hasAnyAuthority("ADMIN", "USER") 
		// Määritetty kellä on oikeus /auth/* endpointtiin
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/auth/logged", true).permitAll()
		.and().logout().logoutSuccessUrl("/home")
		.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList();
		
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("user")).roles("USER").build();
		users.add(user);
		
		user = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build();
		users.add(user);
		
		return new InMemoryUserDetailsManager(users);
		
	}
	

}


