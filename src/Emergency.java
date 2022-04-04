import java.io.BufferedWriter;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.util.Scanner;

public class Emergency {
    public void reportCall() {
        Scanner scan = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            System.out.println(
                    "Please report the emergency followed by a comma and the emergency service eg: Robbery,PD");
            pw.write(scan.nextLine());
            bw.newLine();
            pw.close();
            System.out.println("Successfully reported an emergency. It will be handled shotly.");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
}
