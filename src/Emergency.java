import java.io.BufferedWriter;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.util.Scanner;

public class Emergency {
    public void reportCall() {

        // Setup Scanner
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean isNumber;

        try {
            FileWriter fw = new FileWriter("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            do {
                System.out.println("Please select an emergency: ");
                System.out.println("1: Robbery");
                System.out.println("2: Homicide");
                System.out.println("3: Carjacking");
                System.out.println("4: Mugging");
                System.out.println("5: Assault");
                System.out.println("6: Arson");
                System.out.println("7: Car Accident");
                System.out.println("8: Your emergency is not on the list? Please type your emergency: ");
                if (scan.hasNextInt()) {
                    number = scan.nextInt();
                    isNumber = true;
                } else {
                    System.out.println("Try Again");
                    isNumber = false;
                    scan.next();
                }
            } while (!(isNumber));
            switch (number) {
                case 1:
                    System.out.println("You have selected: Robbery");
                    pw.write("Robbery");
                    break;
                case 2:
                    System.out.println("You have selected: Homicide");
                    pw.write("Homicide");
                    break;
                case 3:
                    System.out.println("You have selected: Carjacking");
                    pw.write("Carjacking");
                    break;
                case 4:
                    System.out.println("You have selected: Mugging");
                    pw.write("Mugging");
                    break;
                case 5:
                    System.out.println("You have selected: Assault");
                    pw.write("Assault");
                    break;
                case 6:
                    System.out.println("You have selected: Arson");
                    pw.write("Arson");
                    break;
                case 7:
                    System.out.println("You have selected: Car Accident");
                    pw.write("Car Accident");
                    break;
                case 8:
                    System.out.println("Please write your emergency: ");
                    pw.write(scan.nextLine());
            }
            bw.write(",");
            do {
                System.out.println("Please select service you need: ");
                System.out.println("Please select an emergency: ");
                System.out.println("1: Police Department");
                System.out.println("2: Fire Department");
                System.out.println("3: Emergency Department");
                System.out.println("4: Police Department and Fire Department");
                System.out.println("5: Police Department and Emergency Department");
                System.out.println("6: Emergency Department and Fire Department");
                System.out.println("7: Police Department and Fire Department and Emergency Department");
                if (scan.hasNextInt()) {
                    number = scan.nextInt();
                    isNumber = true;
                } else {
                    System.out.println("Try Again");
                    isNumber = false;
                    scan.next();
                }
            } while (!(isNumber));
            switch (number) {
                case 1:
                    System.out.println("You have selected: Police Department");
                    pw.write("PD");
                    break;
                case 2:
                    System.out.println("You have selected: Fire Department");
                    pw.write("FD");
                    break;
                case 3:
                    System.out.println("You have selected: Emergency Department");
                    pw.write("ED");
                    break;
                case 4:
                    System.out.println("You have selected: Police Department and Fire Department");
                    pw.write("PD");
                    bw.write(",");
                    pw.write("FD");
                    break;
                case 5:
                    System.out.println("You have selected: Police Department and Emergency Department");
                    pw.write("PD");
                    bw.write(",");
                    pw.write("ED");
                    break;
                case 6:
                    System.out.println("You have selected: Emergency Department and Fire Department");
                    pw.write("ED");
                    bw.write(",");
                    pw.write("FD");
                    break;
                case 7:
                    System.out.println(
                            "You have selected: Police Department and Fire Department and Emergency Department");
                    pw.write("PD");
                    bw.write(",");
                    pw.write("FD");
                    bw.write(",");
                    pw.write("ED");
                    break;
            }
            bw.newLine();
            pw.close();
            System.out.println("Successfully reported an emergency. It will be handled shotly.");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
