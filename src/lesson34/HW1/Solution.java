package lesson34.HW1;

import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath), true);
        writeToFile(fileFromPath, new StringBuffer(), false);
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite, boolean appendText) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, appendText))) {
            if (appendText) {
                bufferedWriter.newLine();
            }
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write file ");
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + "does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + "does not exist");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFromPath + "does not have permissions to be read/written");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + "does not have permissions to be written");
        }
    }

}
