package racingcar.service;

import racingcar.dto.CarsAndRacingCount;

public class RaceService {

    public String[] carNameSplit(CarsAndRacingCount carsAndRacingCount) {
        return carsAndRacingCount.carNames().split(",");
    }
}
