import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BowlingGameTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @ParameterizedTest
  @CsvSource({"0, 0, 0", "3, 5, 8"})
  void should_the_score_be_total_number_bowls_struck_down_when_calculate_turn_score_given_not_10th_turn_and_not_all_bowls_struck_down(
      int firstThrow, int secondThrow, int exceptedScore) {
    //given
    BowlingGame bowlingGame = new BowlingGame();
    Turn oneTurn = new Turn(Arrays.asList(firstThrow, secondThrow));
    bowlingGame.recordGoalStatus(3, oneTurn);

    //when
    int score = bowlingGame.cal_score(3);

    //then
    assertEquals(exceptedScore, score);
  }
}
