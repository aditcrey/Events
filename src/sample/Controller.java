package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField; //make sure to import javafx.scene and not java.awt //be careful about this

public class Controller {
    @FXML  //important when we declare like the following line otherwise it won't be assigned to the fxml control
    private TextField nameField; //make sure that the name matches the fx:id in fxml file
    @FXML
    private Button helloButton;
    @FXML //@FXML is called annotation
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;

    @FXML
    public void initialize(){ //to disable the buttons when the application starts
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML  //well, it's not necessary here like above but it caters to the readablity of the code
    public void onButtonClicked(ActionEvent e){ //we use this parameter(not necessary) so that the same
        //event handler can be used with multiple controls by knowing which control was actually used and saves
        //us from creating event handler for each and every control

        if(e.getSource().equals(helloButton)){
            System.out.println("Hello " + nameField.getText());
        }else if(e.getSource().equals(byeButton)){
            System.out.println("Bye "+ nameField.getText());
        }

        try{
            Thread.sleep(10000);  //doing this just to make sure that the event handling takes 10 seconds and the UI thread is not listening to other events for this 10 secs and the appilcation will actually freeze
        }catch (InterruptedException event){
            //we don't care about this
        }

        //now we want to clear the textfield if the checkbox is checked
        if(ourCheckBox.isSelected()){
            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }



    }


    //Now we want to make sure that the buttons are disabled will the user enters some text in the TextField and hence
    //we put an event handler that listens for the on key released event to enable the button when a character is typed
    //in the TextField



    @FXML
    public void handleKeyRelease(){
        String text = nameField.getText();
        boolean disableButton = text.isEmpty() || text.trim().isEmpty(); //text.trim() is there to ignore any white spaces
        helloButton.setDisable(disableButton);
        byeButton.setDisable(disableButton);
    }


    //now we want that when the user checks the checkBOx, the text in the textField is cleared after printing
    //for this check the state of the checkbox at the time of pressing the button(this is better than listening to checking and uncheking of the checkbox as the user
    //can check and uncheck infinitely before pressing the button)
    public void handleChange(){
        System.out.println("The checkbox is " + (ourCheckBox.isSelected()?"checked":"not checked"));
    }
}
