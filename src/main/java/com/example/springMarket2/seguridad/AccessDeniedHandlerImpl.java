package com.example.springMarket2.seguridad;

import java.io.IOException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.file.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

//    private static Logger log = (Logger) LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);



	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			org.springframework.security.access.AccessDeniedException accessDeniedException)
			throws IOException, ServletException {
        
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        if (auth != null) {
//            log.info(auth.getName()
//                    + " was trying to access protected resource: "
//                    + request.getRequestURI());
//        }

        response.sendRedirect(request.getContextPath() + "/access-denied");	
        
       
	}

}
