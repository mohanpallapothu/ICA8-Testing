import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Title:JUnit Testing
 *
 * @author Venkata Sai Mohan Kumar Pallapothu
 * @version 1.0
 */

public class Urinals {

    public Urinals() throws IOException {
    }

    public static Boolean openFile(String path) throws IOException, EmptyFileException {
        List<String> testCases = new ArrayList<>();

        File file = new File(path);
        Scanner cases = new Scanner(file);
        while (cases.hasNextLine()) {
            String testCase = cases.nextLine();
            if (!numberTest(testCase))
                throw new NumberFormatException();
            if (testCase.equals("-1"))
                break;
            testCases.add(testCase);
        }
        cases.close();

        if (testCases.size() == 0) {
            throw new EmptyFileException();
        }

        return enterDetails(testCases);

    }

    public static Boolean goodString(String str) {

        if (str.length() < 1 || str.length() > 20)
            return false;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '1' && str.charAt(i + 1) == '1')
                return false;
        }

//        if (!numberTest(str))
//            return false;
        return true;
    }

    public static Boolean numberTest(String str) {
        Set<String> req = new HashSet<>();
        req.add("0");
        req.add("1");

        for (int i = 0; i < str.length(); i++) {
            if (!req.contains(Character.toString(str.charAt(i))))
                return false;
        }
        return true;
    }

    public static Boolean enterDetails(List<String> testCases) throws IOException {
        List<Integer> output = new ArrayList<>();
        for (String testCase : testCases) {
            int val = countUrinals(testCase);
            output.add(val);
        }
        return writeFile(output);
    }

    public static int countUrinals(String testCase) {

        if (!goodString(testCase)) return -1;
        if (testCase.equals("0")) return 1;
        if (testCase.equals("1")) return 0;

        char[] characters = testCase.toCharArray();
        int final_count = 0;

        for (int i = 0; i < characters.length - 1; i++) {
            if (i == 0) {
                if (characters[i] == '0' && characters[i + 1] == '0') {
                    characters[i] = '1';
                    final_count++;
                }
            }
            if (i > 0) {
                if (characters[i] == '0' && characters[i - 1] == '0' && characters[i + 1] == '0') {
                    characters[i] = '1';
                    final_count++;
                }
            }
        }
        if (characters[characters.length - 1] == '0' && characters[characters.length - 2] == '0') {
            final_count++;
        }
        return final_count;

    }

    public static Boolean writeFile(List<Integer> values) throws IOException {

        String outName = "rule.txt";


            FileWriter file = new FileWriter(outName);
            for (Integer x : values) {
                file.write(x.toString() + "\n");
            }
            file.close();
            return true;
    }

}
