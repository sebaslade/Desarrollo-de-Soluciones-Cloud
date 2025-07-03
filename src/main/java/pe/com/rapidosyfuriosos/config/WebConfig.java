package pe.com.rapidosyfuriosos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//@Configuration -> define como una clase de configuracion
@Configuration
public class WebConfig implements WebMvcConfigurer{
	//@Bean -> define metodos que seran incluidos en el Spring
	//Creamos un metodo para definir la resolucion de plantillas
	@Bean
	public ClassLoaderTemplateResolver templateResolver(){
		//declaramos una variable de tipo ClassLoaderTemplateResolver
		var templateResolver = new ClassLoaderTemplateResolver();
		//Definimos la carpeta donde se encuentran las paginas web
		templateResolver.setPrefix("templates/");
		//Deshabilatamos la opcion cacheable de la aplicacion
		templateResolver.setCacheable(false);
		//Definimos el tipo de paginas que van a cargar
		templateResolver.setSuffix(".html");
		//Definimos el mode de las plantillas de las paginas
		templateResolver.setTemplateMode("HTML5");
		//Definimos que se permita caracteres especiales
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}
	
	//Creamos un Bean para definir el motor de integracion del Thymeleaf
	@Bean
	public SpringTemplateEngine templateEngine() {
		//declaramos una variable de tipo SpringTemplateEngine
		var templateEngine=new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}
	
	//Creamos un Bean para la resolucion de vistas
	@Bean
	public ViewResolver viewResolver() {
		//Creamos un objeto de tipo thymeleaf
		var viewResolver=new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}
	
	//Sobrecargamos el metodo addResourceHandlers para definir la carpeta de recursos
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Habilitamos la carpeta static
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
}
