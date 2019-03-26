package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException{

        readFile("C:/Users/dymyc/Desktop/test.txt");

        writeFile("C:/Users/dymyc/Desktop/test1.txt");
    }

    private static void readFile(String path) {

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

    }
    private static void writeFile(String path) throws InterruptedException {

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            //TODO use other constructor
            Thread.sleep(6000);

            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.newLine();
            bufferedWriter.append("TTTTT");
        } catch (IOException e) {
            System.err.println("Can't write file ");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }

    }
}
