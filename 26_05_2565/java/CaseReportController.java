package com.example.oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaseReportController implements Initializable {

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

    @FXML
    private TableView<DateSearchModel> tableTableView;
    @FXML
    private TableColumn<DateSearchModel, String> tableDate;
    @FXML
    private TableColumn<DateSearchModel, Integer> tableInfect;
    @FXML
    private TableColumn<DateSearchModel, Integer> tableRecover;
    @FXML
    private TableColumn<DateSearchModel, Integer> tableDeath;
    @FXML
    private TextField tableTextField;

    ObservableList<DateSearchModel> dateSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle resource){
        DatabaseDateConnection connectNow = new DatabaseDateConnection();
        Connection connectOB = connectNow.getDataBaseLink();

        String TableViewQuart = "SELECT Date, Infect, Recover, Death FROM world.covid_report";

        try {

            Statement statement = connectOB.createStatement();
            ResultSet queryOutput = statement.executeQuery(TableViewQuart);

            while (queryOutput.next()){

                String queryDay = queryOutput.getString("Date");
                Integer queryInfect = queryOutput.getInt("Infect");
                Integer queryRecover = queryOutput.getInt("Recover");
                Integer queryDeath = queryOutput.getInt("Death");

                //populate the ObservableList
                dateSearchModelObservableList.add(new DateSearchModel(queryDay, queryInfect, queryRecover, queryDeath));
            }
            // propertyValueFactory corresponds to the new ProductSearchModel fields
            // The table column is the one you annotate above
            tableDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
            tableInfect.setCellValueFactory(new PropertyValueFactory<>("Infect"));
            tableRecover.setCellValueFactory(new PropertyValueFactory<>("Recover"));
            tableDeath.setCellValueFactory(new PropertyValueFactory<>("Death"));

            tableTableView.setItems(dateSearchModelObservableList);

            //initial filtered list
            FilteredList<DateSearchModel> filteredDate = new FilteredList<>(dateSearchModelObservableList, b ->true);

            tableTextField.textProperty().addListener((observable, oldValue, newValue)-> {
                filteredDate.setPredicate(dateSearchModel -> {

                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }

                    String tableTextField = newValue.toLowerCase();

                    if(dateSearchModel.getDate().toLowerCase().indexOf(tableTextField) > -1) {
                        return true;//found date
                    }
                    else if(dateSearchModel.getInfect().toString().indexOf(tableTextField) > -1){
                        return true;//found infect
                    }
                    else if(dateSearchModel.getRecover().toString().indexOf(tableTextField) > -1) {
                        return true;//found recover
                    }
                    else if(dateSearchModel.getDeath().toString().indexOf(tableTextField) > -1) {
                        return true;//found death
                    }
                    else
                        return false;//not match
                });
            });

            SortedList<DateSearchModel> sortedData = new SortedList<>(filteredDate);

            //Bind sorted result with table view
            sortedData.comparatorProperty().bind(tableTableView.comparatorProperty());

            //apply filter and sorted data to the table view
            tableTableView.setItems(sortedData);




        }catch (SQLException e){
            Logger.getLogger(DatabaseDateConnection.class.getName()).log(Level.SEVERE,null, e);
            e.printStackTrace();
        }

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



    public void toRiskAssesment(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RiskAssesment.fxml"));
        Parent root = (Parent) loader.load();

        User user = new User(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);
        RiskAssesmentController riskAssesmentController = loader.getController();
        riskAssesmentController.displayUsername(tempfirstname, templastname, tempbirthdayLabel,
                tempaddressLabel, tempphonenumLabel, tempemailLabel,
                tempusernameLabel, temppassword, tempfirstvacLabel,
                tempsecondvacLabel, tempthirdvacLabel, tempfourthvacLabel);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

