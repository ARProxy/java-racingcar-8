package racingcar.service;

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
}
