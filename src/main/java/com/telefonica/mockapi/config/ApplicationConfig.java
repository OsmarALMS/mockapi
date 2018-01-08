package com.telefonica.mockapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter{

	@Autowired  
	private BasicAuthenticationPoint basicAuthenticationPoint;
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaData());                                           
    }
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API - Mocks",
                "",
                "1.0",
                "",
                new Contact("Telefonica", "", ""),
               "",
                "");
        return apiInfo;
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//	    http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
//	    http.httpBasic().authenticationEntryPoint(basicAuthenticationPoint);
	}
	
	@Autowired  
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {  
//	     auth.inMemoryAuthentication()
//	     .withUser("dev").password("dev!@#").roles("USER")
//	     .and()
//	     .withUser("mutant").password("mutant123456").roles("USER")
//	     .and()
//	     .withUser("everis").password("everis123456").roles("USER")
//	     .and()
//	     .withUser("accenture").password("accenture123456").roles("USER");
	}
	
}
