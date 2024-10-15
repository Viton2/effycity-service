package com.ceub.pi.effycityservice.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**",
                                    "/swagger-ui/index.html",
                                    "/login")
                            .permitAll();
                })
                .build();
    }

//    @Bean
//    public static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

//    @Bean
//    public AuthenticationManager authenticationManager(
//            UserDetailsService userDetailsService,
//            PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//
//        ProviderManager providerManager = new ProviderManager(authenticationProvider);
//        providerManager.setEraseCredentialsAfterAuthentication(false);
//
//        return providerManager;
//    }
//
//    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();



//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.withUsername("user")
//                .password(encoder.encode("password"))
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

//    @Bean
//    DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType()
//                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
//                .build();
//    }
}
