package com.bdg.springrest.security.filter;

import com.bdg.springrest.security.token.TokenAuthentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getParameter("token");
        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        if (token == null) {
            tokenAuthentication.setAuthenticated(false);
        } else {
            SecurityContextHolder.getContext().setAuthentication(tokenAuthentication);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
