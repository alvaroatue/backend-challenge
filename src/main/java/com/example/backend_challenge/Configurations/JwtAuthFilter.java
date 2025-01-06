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
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
    import org.springframework.stereotype.Component;
    import org.springframework.web.filter.OncePerRequestFilter;

    import java.io.IOException;

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
                String path = request.getRequestURI();
                System.out.println("Processing request to path: " + path);

                final String authHeader = request.getHeader("Authorization");
                System.out.println("Auth header: " + authHeader);

                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    System.out.println("No valid auth header found, proceeding with filter chain");
                    filterChain.doFilter(request, response);
                    return;
                }

                // Rest of your code...
            } catch (Exception e) {
                System.out.println("Error in JWT filter: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }