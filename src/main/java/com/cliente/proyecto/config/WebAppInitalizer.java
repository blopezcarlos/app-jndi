package com.cliente.proyecto.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan({ 
	"com.cliente.proyecto.controller", 
	"com.cliente.proyecto.service", 
	"com.cliente.proyecto.config" })
public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebAppInitalizer.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}
	
}
