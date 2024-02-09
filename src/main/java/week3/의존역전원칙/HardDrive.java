package week3.의존역전원칙;


//하위 모듈 -> 구체적인 구현체
public class HardDrive implements StorageDevice{

    @Override
    public void readData() {
        System.out.println("하드 드라이브 데이터를 읽습니다. ");
    }
}
