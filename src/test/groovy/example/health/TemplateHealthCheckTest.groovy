package example.health;

import static org.junit.Assert.*;

import java.awt.GraphicsConfiguration.DefaultBufferCapabilities;

import org.junit.Test;

import com.codahale.metrics.health.HealthCheck.Result;

class TemplateHealthCheckTest {

    @Test
    void "テンプレートに置換文字列%sが含まれていればhealthy"() {
        def sut = new TemplateHealthCheck("%s")

        assert sut.check().isHealthy() == true
    }

    @Test
    void "テンプレートに置換文字列%sが含まれていなければunhealthy"() {
        def sut = new TemplateHealthCheck("UNHEALTHY!")

        assert sut.check().isHealthy() == false
    }
}