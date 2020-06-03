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

  public int cal_score(int turnNumber) {
    Turn turn=turnRecord.get(turnNumber);
    return turn.getGoalList().stream().mapToInt(Integer::intValue).sum();
  }
}
