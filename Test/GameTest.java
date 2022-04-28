package Test;

import BG.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    Game testFrame;

    @Before
    public void setUp(){
        testFrame = new Game();
    }

    @Test
    public void game_initializationvalues(){
        assertEquals(2, testFrame.getRemainingTry());
        assertEquals(0, testFrame.getKnockedPins());
        assertEquals(false, testFrame.getIsStrike());
        assertEquals(false, testFrame.getIsSpare());
        assertEquals(0, testFrame.getFrameScore());
    }

    @Test
    public void game_rollConsistencyOfKnockedAndRemainingPins(){
        testFrame.roll();
        assertEquals(10,testFrame.getRemainingPins() + testFrame.getKnockedPins());
    }

    @Test
    public void game_rollDoesNotOccurForFrameAfterStrike(){
        testFrame.roll();
        int beforeStrikeKnockedPins = testFrame.getKnockedPins();
        int beforeStrikeRemainingPins = testFrame.getRemainingPins();
        testFrame.setIsStrike(true);
        testFrame.roll();
        assertEquals(true,(beforeStrikeRemainingPins == testFrame.getRemainingPins()) && (beforeStrikeKnockedPins == testFrame.getKnockedPins()));
    }

    @Test
    public void game_rollOccursForFrameAfterSpare(){
        testFrame.roll();
        int beforeStrikeKnockedPins = testFrame.getKnockedPins();
        int beforeStrikeRemainingPins = testFrame.getRemainingPins();
        testFrame.setIsSpare(true);
        testFrame.roll();
        assertEquals(false,(beforeStrikeRemainingPins == testFrame.getRemainingPins()) && (beforeStrikeKnockedPins == testFrame.getKnockedPins()));
    }

    @Test
    public void game_CheckStrikeAndSpareCannotOccurAtTheSameTime(){
        testFrame.setKnockedPins(10);
        testFrame.setRemainingTry(1);
        testFrame.strikeSpareCheck();

        assertEquals(true,testFrame.getIsStrike());
        assertEquals(false, testFrame.getIsSpare());
    }

    @Test
    public void game_CheckSpareAndStrikeCannotOccurAtTheSameTime(){
        testFrame.setKnockedPins(10);
        testFrame.setRemainingTry(0);
        testFrame.strikeSpareCheck();

        assertEquals(true, testFrame.getIsSpare());
        assertEquals(false,testFrame.getIsStrike());
    }
}
