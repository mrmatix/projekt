import java.io.IOException;
import java.io.PipedInputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;

public class MainMenuGUI extends Application {

        // Attributes
        private Emergency emergency;
        private EmergencyList emergencyList;
        private EmergencyServiceList emergencyServiceList;
        Report report = new Report();

        // Data
        ArrayList<ServiceItem> serviceItems = new ArrayList<ServiceItem>();
        ArrayList<EmergencyServiceItem> emergencyServiceItems = new ArrayList<EmergencyServiceItem>();

        // WIDTH and HEIGHT of GUI as consts
        private final int WIDTH = 1280;
        private final int HEIGHT = 1024;

        // Visual components
        private Label headingLabel = new Label("*** EMERGENCY SERVICE ***");
        private TextField reportField = new TextField();
        private Label reportFieldLabel = new Label("Emergency no.");
        private TextField emergencyServicesField = new TextField();
        private Label emergencyServicesFieldLabel = new Label("Emergency Services no.");
        private TextField clientField = new TextField();
        private Label clientFieldLabel = new Label("Client info");
        private TextField addressField = new TextField();
        private Label addressFieldLabel = new Label("Address info");
        private Text textPlaceHolderForReportField = new Text("1-8");
        private Text textPlaceHolderForEmergencyServicesField = new Text("1-7");
        private Text textPlaceHolderForClientField = new Text("Full Name");
        private Text textPlaceHolderForAddressField = new Text("Address");
        private Text emergencyInfo = new Text();
        private Text emergencyServiceInfo = new Text();
        private Button reportButton = new Button("Report call");
        private Button displayAllReportButton = new Button("Display all reports");
        private Button displayReportButton = new Button("Display specific report");
        private Button displayServicesButton = new Button("Display emergency services");
        private Button removeClient = new Button("Remove a client");
        private Button removeAllClients = new Button("Remove all clients");
        private Button removeReport = new Button("Remove a report");
        private Button removeAllReports = new Button("Remove all reports");
        private Button quit = new Button("Quit");
        private TextArea displayArea = new TextArea();

        /*
         * Screen init
         * scane's stage
         */
        @Override
        public void start(Stage stage) throws Exception {
                // Putting placeholders
                reportField.setPromptText("1-8");
                emergencyServicesField.setPromptText("1-7");
                clientField.setPromptText("Full Name");
                addressField.setPromptText("Address");

                reportField.setFocusTraversable(false);
                emergencyServicesField.setFocusTraversable(false);
                clientField.setFocusTraversable(false);
                addressField.setFocusTraversable(false);

                StackPane paneForReportField = new StackPane(textPlaceHolderForReportField, reportField);
                reportField.setStyle(
                                "-fx-background-color:transparent;-fx-border-color:black;-fx-border-radius:2%;");
                paneForReportField.setStyle("-fx-background-color:white;");
                paneForReportField.setAlignment(Pos.CENTER_LEFT);

                StackPane paneForEmergencyServicesField = new StackPane(textPlaceHolderForEmergencyServicesField,
                                emergencyServicesField);
                emergencyServicesField
                                .setStyle("-fx-background-color:transparent;-fx-border-color:black;-fx-border-radius:2%;");
                paneForEmergencyServicesField.setStyle("-fx-background-color:white;");
                paneForEmergencyServicesField.setAlignment(Pos.CENTER_LEFT);

                StackPane paneForClientField = new StackPane(textPlaceHolderForClientField, clientField);
                clientField.setStyle(
                                "-fx-background-color:transparent;-fx-border-color:black;-fx-border-radius:2%;-fx-min-width: 200;");
                paneForClientField.setStyle("-fx-background-color:white;");
                paneForClientField.setAlignment(Pos.CENTER_LEFT);

                StackPane paneForAddressField = new StackPane(textPlaceHolderForAddressField, addressField);
                addressField.setStyle(
                                "-fx-background-color:transparent;-fx-border-color:black;-fx-border-radius:2%;-fx-min-width: 200;");
                paneForAddressField.setStyle("-fx-background-color:white;");
                paneForAddressField.setAlignment(Pos.CENTER_LEFT);

                // Set text to Legend
                emergencyInfo.setText(
                                "\n1: Robbery\n2: Homicide\n3: Carjacking\n4: Mugging\n5: Assault\n6: Arson\n7: Car Accident\n8: Your emergency is not on the list? Please type your emergency: ");
                emergencyServiceInfo.setText(
                                "1: Police Department\n2: Fire Department\n3: Emergency Department\n4: Police Department and Fire Department\n5: Police Department and Emergency Department\n6: Emergency Department and Fire Department\n7: Police Department and Fire Department and Emergency Department");

                // Text alignment
                emergencyInfo.setTextAlignment(TextAlignment.LEFT);
                emergencyServiceInfo.setTextAlignment(TextAlignment.LEFT);

                // Create HBoxes (4)
                HBox Fields = new HBox(10);
                HBox TextFields = new HBox(10);
                HBox reportAndDisplayButtons = new HBox(10);
                HBox removeButtons = new HBox(10);
                HBox removeAndQuitButtons = new HBox(10);

                // Add components to HBoxes
                Fields.getChildren().addAll(reportFieldLabel, reportField, emergencyServicesFieldLabel,
                                emergencyServicesField, clientFieldLabel, clientField, addressFieldLabel, addressField);
                TextFields.getChildren().addAll(emergencyInfo, emergencyServiceInfo);
                reportAndDisplayButtons.getChildren().addAll(reportButton, displayAllReportButton, displayReportButton,
                                displayServicesButton);
                removeButtons.getChildren().addAll(removeClient, removeAllClients, removeReport);
                removeAndQuitButtons.getChildren().addAll(removeAllReports, quit);

                // Create VBox
                VBox root = new VBox(10);

                // Add all components to VBox
                root.getChildren().addAll(headingLabel, Fields, TextFields, reportAndDisplayButtons, removeButtons,
                                removeAndQuitButtons,
                                displayArea);

                // Create the Scene
                Scene scene = new Scene(root, Color.rgb(255, 217, 214));

                // Set font of heading
                Font font = new Font("Calibri", 40);
                headingLabel.setFont(font);

                // Set alignment of HBoxes
                Fields.setAlignment(Pos.CENTER);
                TextFields.setAlignment(Pos.CENTER);
                reportAndDisplayButtons.setAlignment(Pos.CENTER);
                removeButtons.setAlignment(Pos.CENTER);
                removeAndQuitButtons.setAlignment(Pos.CENTER);

                // Set alignment of VBox
                root.setAlignment(Pos.CENTER);

                // Set minimum and maximum width of components
                reportField.setMaxWidth(50);
                emergencyServicesField.setMaxWidth(50);
                clientField.setMaxWidth(50);

                Fields.setMinWidth(WIDTH);
                Fields.setMaxWidth(WIDTH);

                TextFields.setMinWidth(WIDTH);
                TextFields.setMaxWidth(WIDTH);

                reportAndDisplayButtons.setMinWidth(WIDTH);
                reportAndDisplayButtons.setMaxWidth(WIDTH);

                removeButtons.setMinWidth(WIDTH);
                removeButtons.setMaxWidth(WIDTH);

                removeAndQuitButtons.setMinWidth(WIDTH);
                removeAndQuitButtons.setMaxWidth(WIDTH);

                root.setMinSize(WIDTH, HEIGHT);
                root.setMaxSize(WIDTH, HEIGHT);

                stage.setWidth(WIDTH);
                stage.setHeight(HEIGHT);

                displayArea.setMaxSize(WIDTH - 100, HEIGHT / 6);

                stage.setWidth(WIDTH);
                stage.setHeight(HEIGHT);

                // Customise the visual components

                // Customise the VBox border and background
                BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(0),
                                new BorderWidths(2));
                root.setBorder(new Border(style));
                root.setBackground(Background.EMPTY);

                // Customise buttons
                reportButton.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                displayAllReportButton.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                displayReportButton.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                displayServicesButton.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                removeClient.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                removeAllClients.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                removeReport.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                removeAllReports.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));
                quit.setBackground(
                                new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5),
                                                Insets.EMPTY)));

                // Call private methods for button event handlers
                reportButton.setOnAction(e -> reportCallButtonHandler());
                displayAllReportButton.setOnAction(e -> displayAllReportButtonHandler()); // does not work
                displayReportButton.setOnAction(e -> displayReportButtonHandler()); // does not work
                displayServicesButton.setOnAction(e -> displayServicesButtonHandler()); // does not work
                removeClient.setOnAction(e -> removeClientButtonHandler()); // does not work
                removeAllClients.setOnAction(e -> {
                        try {
                                removeAllClientsButtonHandler();
                        } catch (IOException e1) {
                                e1.printStackTrace();
                        }
                });
                removeReport.setOnAction(e -> removeReportButtonHandler()); // does not work
                removeAllReports.setOnAction(e -> {
                        try {
                                removeAllReportsButtonHandler();
                        } catch (IOException e1) {
                                e1.printStackTrace();
                        }
                });
                quit.setOnAction(e -> quitHandler());

                // Configure the stage and make the stage visible
                stage.setScene(scene);
                stage.setTitle("Emergency Service");
                stage.setResizable(false);
                stage.show();
        }

        private void reportCallButtonHandler() {
                String emergencyNumberEntered = reportField.getText();
                String emergencyServiceNumberEntered = emergencyServicesField.getText();
                String clientInfoEntered = clientField.getText();
                String addressInfoEntered = addressField.getText();
                // Check for errors
                if (emergencyNumberEntered.length() == 0 || emergencyServiceNumberEntered.length() == 0
                                || clientInfoEntered.length() == 0 || addressInfoEntered.length() == 0) {
                        displayArea.setText("Please Fill All Boxes");
                } else {
                        reportCallButtonHandlerRedirect(emergencyNumberEntered, emergencyServiceNumberEntered,
                                        clientInfoEntered, addressInfoEntered);

                        reportField.setText("");
                        emergencyServicesField.setText("");
                        clientField.setText("");
                        addressField.setText("");

                        displayArea.setText("Emergency successfully reported. Client credentials: " + clientInfoEntered
                                        + " " + addressInfoEntered + ". Emergency: " + emergencyNumberEntered);
                }
        }

        private void reportCallButtonHandlerRedirect(String emergencyNumberEntered,
                        String emergencyServiceNumberEntered, String clientInfoEntered, String addressInfoEntered) {
                emergency.emergencyCall();
        }

        private void displayAllReportButtonHandler() {
                emergencyList.readReportFileAll("C:/UEL/CN5004/TERM PROJECT/Term Project/src/report.txt",
                                serviceItems);
                emergencyList.displayReports(serviceItems);
        }

        private void displayReportButtonHandler() {
                report.displayReport();
        }

        private void displayServicesButtonHandler() {
                emergencyServiceList.displayAllServices(
                                "C:/UEL/CN5004/TERM PROJECT/Term Project/src/emergencyServices.txt",
                                emergencyServiceItems);
                emergencyServiceList.displayEmergencyServices(emergencyServiceItems);

        }

        private void removeClientButtonHandler() {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setHeaderText("Which one would you like to remove?");
                dialog.setTitle("Remove a Client");
                String response = dialog.showAndWait().get();
                Client.removeClient();

        }

        private void removeAllClientsButtonHandler() throws IOException {
                Client.removeAllClient();
                displayArea.setText("Successfully removed all clients");
        }

        private void removeReportButtonHandler() {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setHeaderText("Which one would you like to remove?");
                dialog.setTitle("Remove a Report");
                String response = dialog.showAndWait().get();
                report.removeReport();
        }

        private void removeAllReportsButtonHandler() throws IOException {
                report.removeAllReports();
                displayArea.setText("Successfully removed all reports");
        }

        private void quitHandler() {
                Platform.exit();
        }

        public static void main(String[] args) {
                launch(args);
        }

}
