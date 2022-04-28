package Test;

import BG.BowlingGame;
import BG.Game;
import model.FrameSummary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {
    Game testFrame;
    FrameSummary testFrameSummary;
    BowlingGame testBowlingGame;

   @Before
    public void setUp(){
       testFrame = new Game();
       testBowlingGame = new BowlingGame();
   }

   @Test
   public void bowlingGame_calulateTotalScoreWithoutStrikeOrSpare(){
       testFrame.setIsStrike(false);
       testFrame.setIsSpare(false);
       testFrame.setFrameScore(4);
       testFrameSummary = new FrameSummary(testFrame);
       testBowlingGame.updateFrameHistory(testFrameSummary);

       testFrame.setIsStrike(false);
       testFrame.setIsSpare(false);
       testFrame.setFrameScore(5);
       testFrameSummary = new FrameSummary(testFrame);
       testBowlingGame.updateFrameHistory(testFrameSummary);

       testFrame.setIsStrike(false);
       testFrame.setIsSpare(false);
       testFrame.setFrameScore(8);
       testFrameSummary = new FrameSummary(testFrame);
       testBowlingGame.updateFrameHistory(testFrameSummary);

       testFrame.setIsStrike(false);
       testFrame.setIsSpare(false);
       testFrame.setFrameScore(3);
       testFrameSummary = new FrameSummary(testFrame);
       testBowlingGame.updateFrameHistory(testFrameSummary);

       testBowlingGame.setFrameCount(4);
       testBowlingGame.calculateTotalScore();
       assertEquals(20, testBowlingGame.getTotalScore());
   }
}
