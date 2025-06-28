package spring_web_app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebServletConfiguration implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		System.out.println("WebServletConfiguration.onStartup()");
		AnnotationConfigWebApplicationContext annWebConfig = new AnnotationConfigWebApplicationContext();
		annWebConfig.register(SpringConfig.class);
		annWebConfig.setServletContext(ctx);
		ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(annWebConfig));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
