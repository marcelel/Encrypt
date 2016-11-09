/**
 * Created by Marcel on 03.11.2016.
 */

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cryptographer {

    public static void cryptfile (String fileToEncrypt, String fileToSave, Algorithm algorithm) {
        BufferedReader reader = openFile(fileToEncrypt);
        String line = null;
        try {
            String filename = fileToSave + ".txt";
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            while ((line = reader.readLine()) != null) {
                writer.print(algorithm.crypt(line));
            }
            writer.close();
        } catch (java.io.FileNotFoundException e){
            System.out.println("Problem with saving a file");
        } catch (java.io.UnsupportedEncodingException e){
            System.out.println("Unsupported Encoding");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptfile (String fileToDecrypt, String fileToSave, Algorithm algorithm){
        BufferedReader reader = openFile(fileToDecrypt);
        String line = null;
        try {
            String filename = fileToSave + ".txt";
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            while ((line = reader.readLine()) != null) {
                writer.print(algorithm.decrypt(line));
            }
            writer.close();
        } catch (java.io.FileNotFoundException e){
            System.out.println("Problem with saving a file");
        } catch (java.io.UnsupportedEncodingException e){
            System.out.println("Unsupported Encoding");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static BufferedReader openFile(String fileToOpen){
        try {
            Path file = Paths.get(fileToOpen);
            InputStream in = Files.newInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return reader;
        } catch (IOException x) {
            System.err.println(x);
        }
        return null;
    }
}
