package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/**
 * applications can be procedural driven or event driven
 * The procedural aplications are the ones in which there's an entry point and the code is executed by procedure...it's without UI(which we made earlier in the course)
 *
 * The applicatoins with UI are event driven..i.e. the user dictates what code will be run and when and that's by clicking on particular controls on the screen
 *
 *
 * In javafx, the UI thread waits for user input
 * When the user interacts with a control, an even is raise on the UI thread...in other words, the UI thread notices that the user's done
 * something and then check to see if any part of the application has expressed interest in handling whatever the user has done...if it
 * finds something then it is going to run the event handler the application has associated with that event
 *
 *
 * we write the event handlers in controller.java file and not the main.java
 *
 *
 * another way of saying that the application is interested in  handling an event is to say that it's listening for an event and for that reason event handlers are sometimes referred
 * to as event listeners
 *
 *
 * the UI thread sees the events and if the application is listening for that event, the event is dispatched to the event
 * handler
 * Now, the event handler itself runs on the UI thread so what that means is while an event handler is running, the UI
 * thread is busy and it is no longer paying attention to the user input
 *
 */
