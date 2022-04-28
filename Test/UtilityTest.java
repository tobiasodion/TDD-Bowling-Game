package Test;

import BG.Utility;
import org.junit.Test;
import static org.junit.Assert.*;

import static BG.Utility.*;

public class UtilityTest {
    @Test
    public void utility_randomNumberRange(){
        for (int i=0; i<1000; i++){
            int testRandomNumber = Utility.getRandomNumber(1,10);
            boolean test = (testRandomNumber>=1 && testRandomNumber <= 10);
            assertEquals(true, test);
        }
    }
}
