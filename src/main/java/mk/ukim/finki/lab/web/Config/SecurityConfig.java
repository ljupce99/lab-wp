package mk.ukim.finki.lab.web.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {




//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests().anyRequest().permitAll(); // Дозволи пристап насекаде
//        return http.build();
//    }


        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->authorizeRequests
                        .requestMatchers("/login","/listSongs","/Details","/artist")
                        .permitAll()
                        .requestMatchers("/addcomment","/songs/Details/*","/songs")
                        .hasRole("USER")
                        .requestMatchers("/**")
                        .hasRole("ADMIN")

                )
                .formLogin((form) -> form
                        .permitAll()
                        .failureUrl("/login?error=BadCredentials")
                        .defaultSuccessUrl("/listSongs", true)
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/listSongs")
                        .permitAll()

                );


        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryAuthentication(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles("ADMIN")
                        .build()
                ,User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build()
        );
    }

}
