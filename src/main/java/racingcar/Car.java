package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    private static int playerNum = 0;
    public Car(String name) {
        this.name = name;
        playerNum++;
    }

    public void move() {
        this.position++;
    }

    public void printPos() {
        System.out.print(this.name + " : ");
        for(int i = 0;i < this.position;i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    // 추가 기능 구현
}
