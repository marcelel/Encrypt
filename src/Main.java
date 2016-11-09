import java.util.Scanner;

/**
 * Created by Marcel on 08.11.2016.
 */
public class Main {
    public static void main(String[] args){

        Algorithm algorithm;
        Scanner in = new Scanner(System.in);

        System.out.println("1. Encrypt\n2. Decrypt");
        int actionType = in.nextInt();
        System.out.println("1. ROT11\n2. Polibiusz");
        int algorithmType = in.nextInt();

        switch (algorithmType){
            case 1: algorithm = new ROT11();
                    break;
            case 2: algorithm = new Polibiusz();
                    break;
            default: return;
        }

        switch (actionType){
            case 1: Cryptographer.cryptfile(args[0], args[1], algorithm);
                    break;
            case 2: Cryptographer.decryptfile(args[0], args[1], algorithm);
                    break;
            default: return;
        }
    }
}
