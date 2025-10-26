package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void 경주에는_2대_이상의_자동차가_필요하다() {
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> raceService.carNameSplit(new CarsAndRacingCount(
                        "pobi",
                        5
                )));
    }

    @Test
    void 단독_우승자를_정확히_반환한다() {
        //given
        String[] cars = {"pobi", "woni", "jun"};
        int[] carsStatus = {5, 3, 2};

        //when
        String result = raceService.raceResult(cars, carsStatus);

        //then
        assertEquals("pobi", result);
    }

    @Test
    void 공동_우승자를_쉼표로_구분하여_반환한다() {
        //given
        String[] cars = {"pobi", "woni", "jun"};
        int[] carsStatus = {5, 5, 2};

        //when
        String result = raceService.raceResult(cars, carsStatus);

        //then
        assertEquals("pobi, woni", result);
    }

    @Test
    void 모든_자동차가_동점이면_전원을_우승자로_반환한다() {
        //given
        String[] cars = {"pobi", "woni", "jun"};
        int[] carsStatus = {3, 3, 3};

        //when
        String result = raceService.raceResult(cars, carsStatus);

        //then
        assertEquals("pobi, woni, jun", result);
    }
}