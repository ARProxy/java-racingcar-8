package racingcar.core;

import racingcar.dto.CarsAndRacingCount;
import racingcar.service.RaceService;

public class RaceFacade {
    private static RaceFacade instance;
    private final RaceService raceService;

    private RaceFacade() {
        this.raceService = new RaceService();
    }

    public static RaceFacade getInstance() {
        if (instance == null) {
            instance = new RaceFacade();
        }
        return instance;
    }

    public String racingCar(CarsAndRacingCount carsAndRacingCount) {
        var cars = raceService.carNameSplit(carsAndRacingCount);
        var carsStatus = raceService.carsStatus(cars, carsAndRacingCount);
        return raceService.raceResult(cars, carsStatus);
    }
}
