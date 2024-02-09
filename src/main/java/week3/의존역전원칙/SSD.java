package week3.의존역전원칙;

//하위모듈 -> 구체적인 구현체
public class SSD implements StorageDevice{
    @Override
    public void readData() {
        System.out.println("SSD를 읽습니다.");
    }
}
