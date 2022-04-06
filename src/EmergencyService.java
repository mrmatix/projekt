import java.io.BufferedWriter; // Import the BufferedWriter class
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors
import java.io.PrintWriter; // Import the PrintWriter class
import java.util.Scanner; // Import the Scanner class

public class EmergencyService {
    // dodawanie i odejmowanie dostepnych jednostek
    // 1. odczytac plik
    // 2. znalezc linijke
    // 3. split i convert na int
    // 4. zdekrementowac liczbe po przecinku (usunac i wpisac nowa -1)
    // 5. powrot na string

    public static void removeUnit(String emergencyService) {

        int place = 
        String currentLine;
        int count = 0;
        try {
            File inputFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/emergencyServices.txt");
            File tempFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/reportTemp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            int lineToReplace = place;

            //...
            if (foundFileLine.substring()  == emergencyService) (czyli jeśli począek linii jest "PD") {
                // dekrementuj:
                String unitNumString = foundFileLine.substring();
                Integer unitNum = Integer.valueOf(unitNumString);
                iloscJednoste--; // TODO co jeśli zero? wyjątek? przechwycić? throw Exception
                zapisz do pliku iloscJednostek (iloscJednostek.toStrgin())

            }

            int place = scan.nextInt();
            String currentLine;
            int count = 0;
            try {
                File inputFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt");
                File tempFile = new File("C:/UEL/CN5004/TERM PROJECT/Term Project/src/reportTemp.txt");
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                int lineToRemove = place;
                // Going through the file line by line to remove the n-th line input by a user
                while ((currentLine = reader.readLine()) != null) {
                    count++;
                    if (count == lineToRemove) {
                        continue;
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                inputFile.delete();
                tempFile.renameTo(inputFile);
            } catch (Exception x) {
            }

        }
        }
}
