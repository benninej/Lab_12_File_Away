import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver
{
    public static void main(String[] args)
    {
        ArrayList<String> recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String rec = "";

        int idCounter = 1;
        boolean done = false;
       do
       {
           String firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
           String lastName = SafeInput.getNonZeroLenString(in, "Enter last name");
           String ID = String.format("%06d", idCounter);
           idCounter++;
           String email = SafeInput.getNonZeroLenString(in, "Enter email");
           int yob = SafeInput.getInt(in, "Enter year of birth");
           rec = ID + "," + lastName + "," + firstName + "," + email + "," + yob;
           recs.add(rec);

           String confirm = SafeInput.getNonZeroLenString(in, "Are you done? (Y/N)");
           if(confirm.equalsIgnoreCase("Y"))
           {
               done = true;
           }
           else
           {
                done = false;
           }

       }while (!done);


        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name (with .csv extension)");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
            for (String r : recs) {
                writer.write(r);
                writer.newLine();
            }
            // writer.close(); <-- remove, try-with-resources closes automatically
            System.out.println("Data file written to " + file.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
