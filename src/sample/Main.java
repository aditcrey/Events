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
 * thread is busy and it is no longer paying attention to the user input...in other words the user won't be able to interact with the UI while that's actually accuring
 * and if he/she tries to do anything at that point, the application won't actually respond
 *
 *
 * If our event handler needs to do something which will take more time then what it should really be doing is start another thread(k/as background thread)...now this new thread would do the work that's
 * gonna take a while to process so the event handler which is still running on the UI thread will be able to return and the UI thread can listen to a user input again so
 * from the perspective of a user who is running the application, he/she won't see the pauses and the delays
 *
 * for eg. if data is to be retrieved from a database or internet, that can be done in the background thread and when the background thread has the data, it can inform the UI thread
 * which can then show it on the user interface
 *
 *
 * IMP NOTE: With thread other than the UI thread(also k/as JavaFx application thread), if we try to modify the nodes of the scene graph(controls and such)
 * then we'll get an exception(that scene graph isn't thread-safe)...note that we can't modify the nodes of scene-graph with threads other than the UI thread...for more
 * info on this go to 7:47 of lecture 139 of Udemy Tim Buchalka Java Masterclass on Threads and Runnable
 *
 *
 *when we are performing a long task in the background thread, we usually want to update a part of UI when the task is finish so what we need
 * here is a way to force code to run on the UI thread and JavaFX...we can do this by using run later method  in the platform class
 *
 * run later method accepts a runnable parameter and places it on the UI thread's queue so in other words, it's gonna force the runnable objects
 * to run on the UI thread
 *
 *
 *
 * There is a fx application thread method in Platform class which returns true when the code is running on the JavaFx appliction thread and false
 *false otherwise...we can use this method when we are trying to debug our code
 *
 *
 * javaFx provides APIs in javafx.concurrent for threads and stuff but it's an advanced topic which will not be studied in this course
 * link: https://docs.oracle.com/javase/8/javafx/interoperability-tutorial/concurrency.htm
 */
