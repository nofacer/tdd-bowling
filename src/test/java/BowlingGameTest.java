import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BowlingGameTest {

  private BowlingGame bowlingGame;

  @BeforeEach
  void setUp() {
    bowlingGame = new BowlingGame();
  }

  @ParameterizedTest
  @CsvSource({"0, 0, 0", "3, 5, 8"})
  void should_the_score_be_total_number_bowls_struck_down_when_calculate_turn_score_given_not_10th_turn_and_not_all_bowls_struck_down(
      int firstThrow, int secondThrow, int exceptedScore) {
    //given
    Turn oneTurn = new Turn(Arrays.asList(firstThrow, secondThrow));
    bowlingGame.recordGoalStatus(3, oneTurn);

    //when
    int score = bowlingGame.calScore(3);

    //then
    assertEquals(exceptedScore, score);
  }

  @Test
  void should_the_score_be_total_number_bowls_struck_down_plus_next_throw_score_when_calculate_turn_score_given_not_10th_turn_and_spare_turn() {
    //given
    Turn firstTurn = new Turn(Arrays.asList(2, 8));
    Turn secondTurn = new Turn(Arrays.asList(10, 0));
    bowlingGame.recordGoalStatus(1, firstTurn);
    bowlingGame.recordGoalStatus(2, secondTurn);

    //when
    int score = bowlingGame.calScore(1);

    //then
    assertEquals(20, score);
  }
}
