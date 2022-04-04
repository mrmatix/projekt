import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Report {
    public void removeAllReports() throws IOException {
        new FileWriter("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt", false).close();
    }

    public void removeReport() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Which one would you like to remove? ");
        int place = scan.nextInt();
        try {
            File inputFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt");
            File tempFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/reportTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            int itemToRemove = (place - 1) * 4;
            String currentLine;
            int line = -1;
            while ((currentLine = reader.readLine()) != null) {
                line++;
                if (line == itemToRemove || line == itemToRemove + 1 || line == itemToRemove + 2
                        || line == itemToRemove + 3) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            tempFile.renameTo(inputFile);
        } catch (Exception x) {
        }
    }

    public void displayReport() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // The line number with a zero
        int m = n - 1;
        try {
            String line = Files.readAllLines(Paths.get("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt"))
                    .get(m);
            System.out.println("***REPORTS***");
            System.out.println("=============");
            System.out.println(line);
            System.out.println("=============");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
