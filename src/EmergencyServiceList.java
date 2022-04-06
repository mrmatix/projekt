import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class EmergencyServiceItem { // Local class
    // Local variables
    private String serviceName;
    private Integer serviceCount;

    EmergencyServiceItem(String serviceName, Integer serviceCount) {
        this.serviceName = serviceName;
        this.serviceCount = serviceCount;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Integer getServiceCount() {
        return serviceCount;
    }
}

public class EmergencyServiceList {

    public void displayEmergencyServices(ArrayList<EmergencyServiceItem> datas) {
        // display emergency services
        System.out.println("***EMERGENCY SERVICES***");
        System.out.println("=============");
        // Loop through info and names
        for (int i = 0; i < datas.size(); i++) {
            EmergencyServiceItem data = datas.get(i);
            System.out.printf("%d. %s \t %d\n", i + 1, data.getServiceName(), data.getServiceCount());
        }
        System.out.println("=============");
    }

    public void displayAllServices(String fileName, ArrayList<EmergencyServiceItem> data) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // PD,10
                String tokens[] = line.split(",");
                String serviceName = tokens[0];
                Integer serviceCount = Integer.parseInt(tokens[1]); // Parses the string argument as a signed decimal
                                                                    // integer
                data.add(new EmergencyServiceItem(serviceName, serviceCount));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error - cannot read from the file " + fileName);
        }
    }
}
