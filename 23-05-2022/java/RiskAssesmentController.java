package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RiskAssesmentController implements Initializable {
    @FXML
    private Label usernameLabel;
    @FXML
    private Button AssessInfo;
    @FXML
    private CheckBox Symptom1,Symptom2,Symptom3,Symptom4,Symptom5,Symptom6,Symptom7,Symptom8;
    @FXML
    private RadioButton riskmultiplier1,riskmultiplier2,noriskmultiplier1,noriskmultiplier2;
    @FXML
    private Label result;
    @FXML
    private ChoiceBox<String> GenderChoicebox,AgeChoicebox ;

    private String[] age ={"0-17","18-44","45-64","65-74","75+"};
    private String[] gender ={"ชาย","หญิง"};

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
    private int risk;
    private double riskmultiplied=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       AgeChoicebox.getItems().addAll(age);
        GenderChoicebox.getItems().addAll(gender);
    }


    public void Assess(ActionEvent event) {
        checkSymtoms();
        riskMultiplied();
        showResult();
        risk=0;riskmultiplied=1;
    }




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

        User user = new User(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        HomeController homeController = loader.getController();
        homeController.displayUsername(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void toProfile(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        ProfileController profileController = loader.getController();
        profileController.displayUsername(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    }


    public void toCaseReport(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CaseReport.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        CaseReportController caseReportController = loader.getController();
        caseReportController.displayUsername(tempfirstname, templastname, tempphonenumLabel,
                tempemailLabel, tempusernameLabel, temppassword,
                tempbirthdayLabel, tempaddressLabel ,tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void checkSymtoms(){
        if(Symptom1.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom2.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom3.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom4.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom5.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom6.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom7.isSelected()) {risk +=1;} else {risk +=0;}
        if(Symptom8.isSelected()) {risk +=1;} else {risk +=0;
        }
    }
    public void riskMultiplied(){
        if(riskmultiplier1.isSelected()) {riskmultiplied =1*1.5;} else {risk +=0;}
        if(riskmultiplier2.isSelected()) {riskmultiplied =riskmultiplied*1.5;} else {risk +=0;}
    }
    public void showResult(){
        if (risk*riskmultiplied>=8){
            result.setText("HIGH");
            result.setTextFill(Color.RED);}

        else if(risk*riskmultiplied >4){
            result.setText("MEDIUM");
            result.setTextFill(Color.YELLOW);}

        else{
            result.setText("LOW");
            result.setTextFill(Color.GREEN);}

    }


}

