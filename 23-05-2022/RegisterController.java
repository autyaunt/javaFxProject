package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;


public class RegisterController{
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField vaccine1TextField;
    @FXML
    private TextField vaccine2TextField;
    @FXML
    private TextField vaccine3TextField;
    @FXML
    private TextField vaccine4TextField;
    @FXML
    private Label registerLabel;

    public void confirmRegisterAction(ActionEvent event){
        if (firstNameTextField.getText().isBlank() || lastNameTextField.getText().isBlank() || phoneNumberTextField.getText().isBlank()
            && emailTextField.getText().isBlank() || userNameTextField.getText().isBlank() || passwordTextField.getText().isBlank()
            && dateTextField.getText().isBlank() || addressTextField.getText().isBlank() || vaccine1TextField.getText().isBlank()
            && vaccine2TextField.getText().isBlank() || vaccine3TextField.getText().isBlank() || vaccine4TextField.getText().isBlank())
        {
            registerLabel.setText("กรุณากรอกข้อมูลให้ครบ");
        }else {
            registerUser();
        }
    }
    public void registerUser(){
        DatabaseConnection connection = new DatabaseConnection();
        Connection connection1 = connection.getDataBaseLink();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String email = emailTextField.getText();
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        String date = dateTextField.getText();
        String address = addressTextField.getText();
        String vaccine1 = vaccine1TextField.getText();
        String vaccine2 = vaccine2TextField.getText();
        String vaccine3 = vaccine3TextField.getText();
        String vaccine4 = vaccine4TextField.getText();

        String insert = "INSERT INTO user_account (firstname,lastname,phone_number,email,username,password,birthdate,address,vaccine1,vaccine2,vaccine3,vaccine4) ";
        String values = "VALUES ('"+firstName+"','"+lastName+"','"+phoneNumber+"','"+email+"','"+userName+"','"+password+
                "','"+date+"','"+address+"','"+vaccine1+"','"+vaccine2+"','"+vaccine3+"','"+vaccine4+"')";
        String insetValues = insert+values;
        try {
            Statement statement = connection1.createStatement();
            //สร้างstatement เพื่อจะได้ใช้ query อัพเดทข้อมูล
            ResultSet resultSet =statement.executeQuery("SELECT * FROM user_account WHERE username = '"+userName+"'");
            if (resultSet.next() == true){
                System.out.println("username Duplicate");
                registerLabel.setText("username ซ้ำ");

            } else {
                statement.executeUpdate(insetValues);
                System.out.println("1");
                registerLabel.setText("ลงทะเบียนสำเร็จ");
            }

        }catch (SQLIntegrityConstraintViolationException e){
            registerLabel.setText("เบอร์โทรศัพท์ซ้ำ"); //ตัวซ้ำมีแค่ 2 ตัวก็คือ เลขโทรรศัพท์กับไอดี จึงดักแค่นี้ได้เลย
        }
        catch (DataTruncation e){
            StringBuffer ee = new StringBuffer(String.valueOf(e)).delete(0,50);
            registerLabel.setText(String.valueOf(ee));
        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();


        }
    }
}
