/**
 * Title:JUnit Testing
 *
 * @author Venkata Sai Mohan Kumar Pallapothu
 * @version 1.0
 */

public class Urinals {

    public static Boolean goodString( String str ) {  // checks to see if valid string
        for(int i = 0 ; i < str.length(); i++)
        {
            if(str.charAt(i) != '1'|| str.charAt(i) != '0')
                return true;
        }
        return false;
    }

}
