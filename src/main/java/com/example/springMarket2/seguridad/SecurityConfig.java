package com.example.springMarket2.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.springMarket2.servicios.CustomUserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "/","/index",
                            "/js/**",
                            "/css/**",
                            "/images/**",
                            "/signup",
                            "/registro",
                            "/producto/perfil/**",
                            "/producto/busqueda",
                            "/imagenes/**",
                            "/webjars/**").permitAll()
                    .antMatchers("/compra/**", "/pregunta/**").hasAnyAuthority("ROL_USUARIO","ROL_ADMIN")
                    .antMatchers("/compra/**", "/respuesta/**").hasAnyAuthority("ROL_USUARIO","ROL_ADMIN")
                    .antMatchers("/producto/borrar/**").hasAuthority("ROL_ADMIN")
                    .antMatchers("/producto/crear").hasAuthority("ROL_ADMIN")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .successHandler(myAuthenticationSuccessHandler())
                    .permitAll()
                .and()
                .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .clearAuthentication(true)
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll();
                http.csrf().ignoringAntMatchers("/imagenes/**");
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());     
    }
    
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new AuthenticationSuccessHandlerImpl();
    }

}
