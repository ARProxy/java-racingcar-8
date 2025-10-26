package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.dto.CarsAndRacingCount;

public class RaceService {

    public String[] carNameSplit(CarsAndRacingCount carsAndRacingCount) {
        var carNames = carsAndRacingCount.carNames().split(",");
        checkCarNameLength(carNames);
        checkCarsCount(carNames);
        return carNames;
    }

    private void checkCarsCount(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean movingCase() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    public int[] carsStatus(String[] cars, CarsAndRacingCount carsAndRacingCount) {
        int count = carsAndRacingCount.racingCount();
        int[] carsStatus = new int[cars.length];

        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            for(int j = 0; j < cars.length; j++) {
                if(movingCase()) {
                    carsStatus[j] += 1;
                }
            }
            racePrint(cars, carsStatus);
            System.out.println();
        }
        return carsStatus;
    }

    private void racePrint(String[] cars, int[] carsStatus) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + carsStatusParsing(carsStatus[i]));
        }
    }

    private String carsStatusParsing(int carsStatus) {
        return "-".repeat(Math.max(0, carsStatus));
    }

    public String raceResult(String[] cars, int[] carsStatus) {
        int maxValue = Arrays.stream(carsStatus).max().orElse(0);

        return IntStream.range(0, carsStatus.length)
                .filter(i -> carsStatus[i] == maxValue)
                .mapToObj(i -> cars[i])
                .collect(Collectors.joining(", "));
    }
}
