package example.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import example.configuration.HelloAppConfiguration;
import example.health.TemplateHealthCheck;
import example.resource.HelloResource;

public class HelloAppService extends Service<HelloAppConfiguration> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Bootstrap<HelloAppConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(HelloAppConfiguration configuration, Environment environment)
            throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();

        environment.addResource(new HelloResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }
}
