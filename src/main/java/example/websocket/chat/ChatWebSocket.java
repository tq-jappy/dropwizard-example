package example.websocket.chat;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@WebSocket
public class ChatWebSocket {

    private Session session;

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.println("Connected!");
        this.session = session;
        WebsocketBroadCaster.getInstance().join(this);
    }

    @OnWebSocketMessage
    public void onText(Session session, String message) {
        WebsocketBroadCaster.getInstance().sendToAll(message);
    }

    @OnWebSocketClose
    public void close(int statusCode, String reason) {
        WebsocketBroadCaster.getInstance().bye(this);
    }

    public Session getSession() {
        return this.session;
    }
}
