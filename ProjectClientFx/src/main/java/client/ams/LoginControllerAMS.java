package client.ams;

import client.gui.Util;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Admin;
import services.IServicesAMS;
import services.ProjectException;

public class LoginControllerAMS {
    Parent mainWindowParent;
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    private IServicesAMS server;
    private WindowControllerAMS windowCtrl;
    private Admin crtUser;

    public void setServer(IServicesAMS s) {
        server = s;
    }

    public WindowControllerAMS getWindowCtrl(){
        return windowCtrl;
    }
    public void setParent(Parent p) {
        mainWindowParent = p;
    }

    public void loginUser(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        crtUser = new Admin(0, username, password);


        try {
            server.login(crtUser);
            Stage stage = new Stage();
            stage.setTitle("Autentificat ca si " + crtUser.getUsername());
            stage.setScene(new Scene(mainWindowParent));

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    windowCtrl.logoutBackend();
                    System.exit(0);
                }
            });

            stage.show();
            windowCtrl.setUser(crtUser);
            Platform.runLater(() -> windowCtrl.loadFlights());
            Platform.runLater(() -> windowCtrl.loadClientNames());
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();

        } catch (ProjectException e) {
            Util.showWarning("Problema de autentificare", "Verificati numele de utilizator si parola");
        }


    }

    public void setUser(Admin admin) {
        this.crtUser = admin;
    }

    public void setWindowController(WindowControllerAMS windowController) {
        this.windowCtrl = windowController;
    }


}
