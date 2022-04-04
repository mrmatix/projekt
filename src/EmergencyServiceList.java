import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class EmergencyServiceItem {
    private String serviceName;
    private String serviceCount;

    EmergencyServiceItem(String serviceName, String serviceCount) {
        this.serviceName = serviceName;
        this.serviceCount = serviceCount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceCount() {
        return serviceCount;
    }
}

public class EmergencyServiceList {
    public void displayAllServices(String fileName, ArrayList<EmergencyServiceItem> data) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Robbery,PD
                String tokens[] = line.split(",");
                String serviceName = tokens[0];
                String serviceCount = tokens[1];
                data.add(new EmergencyServiceItem(serviceName, serviceCount));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error - cannot read from the file " + fileName);
        }
    }
}
