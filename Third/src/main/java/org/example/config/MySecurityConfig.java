package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/claims/**").hasRole("normal")
                .antMatchers("/investigator/**").hasRole("normal")
                .anyRequest().authenticated()
                .and().httpBasic();
               }


    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception
    {
          auth.inMemoryAuthentication().withUser("user").password("pass").roles("normal");
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {

        return NoOpPasswordEncoder.getInstance();
    }

}
