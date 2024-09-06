package init;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Bean
	public InMemoryUserDetailsManager users() {
		List<UserDetails> usuarios=List.of(
				User.withUsername("user1")
				.password("{noop}user1")
				.roles("USERS")
				.build(),
				User.withUsername("user2")
				.password("{noop}user2")
				.roles("OPERATORS")
				.build(),
				User.withUsername("admin")
				.password("{noop}admin")
				.roles("USERS","ADMINS")
				.build());
		return new InMemoryUserDetailsManager(usuarios);
	}
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		http.csrf(c->c.disable())
		.authorizeHttpRequests(
				aut->aut.requestMatchers(HttpMethod.GET, "/buscar/*").authenticated()
				.requestMatchers(HttpMethod.POST, "/alta").hasRole("ADMINS")
				.requestMatchers(HttpMethod.DELETE, "/eliminar/*").hasAnyRole("ADMINS","OPERATORS")
				.requestMatchers(HttpMethod.PUT, "/actualizar").hasAnyRole("OPERATORS")
				.anyRequest().permitAll()
				)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
