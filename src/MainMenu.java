import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) throws Exception {
        Emergency emergency = new Emergency();
        EmergencyList emergencyList = new EmergencyList();
        EmergencyServiceList emergencyServiceList = new EmergencyServiceList();
        Report report = new Report();

        Scanner scan = new Scanner(System.in);

        // Data
        ArrayList<ServiceItem> serviceItems = new ArrayList<ServiceItem>();
        ArrayList<EmergencyServiceItem> emergencyServiceItems = new ArrayList<EmergencyServiceItem>();

        System.out.println("*** EMERGENCY SERVICE ***");
        System.out.println();

        // Menu
        while (true) {
            System.out.println("To repord a call, press 1"); // works
            System.out.println("To display all reports, press 2");// works
            System.out.println("To display a specific report, press 3"); // working
            System.out.println("To display all available services, press 4");// TODO // works, need to add
                                                                             // decrementing amount of services
            System.out.println("To remove a specific report, press 5");// TODO //not working
            System.out.println("To remove all reports, press 6"); // works
            System.out.println("To exit, press 7"); // works

            System.out.println();

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("*** Report a call ***");
                    emergency.reportCall();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("*** All reports ***");
                    // Read the report and service data from EmergencyList
                    emergencyList.readReportFileAll("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt",
                            serviceItems);
                    emergencyList.displayReports(serviceItems);
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("*** Choose a report ***");
                    report.displayReport();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("*** All available services ***");
                    emergencyServiceList.displayAllServices(
                            "C:/UEL/CN5004/TERM PROJECT/Term Project/src/emergencyServices.txt",
                            emergencyServiceItems);
                    emergencyServiceList.displayEmergencyServices(emergencyServiceItems);
                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("*** Removing a report ***");
                    emergencyList.readReportFileAll("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt",
                            serviceItems);
                    System.out.println();
                    System.out.println();
                    report.removeReport();
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("A report was deleted");
                    System.out.println();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("*** Removing all reports ***");
                    report.removeAllReports();
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("All reports were deleted");
                    System.out.println();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("*** Thank you ***");
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** Try again ***");
            }
        }
    }
}
