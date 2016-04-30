package ua.gnatyuk.yaroslav.music_shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;

/**
 * Created by asutp on 25.04.16.
 */
@Configuration
@EnableWebSecurity

public class SpringSequrityConfig extends WebSecurityConfigurerAdapter {
    @Inject
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.authorizeRequests()
                .antMatchers("/admin*").hasRole("ADMIN")
                .anyRequest().hasRole("USER")
                .and().formLogin()
                .and().csrf().disable();*/
        http.authorizeRequests().antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/admin/artist-main-page")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password")
                .and().logout().logoutSuccessUrl("/login?logout")
//                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
