import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public static void main(String[] args)
{
    JFileChooser fileChooser = new JFileChooser();
    File selectedFile;
    String rec = "";

    int lineCount = 0;
    int wordCount = 0;
    int charCount = 0;

    try
    {
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();
            Path filePath = selectedFile.toPath();

            BufferedReader reader = Files.newBufferedReader(filePath);


            while (reader.ready()) {
                rec = reader.readLine();
                lineCount++;
                System.out.printf("\nLine %4d %-60s ", lineCount, rec);

                String[] words = rec.trim().split("\\s+");
                wordCount += words.length;
                charCount += rec.length();

            }
            reader.close();
            System.out.println("\n\nFile Analysis:");
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Characters: " + charCount);


        }
        else  // User closed the chooser without selecting a file
        {
            System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
        }
    }
    catch (FileNotFoundException e)
    {
        System.out.println("File not found!!!");
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }

}