package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.core.RaceFacade;
import racingcar.dto.CarsAndRacingCount;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames = Console.readLine();

            System.out.println("시도할 횟수는 몇 회인가요?");
            int racingCount = Integer.parseInt(Console.readLine());

            var raceFacade = RaceFacade.getInstance();
            var result = raceFacade.racingCar(new CarsAndRacingCount(carNames, racingCount));
            System.out.println("최종 우승자 : " + result);
        } catch (IllegalArgumentException e) {
            Console.close();
            throw e;
        }
    }
}
