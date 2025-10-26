package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarsAndRacingCount;

public class RaceService {

    public String[] carNameSplit(CarsAndRacingCount carsAndRacingCount) {
        var carNames = carsAndRacingCount.carNames().split(",");
        checkCarNameLength(carNames);
        return carNames;
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
        for (int i = 0; i < count; i++) {
            for(int j = 0; j < cars.length; j++) {
                if(movingCase()) {
                    carsStatus[j] += 1;
                }
            }
        }
        return carsStatus;
    }
}
