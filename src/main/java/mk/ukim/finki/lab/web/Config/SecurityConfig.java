package mk.ukim.finki.lab.web.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {




//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http .csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests()
//        .anyRequest()
//        .permitAll(); // Дозволи пристап насекаде
//        return http.build();
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers((headers)->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .authorizeHttpRequests(authorizeRequests ->authorizeRequests
                        .requestMatchers("/login","/logout")
                        .permitAll()
                        .requestMatchers("/listSongs","/Details","/artist","/addcomment","/songs","/songs/Details/*")
                        .hasAnyRole("USER","ADMIN")
                        .requestMatchers("/songs/**","/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()

                )
                .formLogin((form) -> form
                        .permitAll()
                        .failureUrl("/login?error=ImasGreska")
                        .defaultSuccessUrl("/listSongs", true)
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
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
