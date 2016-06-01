import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by eric on 20/05/16.
 */


    @WebFilter(filterName = "corsFilter")
    public class CorsFilter implements Filter {


        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        /**
         * Handles CORS requests
         *
         * OPTIONS are let through with OK status and CORS headers, and skip the Authentication.
         * other requests have their headers set for ORS too, but continue the filter chain to the Authentication.
         */
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            System.out.println("Filter: " + servletRequest.getServerName());


            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            if (request.getMethod().equals(HttpMethod.OPTIONS)) {
                response.setStatus(HttpServletResponse.SC_OK);
            }
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,Authorization");

            if (!request.getMethod().equals(HttpMethod.OPTIONS)) {
                filterChain.doFilter(request, response);
            }
            System.out.println("Sortie Filter: " + servletRequest.getServerName());
        }

        @Override
        public void destroy() {

        }

    }
