package mathDefinitions.mathMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mathDefinitions.model.Def;

public class MathApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Def.load("denitions.xml");
        Parent root = FXMLLoader.load(getClass().getResource("/definitions.fxml"))    ;
        stage.setTitle("Matematika fogalomtár");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
