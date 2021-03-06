package app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.util.json.JsonHttpMessageConverter;

/**
 * Configuracao para permitir CORS nas rotas registradas.
 * Necessário para rodar o projeto com frontend com Vue ou React,
 * que sobrem seus próprios servidores.
 * */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	@Value("${view.index.url}")
	private String VIEW_INDEX_URL;
	
	private static final String [] CLASSPATH_RESOURCE_LOCATIONS = { 
			"classpath:/static/", "classpath:/META-INF/resources/static" };

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");	/* Alterar de acordo com a necessidade */
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addRedirectViewController("/", this.VIEW_INDEX_URL);
	}

	
}