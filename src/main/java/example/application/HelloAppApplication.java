package example.application;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import example.configuration.HelloAppConfiguration;
import example.health.TemplateHealthCheck;
import example.resource.HelloResource;
import example.websocket.echo.EchoWebSocket;

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
        bootstrap.addBundle(new AssetsBundle("/assets", "/app", "index.html",
                "assets"));
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

        environment.getApplicationContext().setHandler(new WebSocketHandler() {

            @Override
            public void configure(WebSocketServletFactory factory) {
                factory.register(EchoWebSocket.class);
            }
        });
    }
}
