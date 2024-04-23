package week3.의존역전원칙;

//상위 모듈
public class Computer {
    StorageDevice storageDevice;

    void start() {
        storageDevice.readData();
        System.out.println("컴퓨터를 시작 합니다.");
    }
}
