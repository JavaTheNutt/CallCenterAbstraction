import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SpecificCallGui
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Specific call details");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});

		Label topLabel = new Label("Get the details of a specific call");
		Label idInputLabel = new Label("Please enter the id of the call");

		TextField idInputField = new TextField();

		Button back = new Button("Back");
		Button submit = new Button("Submit");

		back.setOnAction(e -> window.close());
		submit.setOnAction(event -> {
			String call;
			if(idInputField.getText().trim().length() > 0){
				if(Main.getFromCenter(idInputField.getText())){
					call = Main.callToString(idInputField.getText());
					ListCalls.display("Specific call", call);
				} else {
					PopUp.display("Failed", "Call does not exist");
				}
			} else {
				PopUp.display("Failed", "No call Id entered");
			}
		});

		GridPane layout = new GridPane();
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));

		GridPane.setConstraints(topLabel, 1, 0);
		GridPane.setConstraints(idInputLabel, 0, 1);
		GridPane.setConstraints(idInputField, 1, 1);
		GridPane.setConstraints(back, 0, 2);
		GridPane.setConstraints(submit, 1, 2);


		layout.getChildren().addAll(topLabel, idInputField, idInputLabel, back , submit);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
