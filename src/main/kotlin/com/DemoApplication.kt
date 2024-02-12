package com

import jakarta.ws.rs.core.Application
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import org.eclipse.microprofile.openapi.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "Movies APIs",
        description = "Movie Application",
        version = "1.0.0",
        license = License(
            name = "MIT",
            url = "http://localhost:8080"
        )
    )
)
class DemoApplication : Application()