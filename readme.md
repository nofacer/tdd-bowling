## 术语消歧
* score: 得分
* one game: 一场游戏。
* one turn: 一轮。一场游戏有10轮。
* throw: 扔。 每次扔球称为一扔。

## First Nine turns
* Given one turn is not 10th turn and not all bowls are struck down in this turn, 
  when calculate the score of this turn, 
  then the score should be equal to the total number that bowls are struck down in this turn.
* Given one turn is not 10th turn and is SPARE turn, 
  when calculate the score of this turn, 
  then the score should be equal to the total number that bowls are struck down in this turn plus how many bowls are struck down in the next one throw during following turns.
* Given one turn is not 10th turn and is STRIKE turn, 
  when calculate the score of this turn, 
  then the score should be equal to the total number that bowls are struck down in this turn plus how many bowls are struck down in the next two throws during following turns.

## 10th turn
* Given one turn is 10th turn,
  when calculate the score of this turn,
  then the score should be equal to the total number that bowls are struck down in this turn.

## Whole Game
* Given every throw in the game strikes down all bowls,
  when calculate the score of this game,
  then the score should be 300.
