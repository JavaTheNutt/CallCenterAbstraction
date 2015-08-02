import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RemoveCallGui
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Remove a call");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});


		Label mainLabel = new Label("Remove Call");
		TextField idInput = new TextField();
		Label idLabel = new Label("Enter the Id of the call to be removed");
		Button remove = new Button("Remove");
		remove.setAlignment(Pos.CENTER);
		remove.setOnAction(event -> {
			String idOfCall = idInput.getText();
			if(idOfCall.trim().length() > 0) {
				if(Main.removeFromCenter(idOfCall)) {
					PopUp.display("Success", "Call removed successfully.");
					window.close();
				} else {
					PopUp.display("Failed", "No call with that Id exists.");
				}
			} else {
				PopUp.display("Failed", "Call Id field required.");
			}
		});

		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		GridPane.setConstraints(mainLabel, 0, 1);
		GridPane.setConstraints(idLabel, 1, 0);
		GridPane.setConstraints(idInput, 1, 1);
		GridPane.setConstraints(remove, 1, 2);
		layout.getChildren().addAll(mainLabel, idLabel, idInput, remove);

		Scene scene =  new Scene(layout, 500, 500);
		window.setScene(scene);
		window.showAndWait();
	}
}
