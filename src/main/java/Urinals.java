import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Title:JUnit Testing
 *
 * @author Venkata Sai Mohan Kumar Pallapothu
 * @version 1.0
 */

public class Urinals {

    public static void openFile(String path) throws FileNotFoundException {

            File file = new File(path);
            Scanner testCases = new Scanner(file);
            while (testCases.hasNextLine()) {
                String testCase = testCases.nextLine();
                if(testCase.equals("-1"))
                    testCases.close();
                goodString(testCase);
            }
            testCases.close();

    }
    public static Boolean goodString( String str ) {

        if(str.length() < 1)
            return false;

        for(int i = 0 ; i < str.length()-1; i++)
        {
            if(str.charAt(i) == '1' && str.charAt(i+1) =='1')
                return false;
        }

        for(int i = 0 ; i < str.length(); i++)
        {
            if(str.charAt(i) != '1'|| str.charAt(i) != '0')
                return true;
        }
        return false;
    }

}
