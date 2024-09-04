package nec.FunWithProcesses;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        MainView mainView = new MainView();
        System.out.println(Thread.currentThread().getName());

        Scene onlyScene = new Scene(mainView.asParent(), 900, 800);

        System.out.println(Thread.currentThread().getName());
        stage.setScene(onlyScene);

        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        launch(args);
        System.out.println(Thread.activeCount());
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName());
//
//        }
    }
}
