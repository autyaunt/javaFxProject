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


public class ProfileController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label phonenumLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label firstvacLabel ,secondvacLabel, thirdvacLabel, fourthvacLabel;

    private String firstname;
    private String lastname;
    private String username;
    private String name;
    private String birthday;
    private String address;
    private String phone_number;
    private String email;
    private String vaccine1;
    private String vaccine2;
    private String vaccine3;
    private String vaccine4;
    private String password;

    private User user;
    public void displayProfile(User user){
        this.user = user;
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.name = user.getFirstName() + " " + user.getLastName();
        this.birthday = user.getDate();
        this.address = user.getAddress();
        this.phone_number = user.getPhoneNumber();
        this.email = user.getEmail();
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.vaccine1 = user.getVaccine1();
        this.vaccine2 = user.getVaccine2();
        this.vaccine3 = user.getVaccine3();
        this.vaccine4 = user.getVaccine4();
        this.usernameLabel.setText(username);
        this.nameLabel.setText(name);
        this.birthdayLabel.setText(birthday);
        this.addressLabel.setText(this.address);
        this.phonenumLabel.setText(phone_number);
        this.emailLabel.setText(this.email);
        this.firstvacLabel.setText(this.vaccine1);
        this.secondvacLabel.setText(this.vaccine2);
        this.thirdvacLabel.setText(this.vaccine3);
        this.fourthvacLabel.setText(this.vaccine4);
    }

//    public void displayUsername(String firstName, String lastName, String phoneNumber, String email, String userName,
//                                String password, String date, String address, String vaccine1, String vaccine2, String vaccine3, String vaccine4) {
//
//        User user = new User(firstName, lastName, phoneNumber, email, userName, password,
//                date, address, vaccine1, vaccine2, vaccine3, vaccine4);
//        this.firstname = user.getFirstName();
//        this.lastname = user.getLastName();
//        this.name = user.getFirstName() + " " + user.getLastName();
//        this.birthday = user.getDate();
//        this.address = user.getAddress();
//        this.phone_number = user.getPhoneNumber();
//        this.email = user.getEmail();
//        this.username = user.getUserName();
//        this.password = user.getPassword();
//        this.vaccine1 = user.getVaccine1();
//        this.vaccine2 = user.getVaccine2();
//        this.vaccine3 = user.getVaccine3();
//        this.vaccine4 = user.getVaccine4();
//        this.usernameLabel.setText(username);
//        this.nameLabel.setText(name);
//        this.birthdayLabel.setText(birthday);
//        this.addressLabel.setText(this.address);
//        this.phonenumLabel.setText(phone_number);
//        this.emailLabel.setText(this.email);
//        this.firstvacLabel.setText(this.vaccine1);
//        this.secondvacLabel.setText(this.vaccine2);
//        this.thirdvacLabel.setText(this.vaccine3);
//        this.fourthvacLabel.setText(this.vaccine4);
//    }


    public void toHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent root = (Parent) loader.load();
        HomeController homeController = loader.getController();
        homeController.displayHomePage(user);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void toCaseReport(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseReport.fxml"));
        Parent root = (Parent) loader.load();
        CaseReportController caseReportController = loader.getController();
        caseReportController.displayCaseReport(user);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void toRiskAssessment(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RiskAssessment.fxml"));
        Parent root = (Parent) loader.load();
        RiskAssessmentController riskAssesmentController = loader.getController();
        riskAssesmentController.displayRiskAssessmentPage(user);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
