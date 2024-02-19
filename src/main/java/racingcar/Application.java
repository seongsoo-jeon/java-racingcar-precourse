package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        Scanner scan = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] nameInput = Console.readLine().split(",");

        List<Car> carList = new ArrayList<Car>();
        for(int i = 0;i < nameInput.length;i++) {
            carList.add(new Car(nameInput[i]));
        }

        System.out.println("시도할 횟수는 몇회인가요?\n");
        int count = Integer.valueOf(Console.readLine());

        Control controller = new Control(carList, count);

    }
}
