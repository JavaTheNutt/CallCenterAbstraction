import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateStatusGui
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Update Call Status");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}

		});

		Label topLabel = new Label("Update Call Status");
		topLabel.setAlignment(Pos.TOP_CENTER);
		Label idLabel = new Label("Please enter the Id of the call to be updated");
		Label statusLabel = new Label("Please enter the new call status");

		TextField idInput = new TextField();

		ChoiceBox<String> statusSelect = new ChoiceBox();
		statusSelect.getItems().addAll("Open", "Pending", "Closed");
		statusSelect.setValue("Closed");

		Button submit = new Button("Submit");
		submit.setOnAction(event -> verify(statusSelect, idInput.getText(), statusSelect.getValue()));

		Button back = new Button("Back");
		back.setOnAction(event -> window.close());

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setAlignment(Pos.CENTER);
		GridPane.setConstraints(idLabel, 0, 1);
		GridPane.setConstraints(idInput, 1, 1);
		GridPane.setConstraints(statusLabel, 0, 2);
		GridPane.setConstraints(statusSelect, 1, 2);
		GridPane.setConstraints(back, 0, 3);
		GridPane.setConstraints(submit, 1, 3);
		layout.getChildren().addAll(topLabel, idLabel, idInput, statusLabel, statusSelect, submit);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	private static void verify(ChoiceBox<String> input, String idIn, String choice)
	{
		if(Main.getFromCenter(idIn)){
			if(Main.statusUpdate(idIn, choice)){
				PopUp.display("Success", "Status updated successfully");
			}
		} else{
			PopUp.display("Failed", "No such Id exists");
		}
	}
}
