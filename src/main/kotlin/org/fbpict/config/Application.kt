package org.fbpict.config

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.boot.builder.SpringApplicationBuilder



@SpringBootApplication
@ComponentScan(basePackages = ["org.fbpict"])
@EntityScan(basePackages = ["org.fbpict"])
@EnableJpaRepositories(basePackages = ["org.fbpict.repo"])
@EnableAsync
@PropertySources(PropertySource("classpath:application.properties"), PropertySource("file:\${user.home}/properties/fbpict.properties"))
class Application :SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(Application::class.java)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

