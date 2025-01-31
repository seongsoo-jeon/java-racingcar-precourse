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

    public void nameInspect(String temp) {
        if(temp.length() >= 6) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 한다.");
        }
    }

    public void gameSet() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameInput = Console.readLine().split(",");

        List<Car> carList = new ArrayList<Car>();
        try {
            for (int i = 0; i < nameInput.length; i++) {
                nameInspect(nameInput[i]);
                carList.add(new Car(nameInput[i]));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름은 5자 이하여야 한다.");
            carList.clear();
            nameInput = Console.readLine().split(",");
            for(int i = 0;i < nameInput.length;i++) {
                carList.add(new Car(nameInput[i]));
            }
        }
        System.out.println("시도할 횟수는 몇회인가요?");
        int count = 0;
        try {
            count = Integer.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            count = Integer.valueOf(Console.readLine());
        }
        this.player = carList;
        this.countGame = count;
        this.playerNum = nameInput.length;

        System.out.println("실행 결과");
        for(int i = 1;i <= this.countGame;i++) {
            gameStart(i);
        }


    }
    public void gameStart(int n) {

        for(int i = 0;i < playerNum;i++) {
            if(Randoms.pickNumberInRange(0, 9) >= 4) {
                this.player.get(i).move();
            }
            this.player.get(i).printPos();
        }
        System.out.println();

        if(n == this.countGame) {
            printWinner();
        }

    }

    public void printWinner() {
        List<String> win = new ArrayList<String>();
        int max = 0;
        int cnt = 0;

        for(int i = 0;i < this.playerNum;i++) {
            if(max < this.player.get(i).getPosition()) {
                max = this.player.get(i).getPosition();
            }
        }

        for(int i = 0;i < this.playerNum;i++) {
            if(max == this.player.get(i).getPosition()) {
                win.add(this.player.get(i).getName());
                cnt++;
            }
        }

        System.out.print("최종 우승자 : ");
        for(int i = 0;i < win.size();i++) {
            System.out.print(win.get(i));
            if(i < cnt - 1) {
                System.out.print(", ");
            }
        }

    }

}
