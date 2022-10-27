import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void goodStringTestCase1() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST ONE EXECUTED =======");
        Assertions.assertEquals(true,Urinals.goodString("10"));
    }

    @Test
    void goodStringTestCase2() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST ONE EXECUTED =======");
        Assertions.assertEquals(false,Urinals.goodString(""));
    }
}