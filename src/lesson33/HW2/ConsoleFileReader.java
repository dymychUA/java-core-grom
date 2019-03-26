package lesson33.HW2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ConsoleFileReader {

    public static void readFileFromConsole() {

        System.out.println("Please, enter file path to read:");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        try {
            String path = br.readLine();
            readFile(path);
        } catch (IOException e) {
            System.err.println("Can't read from keyboard");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

    }

    private static void readFile(String path) {

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

    }

}
