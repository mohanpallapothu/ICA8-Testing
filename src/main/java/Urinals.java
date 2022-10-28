import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Title:JUnit Testing
 *
 * @author Venkata Sai Mohan Kumar Pallapothu
 * @version 1.0
 */

public class Urinals {

    public static void openFile(String path) throws FileNotFoundException, EmptyFileException {
        List<String> testCases = new ArrayList<>();

        File file = new File(path);
            Scanner cases = new Scanner(file);
            while (cases.hasNextLine()) {
                String testCase = cases.nextLine();
                if(!goodString(testCase))
                    throw new NumberFormatException();
                if(testCase.equals("-1"))
                    cases.close();
                testCases.add(testCase);
                goodString(testCase);
            }
            cases.close();
         if(testCases.size() == 0){
             throw new EmptyFileException();
         }

    }
    public static Boolean goodString( String str ) {
        Set<String> req = new HashSet<>();
        req.add("0");
        req.add("1");
        if(str.length() < 1 || str.length() > 20)
            return false;

        for(int i = 0 ; i < str.length()-1; i++)
        {
            if(str.charAt(i) == '1' && str.charAt(i+1) =='1')
            {
                System.out.println("returning false loop1");
                return false;
            }
        }

        for(int i = 0 ; i < str.length(); i++)
        {
            if(!req.contains(Character.toString(str.charAt(i))))
                return false;
        }
        return true;
    }

}
