package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Control {
    int countGame;
    List<Car> player;

    public Control(List<Car> player, int countGame) {
        this.player = player;
        this.countGame = countGame;
    }
}
