import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void goodStringTestCase1() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST ONE EXECUTED =======");
        Assertions.assertEquals(true,Urinals.goodString("10"));
    }

    @Test
    void goodStringTestCase2() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST TWO EXECUTED =======");
        Assertions.assertEquals(false,Urinals.goodString(""));
    }

    @Test
    void goodStringTestCase3() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST THREE EXECUTED =======");
        Assertions.assertEquals(false,Urinals.goodString("01011"));
    }

    @Test
    void goodStringTestCase4() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST FOUR (FILE NOT FOUND) EXECUTED =======");
        Assertions.assertThrows(FileNotFoundException.class, () -> Urinals.openFile("Testing_Empty_Path"));
    }

    @Test
    void goodStringTestCase5() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST FIVE EXECUTED =======");
        Assertions.assertThrows(NumberFormatException.class, () -> Urinals.openFile("ICA8-Testing-File.dat"));
    }

    @Test
    void goodStringTestCase6() {
        System.out.println("====== Venkata Sai Mohan Kumar Pallapothu == TEST SIX EXECUTED =======");
        Assertions.assertThrows(EmptyFileException.class, () -> Urinals.openFile("EmptyFile.dat"));
    }
}