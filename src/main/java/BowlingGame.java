import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BowlingGame {

  private final Map<Integer, Turn> turnRecord;

  public BowlingGame() {
    this.turnRecord = new HashMap<>();
  }

  public void recordGoalStatus(int turnNumber, Turn turn) {
    this.turnRecord.put(turnNumber, turn);
  }

  public int calScore(int turnNumber) {
    Turn turn = turnRecord.get(turnNumber);
    int temporaryScore = sumList(turn.getGoalList());

    if (turnNumber != 10) {
      if ((temporaryScore) == 10 && turn.getGoalList().get(0) != 10) {
        return temporaryScore + calSpareBonusScore(turnNumber);
      }
      if (turn.getGoalList().get(0) == 10) {
        return temporaryScore + calStrikeBonusScore(turnNumber);
      }
    }
    return temporaryScore;
  }

  public int calFinalScore() {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      sum += calScore(i);
    }
    return sum;
  }

  private int calSpareBonusScore(int turnNumber) {
    return this.turnRecord.get(turnNumber + 1).getGoalList().get(0);
  }

  private int calStrikeBonusScore(int turnNumber) {
    List<Integer> bonusGoalList = new ArrayList<>();
    int tempTurnNumber = turnNumber + 1;
    while (bonusGoalList.size() < 2) {
      List<Integer> goalList = this.turnRecord.get(tempTurnNumber).getGoalList();
      for (int goal : goalList) {
        if (goal != 0) {
          bonusGoalList.add(goal);
          if (bonusGoalList.size() >= 2) {
            break;
          }
        }
      }
      tempTurnNumber++;
    }
    return sumList(bonusGoalList);
  }

  private int sumList(List<Integer> lyst) {
    return lyst.stream().mapToInt(Integer::intValue).sum();
  }
}
