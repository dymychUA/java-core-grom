package lesson34.HW2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {

        validate(fileFromPath, fileToPath);

        StringBuffer fileContent = readFromFile(fileFromPath);

        ArrayList<String> allSentences = new ArrayList<>(Arrays.asList(fileContent.toString().split("\\.")));

        ArrayList<String> foundedSentences = foundSentencesWithWord(allSentences, word);
        String newText = String.join(".", foundedSentences);
        writeToFile(fileToPath, newText, true);

        //variant 1:
        allSentences.removeAll(foundedSentences);
        writeToFile(fileFromPath, String.join(".", allSentences), false);

        //variant 2:
        //String text = fileContent.toString();
        //for (String sentence : foundedSentences) {
        //    text.replace(sentence, "");
        //}
        //writeToFile(fileFromPath, text, false);

    }

    private static ArrayList<String> foundSentencesWithWord(ArrayList<String> allSentences, String word) {
        ArrayList<String> list = new ArrayList<>();
        for (String sentence : allSentences) {
            if (sentence.length() > 10 && sentence.contains(word)) {
                list.add(sentence);
            }
        }
        return list;
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

    private static void writeToFile(String path, String contentToWrite, boolean appendText) {
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
