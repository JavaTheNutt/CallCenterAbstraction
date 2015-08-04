import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateSuggestedGui
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Update suggested length of calls");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});
		Label topLabel = new Label("Update suggested length of calls");

		TextField newSuggested = new TextField();

		Button submit = new Button("Submit");
		Button back = new Button("Back");

		submit.setOnAction(event -> {
			if(newSuggested.getText().trim().length() > 0){
				try {
					int newSugg = Integer.parseInt(newSuggested.getText());
					Call.setSuggestedLengthofCall(newSugg);
					PopUp.display("Succeeded", "Suggested length of call set to " + newSugg);
				} catch(NumberFormatException e){
					PopUp.display("Failed", "Please enter a valid number");
				}
			} else {
				PopUp.display("Failed", "Empty field");
			}
		});
		back.setOnAction(event -> window.close());

		GridPane layout = new GridPane();
		GridPane.setConstraints(topLabel, 0, 1);
		GridPane.setConstraints(newSuggested, 1, 1);
		GridPane.setConstraints(back, 0, 2);
		GridPane.setConstraints(submit, 1, 2);

		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.getChildren().addAll(topLabel, newSuggested, back, submit);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
