import java.util.ArrayList;
import java.util.Scanner;

//Main class
public class MainMenu {

    public static void main(String[] args) throws Exception {
        // Declaring objects
        Emergency emergency = new Emergency();
        EmergencyList emergencyList = new EmergencyList();
        EmergencyServiceList emergencyServiceList = new EmergencyServiceList();
        Report report = new Report();

        // Scanner
        Scanner scan = new Scanner(System.in);

        // Data
        ArrayList<ServiceItem> serviceItems = new ArrayList<ServiceItem>();
        ArrayList<EmergencyServiceItem> emergencyServiceItems = new ArrayList<EmergencyServiceItem>();

        // CLI
        System.out.println("*** EMERGENCY SERVICE ***");
        System.out.println();

        // Menu
        while (true) {
            System.out.println("To report a call, press 1");
            System.out.println("To display all reports, press 2");
            System.out.println("To display a specific report, press 3");
            System.out.println("To display a client, press 4");
            System.out.println("To display emergency services, press 5");
            System.out.println("To remove a specific client, press 6");
            System.out.println("To remove all clients, press 7");
            System.out.println("To remove a specific report, press 8");
            System.out.println("To remove all reports, press 9");
            System.out.println("To exit, press 10");

            System.out.println();

            System.out.print("Enter your choice: ");
            // taking a number from user
            int choice = scan.nextInt();
            switch (choice) {
                case 1: // To report a call, press 1
                    System.out.println("*** Report a call ***");
                    // Calling the emergencyCall() method from Emergency class
                    emergency.emergencyCall();
                    System.out.println();
                    System.out.println();
                    break;
                case 2: // To display all reports, press 2
                    System.out.println("*** All reports ***");
                    // Read the report and service data from EmergencyList
                    emergencyList.readReportFileAll("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt",
                            serviceItems);
                    emergencyList.displayReports(serviceItems);
                    System.out.println();
                    System.out.println();
                    break;
                case 3: // To display a specific report, press 3
                    System.out.println("*** Choose a report ***");
                    report.displayReport();
                    System.out.println();
                    System.out.println();
                    break;

                case 4: // To display a client, press 4
                    System.out.println("*** Choose a client ***");
                    Client.displayClient();
                    System.out.println();
                    System.out.println();
                    break;

                case 5: // To display emergency services, press 5
                    System.out.println("*** Emergency Services ***");
                    emergencyServiceList.displayAllServices(
                            "C:/UEL/CN5004/TERM PROJECT/Term Project/src/emergencyServices.txt", emergencyServiceItems);
                    emergencyServiceList.displayEmergencyServices(emergencyServiceItems);
                    System.out.println();
                    System.out.println();
                    break;

                case 6: // To remove a specific client, press 6
                    System.out.println("*** Removing a client ***");
                    emergencyList.readReportFileAll("C:/UEL/CN5004/TERM PROJECT/Term Project/src/clients.txt",
                            serviceItems);
                    System.out.println();
                    System.out.println();
                    // Calling a static method
                    Client.removeClient();
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("A report was deleted");
                    System.out.println();
                    System.out.println();
                    break;
                case 7: // To remove all clients, press 7
                    System.out.println("*** Removing all clients ***");
                    Client.removeAllClient();
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("All reports were deleted");
                    System.out.println();
                    System.out.println();
                    break;
                case 8: // To remove a specific report, press 8
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
                case 9: // To remove all reports, press 9
                    System.out.println("*** Removing all reports ***");
                    report.removeAllReports();
                    System.out.println();
                    System.out.println();
                    Thread.sleep(1000);
                    System.out.println("All reports were deleted");
                    System.out.println();
                    System.out.println();
                    break;
                case 10: // To exit, press 10
                    System.out.println("*** Thank you ***");
                    System.exit(0);
                    break;
                default:
                    System.out.println("*** Try again ***");
            }
        }
    }
}
