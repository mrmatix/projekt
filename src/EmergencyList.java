import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ServiceItem { // Local class
    // Local variables
    private String reportInfo;
    private String serviceName;

    // Local object
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

public class EmergencyList extends Emergency {

    public void displayReports(ArrayList<ServiceItem> datas) {
        // display reports
        System.out.println("***REPORTS***");
        System.out.println("=============");
        // Loop through info and names
        for (int i = 0; i < datas.size(); i++) {
            ServiceItem data = datas.get(i);
            System.out.printf("%d. %s \t %s\n", i + 1, data.getReportInfo(), data.getServiceName());
        }
        System.out.println("=============");
    }

    public void readReportFileAll(String fileName, ArrayList<ServiceItem> datas) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                // Robbery,PD
                String tokens[] = line.split("|");
                String reportInfo = tokens[0];
                String serviceName = tokens[1];
                datas.add(new ServiceItem(reportInfo, serviceName));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error - cannot read from the file " + fileName);
        }
    }
}
