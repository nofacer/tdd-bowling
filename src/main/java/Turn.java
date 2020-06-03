import java.util.List;
import lombok.Data;

@Data
public class Turn {

  List<Integer> goalList;

  public Turn(List<Integer> goalList) {
    this.goalList = goalList;
  }
}
