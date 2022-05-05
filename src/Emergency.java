import java.io.BufferedWriter; // Import the BufferedWriter class
import java.io.File;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter; // Import the PrintWriter class
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class

public class Emergency {

    public void emergencyCall() {

        callerCredentials();
        String selectedValue = emergencySelectedValue();
        // printSelectedValue(selectedValue)
        List<String> selectedEmergencyServices = emergencyServiceSelectedValue();

        try {
            saveCallToFile(selectedValue, selectedEmergencyServices);
        } catch (Exception e) {
            System.out.println("NO UNITS AVAILABLE");
        }
    }

    private void saveCallToFile(String emergency, List<String> emergencyServices) {
        // Simple try-catch
        try {
            FileWriter fw = new FileWriter("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.write(emergency);
            pw.write("/");
            emergencyServices.stream().forEach(service -> pw.write(service + ","));
            bw.newLine(); // Always start on a new line
            pw.close(); // Closing the file after we're done

        } catch (IOException e) { // Catch exception
            System.out.println("An error occurred");
            e.printStackTrace(); // Prints this throwable and its backtrace to the standard error stream
        }
    }

    private String emergencySelectedValue() {
        // Setup Scanner
        Scanner scan = new Scanner(System.in);
        // Initializing the number used for input
        int number = 0;
        // true/false value that checks if user put in a number
        boolean isNumber;
        // Do-while to keep the loop going
        do {
            System.out.println("Please select an emergency: ");
            System.out.println("1: Robbery");
            System.out.println("2: Homicide");
            System.out.println("3: Carjacking");
            System.out.println("4: Mugging");
            System.out.println("5: Assault");
            System.out.println("6: Arson");
            System.out.println("7: Car Accident");
            System.out.println("8: Your emergency i s not on the list? Please type your emergency: ");
            System.out.print("Enter your choice: ");
            // If user inputs something a number then we go on and if not then we try again
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                isNumber = true;
            } else {
                System.out.println("Try Again");
                isNumber = false;
                scan.next();
            }
        } while (!(isNumber && number >= 1 && number <= 8)); // Loop

        if (number == 8) {
            return scan.nextLine(); // Custom message
        }
        return mapSelectedKeyToEmergency(number);

    }

    private void callerCredentials() {
        Scanner scan = new Scanner(System.in);
        String fullName;
        String address;

        try {
            FileWriter fw = new FileWriter("C:/UEL/CN5004/TERM PROJECT/Term Project/src/clients.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            System.out.println("Please state your full name: ");
            fullName = scan.nextLine();
            pw.write(fullName);
            bw.write("/");
            System.out.println("Please state your full address: ");
            address = scan.nextLine();
            pw.write(address);
            bw.newLine(); // Always start on a new line
            pw.close(); // Closing the file after we're done

        } catch (IOException e) { // Catch exception
            System.out.println("An error occurred");
            e.printStackTrace(); // Prints this throwable and its backtrace to the standard error stream
        }
    }

    private List<String> emergencyServiceSelectedValue() {
        // Setup Scanner
        Scanner scan = new Scanner(System.in);
        // Initializing the number used for input
        int number = 0;
        // true/false value that checks if user put in a number
        boolean isNumber;

        do { // Same but for emergency services
            System.out.println("Please select service you need: ");
            System.out.println("Please select an emergency: ");
            System.out.println("1: Police Department");
            System.out.println("2: Fire Department");
            System.out.println("3: Emergency Department");
            System.out.println("4: Police Department and Fire Department");
            System.out.println("5: Police Department and Emergency Department");
            System.out.println("6: Emergency Department and Fire Department");
            System.out.println("7: Police Department and Fire Department and Emergency Department");
            System.out.print("Enter your choice: ");
            if (scan.hasNextInt()) {
                number = scan.nextInt();
                isNumber = true;
            } else {
                System.out.println("Try Again");
                isNumber = false;
                scan.next();
            }
        } while (!(isNumber));

        return mapSelectedKeyToEmergencyServiceCode(number);
    }

    private List<String> mapSelectedKeyToEmergencyServiceCode(int keyNumber) {
        List<String> emergencyServiceCodes = new ArrayList<>();

        switch (keyNumber) {
            case 1:
                emergencyServiceCodes.add("PD");
                break;
            case 2:
                emergencyServiceCodes.add("FD");
                break;
            case 3:
                emergencyServiceCodes.add("ED");
                break;
            case 4:
                emergencyServiceCodes.add("PD");
                emergencyServiceCodes.add("FD");
                break;
            case 5:
                emergencyServiceCodes.add("PD");
                emergencyServiceCodes.add("ED");
                break;
            case 6:
                emergencyServiceCodes.add("ED");
                emergencyServiceCodes.add("FD");
                break;
            case 7:
                emergencyServiceCodes.add("PD");
                emergencyServiceCodes.add("FD");
                emergencyServiceCodes.add("ED");
                break;
        }
        return emergencyServiceCodes;

    }

    private String mapSelectedKeyToEmergency(int keyNumber) {
        switch (keyNumber) {
            case 1:
                return "Robbery";
            case 2:
                return "Homicide";
            case 3:
                return "Carjacking";
            case 4:
                return "Mugging";
            case 5:
                return "Assault";
            case 6:
                return "Arson";
            case 7:
                return "Car Accident";
        }
        return null;
    }
}
