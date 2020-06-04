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

  @ParameterizedTest
  @CsvSource({"10,0,10,0,10,0,30", "10,0,2,8,10,0,20", "10,0,10,0,8,0,28"})
  void should_the_score_be_total_number_bowls_struck_down_plus_next_two_throws_score_when_calculate_turn_score_given_not_10th_turn_and_strike_turn_case1(
      int firstTurnFirstGoal, int firstTurnSecondGoal, int secondTurnFirstGoal,
      int secondTurnSecondGoal, int thirdTurnFirstGoal, int thirdTurnSecondGoal, int exceptedScore
  ) {
    //given
    Turn firstTurn = new Turn(Arrays.asList(firstTurnFirstGoal, firstTurnSecondGoal));
    Turn secondTurn = new Turn(Arrays.asList(secondTurnFirstGoal, secondTurnSecondGoal));
    Turn thirdTurn = new Turn(Arrays.asList(thirdTurnFirstGoal, thirdTurnSecondGoal));
    bowlingGame.recordGoalStatus(1, firstTurn);
    bowlingGame.recordGoalStatus(2, secondTurn);
    bowlingGame.recordGoalStatus(3, thirdTurn);

    //when
    int score = bowlingGame.calScore(1);

    //then
    assertEquals(exceptedScore, score);
  }

  @ParameterizedTest
  @CsvSource({"0, 0, 0, 0", "10, 10, 10, 30", "10, 2, 8, 20", "2, 8, 0, 10"})
  void should_the_score_be_total_number_bowls_struck_down_when_calculate_turn_score_given_is_10th_turn(
      int firstThrow, int secondThrow, int thirdThrow, int exceptedScore) {
    //given
    Turn tenthTurn = new Turn(Arrays.asList(firstThrow, secondThrow, thirdThrow));
    bowlingGame.recordGoalStatus(10, tenthTurn);

    //when
    int score = bowlingGame.calScore(10);

    //then
    assertEquals(exceptedScore, score);
  }

  @Test
  void should_the_total_score_be_300_when_calculate_total_score_of_one_game_given_every_throw_strikes_down_all_bowls() {
    //given
    for (int i = 1; i <= 9; i++) {
      bowlingGame.recordGoalStatus(i, new Turn(Arrays.asList(10, 0)));
    }
    bowlingGame.recordGoalStatus(10, new Turn(Arrays.asList(10, 10, 10)));

    //when
    int finalScore=bowlingGame.calFinalScore();

    //then
    assertEquals(300, finalScore);
  }
}
