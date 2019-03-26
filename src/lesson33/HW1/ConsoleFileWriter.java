package lesson33.HW1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ConsoleFileWriter {
    public static void writeToFileFromConsole(String path) {

        File file = new File(path);
        if (!file.exists()) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        StringBuilder text = new StringBuilder();
        System.out.println("Enter file content to write in the file:");

        try {

            while (true) {

                String input = br.readLine();

                if (input.equals("wr")) {
                    try {
                        writer = new FileWriter(path, true);
                        bufferedWriter = new BufferedWriter(writer);

                        bufferedWriter.append(text);
                    } catch (IOException e) {
                        System.err.println("Can't write to file with path " + path);
                    } finally {
                        IOUtils.closeQuietly(bufferedWriter);
                        IOUtils.closeQuietly(writer);
                        break;
                    }
                }

                text.append(input);
                text.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            System.err.println("Can't read from keyboard");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}
