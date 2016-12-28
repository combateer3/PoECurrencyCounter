package driver;

import gui.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public enum Currency {
        TRANSMUTE, AUGMENT, ALT, ALCH, REGAL,
        CHAOS, EXALT, DIVINE, MIRROR, SILVER,
        CHANCE, BLESSED, SCOURING, REGRET, CHROMATIC,
        FUSING, GEMCUTTER, JEWELLER, CHISEL, VAAL,
        BAUBLE, SCRAP, WHETSTONE
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/gui/mainGUI.fxml"));
        primaryStage.setTitle("Path of Exile Currency Counter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() {
        MainController.save();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
