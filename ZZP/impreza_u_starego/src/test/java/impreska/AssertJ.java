package impreska;

import org.junit.jupiter.api.Test;


//import static org.assertj.core.api.Assertions.assertThat;
import static impreska.CustomAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertJ {

   /* @Test
    void assertJEquals(){
        assertThat("x").isEqualTo("x");
    }*/

    @Test
    void basicEquals(){
        assertEquals("x", "x");
    }

    @Test
    void assertCustomTest(){
        assertThat("xxxxxxxxxxxxxxxxxx").hasLength("xxxxxxxxxxxxxxxxxx");
    }
}
