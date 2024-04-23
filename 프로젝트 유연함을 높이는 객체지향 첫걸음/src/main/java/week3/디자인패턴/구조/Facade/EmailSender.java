package week3.디자인패턴.구조.Facade;

public class EmailSender implements MessageSender{
    @Override
    public void send(String message) {
        System.out.println("Email-message = " + message);
        //이메일 보내는 로직
    }
}
