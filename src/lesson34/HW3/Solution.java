package lesson34.HW3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));

    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {

        validate(fileFromPath, fileToPath);
        writeToFileApacheIO(fileToPath, readFromFileApacheIO(fileFromPath));

    }


    private static byte[] readFromFileApacheIO(String path) throws IOException {

        File file = new File(path);
        byte[] res = FileUtils.readFileToByteArray(file);

        return res;
    }

    private static void writeToFileApacheIO(String path, byte[] contentToWrite) throws IOException {

        File file = new File(path);
        FileUtils.writeByteArrayToFile(file, contentToWrite);

    }


    private static List<String> readFromFile(String path){

        try  {
            List<String> res = Files.readAllLines(Paths.get(path));
            return res;
        } catch (IOException e) {
            System.err.println("Can't read file " + path);
        }

        return null;
    }

    private static void writeToFile(String path, List<String> contentToWrite) {

        if (contentToWrite == null)
            return;

        try {
            Files.write(Paths.get(path), contentToWrite, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            System.err.println("Can't write file " + path);
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

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFromPath + "does not have permissions to be read/written");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + "does not have permissions to be written");
        }
    }

}
