package example.representation;

import static org.junit.Assert.*

import org.junit.Test

class SayingTest {

    @Test
    void idが1の時、getIdはidを返す() {
        def sut = new Saying(1, "foo")
        assert sut.getId() == 1
    }

    @Test
    void contentがfooの時、getContentはfooを返す() {
        def sut = new Saying(1, "foo")
        assert sut.getContent() == "foo"
    }
}
