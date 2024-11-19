package br.edu.infnet.alfredo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API: clinicas de serviços médicos")
                .version("1.0")
                .description("API para gestão de clínicas de serviços médicos")
                .contact(new Contact()
                    .name("Equipe de Desenvolvimento")
                    .email("alfredocolito@gmail.com")));
    }
}