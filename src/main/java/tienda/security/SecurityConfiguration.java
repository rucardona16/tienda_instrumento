package tienda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//        	.authorizeRequests()
//        	.anyRequest().permitAll();
        
        
        http.cors()
        .and()
        .authorizeRequests()
        .anyRequest().fullyAuthenticated()
        .and()
        .httpBasic()
        .and()
        .logout()
        .logoutUrl("/logout")                                                 
        .logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)))
        .and()
        .csrf().disable();
    }

}
