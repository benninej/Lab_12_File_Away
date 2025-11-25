import java.util.Scanner;

public class SafeInput
{
    /**
     * a method that prompts for and returns with at leats one character
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @return a nonempty String
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // init return string

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.isEmpty())
            {

                System.out.println("You must enter at least one character");
            }

        } while (retString.isEmpty());
        return retString;
    }


    /**
     * a method that prompts for and returns an integer value
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @return an integer value
     */

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer: " + trash);
            }

        } while (!done);

        return retInt;
    }


    /**
     * a method that prompts for and returns a double value
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @return a double value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double: " + trash);
            }

        } while (!done);

        return retVal;
    }

    /**
     * a method that prompts for and returns an integer value within a specified range
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @param low the minimum acceptable value
     * @param high the maximum acceptable value
     * @return an integer value within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                done = true;

                if (retInt < low || retInt > high)
                {
                    System.out.println("You must enter an integer between " + low + " and " + high);
                    done = false;
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer between " + low + " and " + high + "not: " + trash);
            }

        } while (!done);

        return retInt;
    }

    /**
     * a method that prompts for and returns a double value within a specified range
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @param low the minimum acceptable value
     * @param high the maximum acceptable value
     * @return a double value within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, int low, int high)
    {
        double retVal = 0.0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                done = true;

                if (retVal < low || retVal > high)
                {
                    System.out.println("You must enter a double between " + low + " and " + high);
                    done = false;
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double between " + low + " and " + high + "not: " + trash);
            }

        } while (!done);

        return retVal;
    }

    /**
     * a method that prompts for and returns a yes/no response and returns equivalent true/false
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @return true for yes and false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean retVal = false;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();

            if (response.equals("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (response.equals("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N, not: " + response);
            }

        } while (!done);

        return retVal;
    }

    /**
     * a method that prompts for and returns a string that matches a regular expression
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @param regEx the regular expression pattern the input must match
     * @return a string that matches the specified regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[ " + regEx + "]: ");
            retVal = pipe.nextLine();

            if (!retVal.matches(regEx))
            {
                System.out.println("You must enter a string that matches the pattern: " + regEx);
            }

        } while (!retVal.matches(regEx));

        return retVal;
    }

    /**
     * a method that displays a pretty header around a message
     * @param msg the message to display
     * @return the total width of the header
     */
    public static int prettyHeader(String msg)
    {
        int totalWidth = 60;
        int starCount = 3;

        // top border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

        int msgLength = msg.length();
        int totalPadding = totalWidth - (2 * starCount) - msgLength;
        int paddingLeft = totalPadding / 2;
        int paddingRight = totalPadding - paddingLeft;

        // middle line with message
        for (int i = 0; i < starCount; i++) {
            System.out.print("*");
        }
        for (int i = 0; i < paddingLeft; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingRight; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < starCount; i++) {
            System.out.print("*");
        }
        System.out.println();
        // bottom border
        for (int i = 0; i < totalWidth; i++) {
            System.out.print("*");
        }
        return totalWidth;
    }

}
