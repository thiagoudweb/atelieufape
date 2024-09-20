package model;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Documentação da API do Atelie U.F.A.P.E")
                    .version("1.0")
                    .description("Documentação das APIs do projeto Atelie usando OpenAPI e Swagger"));
    }
}