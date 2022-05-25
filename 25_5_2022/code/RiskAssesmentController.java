package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RiskAssesmentController {
    @FXML
    private Label usernameLabel;


    private String tempfirstname;
    private String templastname;
    private String tempusernameLabel;
    private String tempnameLabel;
    private String tempbirthdayLabel;
    private String tempaddressLabel;
    private String tempphonenumLabel;
    private String tempemailLabel;
    private String tempfirstvacLabel;
    private String tempsecondvacLabel;
    private String tempthirdvacLabel;
    private String tempfourthvacLabel;
    private String temppassword;


    public void displayUsername(String firstName, String lastName, String phoneNumber, String email, String userName,
                                String password, String date, String address, String vaccine1, String vaccine2, String vaccine3, String vaccine4) {
        User user = new User(firstName, lastName, phoneNumber, email, userName, password,
                date, address, vaccine1, vaccine2, vaccine3, vaccine4);


        tempfirstname = user.getFirstName();
        templastname = user.getLastName();
        tempnameLabel = user.getFirstName() + " " + user.getLastName();
        tempbirthdayLabel = user.getDate();
        tempaddressLabel = user.getAddress();
        tempphonenumLabel = user.getPhoneNumber();
        tempemailLabel = user.getEmail();
        tempusernameLabel = user.getUserName();
        temppassword = user.getPassword();
        tempfirstvacLabel = user.getVaccine1();
        tempsecondvacLabel = user.getVaccine2();
        tempthirdvacLabel = user.getVaccine3();
        tempfourthvacLabel = user.getVaccine4();

        usernameLabel.setText(tempusernameLabel);
    }


    public void toHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        HomeController homeController = loader.getController();
        homeController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void toProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        ProfileController profileController = loader.getController();
        profileController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    }


    public void toCaseReport(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseReport.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        CaseReportController caseReportController = loader.getController();
        caseReportController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
