package example.service;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import example.configuration.HelloAppConfiguration;
import example.health.TemplateHealthCheck;
import example.resource.HelloResource;

public class HelloAppApplication extends Application<HelloAppConfiguration> {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "hello-world";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap<HelloAppConfiguration> bootstrap) {
        // nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(HelloAppConfiguration configuration, Environment environment)
            throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();

        final HelloResource resource = new HelloResource(template, defaultName);
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
                template);

        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
