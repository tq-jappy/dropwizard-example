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

    private Logger logger = LoggerFactory.getLogger(EchoWebSocket.class);

    @OnWebSocketConnect
    public void onConnect(Session session) {
        logger.debug("client connected: %s", session);
    }

    @OnWebSocketMessage
    public void onText(Session session, String message) {
        logger.debug("message received: %s", session);
        session.getRemote().sendStringByFuture(message);
    }

    @OnWebSocketClose
    public void close(Session session, int statusCode, String reason) {
        logger.debug("client closed: %s (code: %d, reason: %s)", session,
                statusCode, reason);
    }
}
