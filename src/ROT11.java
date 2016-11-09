/**
 * Created by Marcel on 03.11.2016.
 */
public class ROT11 implements Algorithm {

    static final int code = 11;

    public String crypt(String word) {
        String s = word;
        String tmpWord = new String();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')  {
                c += code;
                if (c > 'z'){
                    int tmpCode = c - 'z' - 1;
                    c = 'a';
                    c += tmpCode;
                }
            }
            tmpWord += c;
        }
        return tmpWord;
    }

    public String decrypt(String word) {
        String s = word;
        String tmpString = new String();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c -= code;
                if (c < 'a'){
                    int tmpCode = 'a' - c -1;
                    c = 'z';
                    c -= tmpCode;
                }
            }
            tmpString += c;
        }
        return tmpString;
    }
}
