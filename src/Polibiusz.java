/**
 * Created by Marcel on 08.11.2016.
 */
public class Polibiusz implements Algorithm {

    private final char hugeLetter[][] = {{'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}};

    private final char letter[][] = {{'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}};

    public String crypt(String word) {
        String tmpWord = new String();
        for (int z = 0; z < word.length(); z++) {
            char c = word.charAt(z);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (c == 'J' || c == 'j') {
                        c = 'i';
                    }
                    if (c == letter[i][j] || c == hugeLetter[i][j]) {
                        tmpWord += i + 1;
                        tmpWord += j + 1;
                    }
                }
            }
        }
        return tmpWord;
    }

    public String decrypt(String word) {
        String tmpWord = new String();
        try {
            for (int i = 0; i < word.length(); i += 2) {
                //if (word.charAt(i) == ' ') {continue;}
                int a = Character.getNumericValue(word.charAt(i));
                int b = Character.getNumericValue(word.charAt(i+1));
                tmpWord += letter[a-1][b-1];
            }
            return tmpWord;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input file");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid number in file");
        }
        return tmpWord;
    }
}


