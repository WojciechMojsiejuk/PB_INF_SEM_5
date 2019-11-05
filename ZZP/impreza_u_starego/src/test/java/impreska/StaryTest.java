package impreska;

import org.junit.jupiter.api.*;

public class StaryTest {

    @BeforeEach
    public void before_stary(){
        System.out.println("No siema");
    }

    @BeforeAll
    public static void before_impreska(){
        System.out.println("Witanko");
    }

    @AfterAll
    public static void after_impreka(){
        System.out.println("Papuszki");
    }

    @AfterEach
    public void after_stary(){
        System.out.println("Narazicho");
    }

    @Test
    @Tag ("staruch")
    public void stary1(){
        int a = 5;
        Assertions.assertEquals(5, a);
    }

    @Test
    @Tag ("staruch")
    public void stary2(){
        int a = 3;
        Assertions.assertTrue(3 - 2 == 0);
    }

    @Test
    public void exceptionTest() {
        String b = null;
        Assertions.assertThrows(NullPointerException.class, () -> b.toUpperCase());
    }
}
