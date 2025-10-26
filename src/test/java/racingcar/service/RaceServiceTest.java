package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarsAndRacingCount;

class RaceServiceTest {

    private RaceService raceService;

    @BeforeEach
    void setUp() {
        raceService = new RaceService();
    }

    @Test
    void 자동차_이름은_쉼표를_기준으로_구분한다() {
        //when
        String[] result = raceService.carNameSplit(
                new CarsAndRacingCount(
                        "pobi,woni,jun",
                        5
                )
        );

        //then
        assertAll(
                () -> assertEquals("pobi", result[0]),
                () -> assertEquals("woni", result[1]),
                () -> assertEquals("jun", result[2])
        );
    }

    @Test
    void 자동차_이름은_5자_이하만_가능하다() {
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> raceService.carNameSplit(new CarsAndRacingCount(
                        "donghwi,song",
                        5
                )));
    }
}