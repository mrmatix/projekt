import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ServiceItem {
    private String reportInfo;
    private String serviceName;

    ServiceItem(String reportInfo, String serviceName) {
        this.reportInfo = reportInfo;
        this.serviceName = serviceName;
    }

    public String getReportInfo() {
        return reportInfo;
    }

    public String getServiceName() {
        return serviceName;
    }
}

public class EmergencyList {
    public void readReportFileAll(String fileName, ArrayList<ServiceItem> data) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Robbery,PD
                String tokens[] = line.split(",");
                String reportInfo = tokens[0];
                String serviceName = tokens[1];
                data.add(new ServiceItem(reportInfo, serviceName));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error - cannot read from the file " + fileName);
        }
    }
}
