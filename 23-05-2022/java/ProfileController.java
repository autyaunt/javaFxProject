package com.example.demo1;

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
    private Label nameLabel;
    private Label birthdayLabel;
    private Label addressLabel;
    private Label phonenumLabel;
    private Label emailLabel;
    private Label firstvacLebel, secondvacLebel, thirdvacLebel, fourthvacLebel;

    private String tempfirstname;
    private String templastname;
    private String tempusernameLabel;
    private String tempnameLabel;
    private String tempbirthdayLabel;
    private String tempaddressLabel;
    private String tempphonenumLabel;
    private String tempemailLabel;
    private String tempfirstvacLebel;
    private String tempsecondvacLebel;
    private String tempthirdvacLebel;
    private String tempfourthvacLebel;
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
        tempfirstvacLebel = user.getVaccine1();
        tempsecondvacLebel = user.getVaccine2();
        tempthirdvacLebel = user.getVaccine3();
        tempfourthvacLebel = user.getVaccine4();


        usernameLabel.setText(tempusernameLabel);
        nameLabel.setText(tempnameLabel);
        birthdayLabel.setText(tempbirthdayLabel);
        addressLabel.setText(tempaddressLabel);
        phonenumLabel.setText(tempphonenumLabel);
        emailLabel.setText(tempemailLabel);
        firstvacLebel.setText(tempfirstvacLebel);
        secondvacLebel.setText(tempsecondvacLebel);
        thirdvacLebel.setText(tempthirdvacLebel);
        fourthvacLebel.setText(tempfourthvacLebel);
    }


    public void toHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);
        HomeController homeController = loader.getController();
        homeController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void toCaseReport(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseReport.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);
        CaseReportController caseReportController = loader.getController();
        caseReportController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void toRiskAssesment(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RiskAssesment.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);
        RiskAssesmentController riskAssesmentController = loader.getController();
        riskAssesmentController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLebel,
                tempsecondvacLebel, tempthirdvacLebel, tempfourthvacLebel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
