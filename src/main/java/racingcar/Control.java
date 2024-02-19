package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Control {
    int countGame;
    List<Car> player;
    int playerNum;

    public Control() {
        gameSet();
    }


    public void gameSet() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameInput = Console.readLine().split(",");

        List<Car> carList = new ArrayList<Car>();
        for(int i = 0;i < nameInput.length;i++) {
            carList.add(new Car(nameInput[i]));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int count = Integer.valueOf(Console.readLine());

        this.player = player;
        this.countGame = count;
        this.playerNum = nameInput.length;

        for(int i = 1;i <= this.countGame;i++) {
            gameStart(i);
        }


    }
    public void gameStart(int n) {
        System.out.println("실행 결과");
        for(int i = 0;i < playerNum;i++) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                this.player.get(0).move();
                this.player.get(0).printPos();
            }
        }
        System.out.println();

        if(n == countGame) {
            printWinner();
        }

    }

    public void printResult() {

    }

    public void printWinner() {

    }

}