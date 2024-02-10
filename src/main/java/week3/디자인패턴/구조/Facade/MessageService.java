package week3.디자인패턴.구조.Facade;

public class MessageService {
    private final MessageSender sender;

    public MessageService(MessageSender sender) {
        this.sender = sender;
    }

    public void send(String message) {
        sender.send(message);
    }
}
