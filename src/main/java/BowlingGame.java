import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BowlingGame {

  private Map<Integer, Turn> turnRecord;

  public BowlingGame() {
    this.turnRecord = new HashMap<>();
  }

  public void recordGoalStatus(int turnNumber, Turn turn) {
    this.turnRecord.put(turnNumber, turn);
  }

  public int calScore(int turnNumber) {
    Turn turn = turnRecord.get(turnNumber);
    int temporaryScore = sumList(turn.getGoalList());
    if ((temporaryScore) == 10) {
      return temporaryScore + calSpareBonusScore(turnNumber);
    }
    return temporaryScore;
  }

  private int calSpareBonusScore(int turnNumber) {
    return this.turnRecord.get(turnNumber + 1).getGoalList().get(0);
  }


  private int sumList(List<Integer> lyst) {
    return lyst.stream().mapToInt(Integer::intValue).sum();
  }
}
