package com.template.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by pgolovenkov on 10.03.2017.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = Logger.getLogger(WebSecurityConfiguration.class);

    @Bean
    public UserDetailsService userDetailsService() {
        LOG.info("Getting in-memory user details service.");

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
        manager.createUser(User.withUsername("user").password("user").roles("USER").build());

        LOG.info("In-memory user details service is successfully created.");

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        LOG.info("Starting web security configuration.");

        LOG.info("Starting web security authorization configuration.");
        //Http authorization configuration
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .antMatchers("/api/rest/public/**").permitAll()
                .antMatchers("/api/rest/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();

        LOG.info("Starting web security logout configuration.");
        //Logout configuration
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        LOG.info("Web security is successfully configured.");

    }
}
