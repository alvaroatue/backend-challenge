    package com.example.backend_challenge.Configurations;

    import com.example.backend_challenge.Entities.UserEntity;
    import com.example.backend_challenge.Services.JwtService;
    import com.example.backend_challenge.Services.UserService;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import lombok.NonNull;
    import lombok.RequiredArgsConstructor;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
    import org.springframework.stereotype.Component;
    import org.springframework.web.filter.OncePerRequestFilter;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    @Component
    @RequiredArgsConstructor
    public class JwtAuthFilter extends OncePerRequestFilter {

        private final JwtService jwtService;
        private final UserService userService;

        @Override
        protected void doFilterInternal(
                @NonNull HttpServletRequest request,
                @NonNull HttpServletResponse response,
                @NonNull FilterChain filterChain
        ) throws ServletException, IOException {
            try {
                final String authHeader = request.getHeader("Authorization");
                System.out.println("Processing request to: " + request.getRequestURI());

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    filterChain.doFilter(request, response);
                    return;
                }

                final String jwt = authHeader.substring(7);
                System.out.println("Validating token...");

                final String userEmail = jwtService.extractUsername(jwt);
                System.out.println("Extracted email: " + userEmail);

                if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserEntity userEntity = userService.findByEmail(userEmail)
                            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userEmail));

                    if (jwtService.isTokenValid(jwt, userEntity)) {
                        System.out.println("Token is valid");
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                                userEntity, null, userEntity.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    } else {
                        System.out.println("Token validation failed");
                    }
                }

            } catch (Exception e) {
                System.out.println("Error in filter: " + e.getMessage());
                e.printStackTrace();
            }

            filterChain.doFilter(request, response);
        }
    }
