package example.websocket.chat;

import java.util.ArrayList;
import java.util.List;

public class WebsocketBroadCaster {

    private static WebsocketBroadCaster INSTANCE = new WebsocketBroadCaster();

    private List<ChatWebSocket> clients = new ArrayList<>();

    private WebsocketBroadCaster() {
    }

    protected static WebsocketBroadCaster getInstance() {
        return INSTANCE;
    }

    protected void join(ChatWebSocket socket) {
        clients.add(socket);
    }

    protected void bye(ChatWebSocket socket) {
        clients.remove(socket);
    }

    protected void sendToAll(String message) {
        for (ChatWebSocket member : clients) {
            member.getSession().getRemote().sendStringByFuture(message);
        }
    }
}
