package example.resource;

import static org.junit.Assert.*;

import org.junit.Test;
import com.google.common.base.Optional;

class HelloResourceTest {

    @Test
    void "sayHelloはnameが空ならhello, aaa!を返す"() {
        def sut = new HelloResource("hello, %s!", "aaa")
        def actual = sut.sayHello(Optional.absent())
        assert actual.content == "hello, aaa!"
    }

    @Test
    void "sayHelloはnameがworldならhello, world!を返す"() {
        def sut = new HelloResource("hello, %s!", "aaa")
        def actual = sut.sayHello(Optional.of("world"))
        assert actual.content == "hello, world!"
    }
}
