package ru.moore.carsale.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Car Sale API",
                description = "Car Sale", version = "1.0.0",
                contact = @Contact(
                        name = "Fedor Moore",
                        email = "fedormoore@gmail.com"
                )
        )
)

public class OpenApiConfig {

}
