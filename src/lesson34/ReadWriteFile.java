package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException{

        readFile("C:/Users/dymyc/Desktop/test.txt");

        writeFile("C:/Users/dymyc/Desktop/test1.txt");
    }

    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }
    }

    private static void writeFile(String path) throws InterruptedException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.newLine();
            bufferedWriter.append("TTTTT");
        } catch (IOException e) {
            System.err.println("Can't write file ");
        }
    }
}
