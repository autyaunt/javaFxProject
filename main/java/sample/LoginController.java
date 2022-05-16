package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController  {

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField ;
    @FXML
    private PasswordField enterPasswordTextField;

    public void loginButtonOnAction(ActionEvent event){
        if (usernameTextField.getText().isBlank() == false && usernameTextField.getText().isBlank() == false){
            validateLogin();
        }else {
            loginMessageLabel.setText("Enter username and password");
        }

    }
    public void registerButtonAction(ActionEvent event){
        registerForm();
    }

    private void validateLogin() {
        DatabaseConnection connection = new DatabaseConnection();
        Connection connection1 = connection.getDataBaseLink();
        String select = "SELECT count(1) FROM user_account WHERE username = '";
        String where = usernameTextField.getText()+"' AND password = '"+enterPasswordTextField.getText()+"'";
        /*
        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '"+usernameTextField.getText()+
                "' AND password = '"+enterPasswordTextField.getText()+"'";
        */
        String verifyLogin = select+where;
        System.out.println(verifyLogin);
        try {
            Statement statement = connection1.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    loginMessageLabel.setText("login");

                }else {
                    loginMessageLabel.setText("login fail");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void registerForm(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Stage registerStage = new Stage();
            registerStage.resizableProperty().setValue(Boolean.FALSE); // ห้ามปรับขนาดจอ
            registerStage.setScene(new Scene(root,700,450));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
