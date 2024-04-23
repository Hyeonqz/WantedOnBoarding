package week3.디자인패턴.구조.Facade;

public class SMSSender implements MessageSender{
    @Override
    public void send(String message) {
        System.out.println("SMS-message = " + message);
        //SMS보내는 로직
    }
}
