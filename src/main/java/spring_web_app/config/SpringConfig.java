package spring_web_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = "spring_web_app")
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("SpringConfig.viewResolver()");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// It specifies that JSTL views should be used. 
		//JstlView is a class provided by the Spring framework that is specifically designed to handle JSP pages using JSTL.
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**")
	            .addResourceLocations("/resources/");
	}

	

}
