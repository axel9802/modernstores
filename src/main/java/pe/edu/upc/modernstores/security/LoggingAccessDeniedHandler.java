package pe.edu.upc.modernstores.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class LoggingAccessDeniedHandler implements AccessDeniedHandler{

	private static Logger log = LoggerFactory.getLogger(LoggingAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, 
    		AccessDeniedException ex) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            log.info(auth.getName()
                    + " está tratando de acceder a un recurso protegido: "
                    + request.getRequestURI());
        }

        response.sendRedirect(request.getContextPath() + "/modernstores/inicio/access-denied");
    }
}
