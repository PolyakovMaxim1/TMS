package netCracker.tms.config;

import netCracker.tms.models.Enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

    @Bean
    PasswordEncoder bPasswordEncoder() {
        PasswordEncoder bPasswordEncoder = new BCryptPasswordEncoder();
        return bPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        auth.inMemoryAuthentication().passwordEncoder(bPasswordEncoder())
                    .withUser("Admin")
                    .password(bPasswordEncoder().encode("admin"))
                    .roles("ADMIN")
                .and()
                    .withUser("User")
                    .password(bPasswordEncoder().encode("user"))
                    .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http        .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/login", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/userpage/alltickets/{id}").failureUrl("/login?error").permitAll()
                .and()
                    .logout().logoutSuccessUrl("/").permitAll();
    }
}