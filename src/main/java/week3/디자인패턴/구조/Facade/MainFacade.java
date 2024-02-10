package week3.디자인패턴.구조.Facade;

import week3.디자인패턴.생성.단순팩토리.Vehicle;
import week3.디자인패턴.생성.팩토리메소드.CarFactory;
import week3.디자인패턴.생성.팩토리메소드.TruckFactory;

public class MainFacade {
    public static void main(String[] args) {
        MessageService emailService = new MessageService(new EmailSender());
        emailService.send("hello-email");

        MessageService  mmsService = new MessageService(new SMSSender());
        emailService.send("hello-mms");
    }
}
