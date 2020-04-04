
package com.mycompany.servletJsp;

import java.io.IOException;
import java.net.http.HttpResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class CookiesCheckFilter implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter initialized");
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        System.out.println("Filter destroyed");
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        Cookie c1 = new Cookie("cookie", "cookie");
        ((HttpServletResponse) response).addCookie(c1);

        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        
        if (cookies != null ||((HttpServletRequest) request).getParameter("flag")==null ||((HttpServletRequest) request).getParameter("flag").equals("true") ) {
            System.out.println("doFilter");
            chain.doFilter(request, response);
        } else {
            System.out.println("else doFilter");
            ((HttpServletResponse) response).sendRedirect("login?flag=false");
            return;
        }
    }
}
