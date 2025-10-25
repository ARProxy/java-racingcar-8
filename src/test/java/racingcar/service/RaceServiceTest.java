package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsAndRacingCount;

class RaceServiceTest {

    private RaceService raceService;
    private CarsAndRacingCount carsAndRacingCount;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
        carsAndRacingCount = new CarsAndRacingCount(
                "pobi,woni,jun",
                5
        );
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        //when
        String[] result = raceService.carNameSplit(carsAndRacingCount);

        //then
        assertAll(
                () -> assertEquals("pobi", result[0]),
                () -> assertEquals("woni", result[1]),
                () -> assertEquals("jun", result[2])
        );
    }
}