package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.util.EventObject;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordTextField;

    public void loginButtonOnAction(ActionEvent event) {
        if (usernameTextField.getText().isBlank() == false && usernameTextField.getText().isBlank() == false) {
            DatabaseConnection connection = new DatabaseConnection();
            Connection connection1 = connection.getDataBaseLink();
            String select = "SELECT count(1) FROM user_account";
            String where = " WHERE username = '"+usernameTextField.getText() + "' AND password = '" + enterPasswordTextField.getText() + "'";
            String verifyLogin = select + where;
            System.out.println(verifyLogin);
            try {
                Statement statement = connection1.createStatement();
                ResultSet queryResult = statement.executeQuery(verifyLogin);
                Statement statementUser = connection1.createStatement();

                ResultSet queryColumn = statementUser.executeQuery("SELECT * FROM user_account WHERE username = "+"'"+usernameTextField.getText()+"'");
                //ResultSet ข้อมูลจาก query
                while (queryResult.next()) {
                    if (queryResult.getInt(1) == 1) {
                        App home = new App();
                        loginMessageLabel.setText("login");
                        try {

                            FXMLLoader loader=new FXMLLoader(getClass().getResource("Homepage.fxml"));
                            Parent root = (Parent) loader.load();

                            queryColumn.next();

                            // ต้อง next เพราะแถวของ table ไม่รู้อยู่แถวไหน ต้องให้มาอยู่แล้ว ที่ 0
                            User user = new User(queryColumn.getNString("firstname"),
                                    queryColumn.getNString("lastname"),
                                    queryColumn.getNString("phone_number"),
                                    queryColumn.getNString("email"),
                                    queryColumn.getNString("username"),
                                    queryColumn.getNString("password"),
                                    queryColumn.getNString("firstname"), // TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                                    queryColumn.getNString("address"),
                                    queryColumn.getNString("vaccine1"),
                                    queryColumn.getNString("vaccine2"),
                                    queryColumn.getNString("vaccine3"),
                                    queryColumn.getNString("vaccine4"));
                            HomeController homeController=loader.getController();
                            homeController.displayUsername(queryColumn.getNString("firstname"),
                                    queryColumn.getNString("lastname"),
                                    queryColumn.getNString("phone_number"),
                                    queryColumn.getNString("email"),
                                    queryColumn.getNString("username"),
                                    queryColumn.getNString("password"),
                                    queryColumn.getNString("firstname"),// TESTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                                    queryColumn.getNString("address"),
                                    queryColumn.getNString("vaccine1"),
                                    queryColumn.getNString("vaccine2"),
                                    queryColumn.getNString("vaccine3"),
                                    queryColumn.getNString("vaccine4"));
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(new Scene(root));
                            stage.show();



                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        loginMessageLabel.setText("login fail");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        } else {
            loginMessageLabel.setText("Enter username and password");
        }

    }

    public void registerButtonAction(ActionEvent event) {
        registerForm();
    }

//    private void validateLogin() {
//        DatabaseConnection connection = new DatabaseConnection();
//        Connection connection1 = connection.getDataBaseLink();
//        String select = "SELECT count(1) FROM user_account WHERE username = '";
//        String where = usernameTextField.getText() + "' AND password = '" + enterPasswordTextField.getText() + "'";
//        /*
//        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '"+usernameTextField.getText()+
//                "' AND password = '"+enterPasswordTextField.getText()+"'";
//        */
//        String verifyLogin = select + where;
//        System.out.println(verifyLogin);
//        try {
//            Statement statement = connection1.createStatement();
//            ResultSet queryResult = statement.executeQuery(verifyLogin);
//            while (queryResult.next()) {
//                if (queryResult.getInt(1) == 1) {
//                    App home = new App();
//                    loginMessageLabel.setText("login");
//                    try {
//
//                        FXMLLoader loader=new FXMLLoader(getClass().getResource("Homepage.fxml"));
//                        Parent root = (Parent) loader.load();
//
//                        User user = new User(queryResult.getNString("firstname"),
//                                queryResult.getNString("lastname"),
//                                queryResult.getNString("phone-number"),
//                                queryResult.getNString("email"),
//                                queryResult.getNString("username"),
//                                queryResult.getNString("password"),
//                                queryResult.getNString("birthdate"),
//                                queryResult.getNString("address"),
//                                queryResult.getNString("vaccine1"),
//                                queryResult.getNString("vaccine2"),
//                                queryResult.getNString("vaccine3"),
//                                queryResult.getNString("vaccine4"));
//                        HomeController homeController=loader.getController();
//                        homeController.displayUsername(queryResult.getNString("firstname"),
//                                queryResult.getNString("lastname"),
//                                queryResult.getNString("phone-number"),
//                                queryResult.getNString("email"),
//                                queryResult.getNString("username"),
//                                queryResult.getNString("password"),
//                                queryResult.getNString("birthdate"),
//                                queryResult.getNString("address"),
//                                queryResult.getNString("vaccine1"),
//                                queryResult.getNString("vaccine2"),
//                                queryResult.getNString("vaccine3"),
//                                queryResult.getNString("vaccine4"));
//                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                        stage.setScene(new Scene(root));
//                        stage.show();
//
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                } else {
//                    loginMessageLabel.setText("login fail");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            e.getCause();
//        }
//    }

    public void registerForm() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.resizableProperty().setValue(Boolean.FALSE); // ห้ามปรับขนาดจอ
            registerStage.setScene(new Scene(root, 700, 450));
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

}
