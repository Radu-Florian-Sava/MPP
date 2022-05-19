package client;

import client.ams.LoginControllerAMS;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartAMSRpcClientFX extends Application {

    public void start(Stage primaryStage) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-client.xml");
        LoginControllerAMS ctrl = context.getBean("loginCtrl", LoginControllerAMS.class);

        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource("loginWindow.fxml"));
        loader.setController(ctrl);

        FXMLLoader mainLoader = new FXMLLoader(
                getClass().getClassLoader().getResource("mainWindow.fxml"));

        ctrl.setWindowController(ctrl.getWindowCtrl());
        mainLoader.setController(ctrl.getWindowCtrl());

        Parent mainRoot = mainLoader.load();
        ctrl.setParent(mainRoot);

        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Aplicatie aeroport");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
