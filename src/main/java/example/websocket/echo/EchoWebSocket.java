package example.websocket.echo;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebSocket
public class EchoWebSocket {

    private static final Logger log = LoggerFactory
            .getLogger(EchoWebSocket.class);

    @OnWebSocketConnect
    public void onConnect(Session session) {
        log.debug("client connected: {}", session.getLocalAddress());
    }

    @OnWebSocketMessage
    public void onText(Session session, String message) {
        log.debug("message received: {}", session);
        session.getRemote().sendStringByFuture(message);
    }

    @OnWebSocketClose
    public void close(Session session, int statusCode, String reason) {
        log.debug("client closed: {} (code: {}, reason: {})", session,
                statusCode, reason);
    }
}
