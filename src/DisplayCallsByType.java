import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayCallsByType
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Select Type");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});

		Label label = new Label("Please select the type of call to display by");
		Button salesButton = new Button("Sales");
		Button supportButton = new Button("Support");

		salesButton.setOnAction(event -> {
			TableList.display("Sales Calls", Main.getCenter().getCalls("Sales"));
		});

		supportButton.setOnAction(event -> TableList.display("Support Calls", Main.getCenter().getCalls("Support")));

		GridPane layout = new GridPane();
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setConstraints(label, 1, 0);
		GridPane.setConstraints(salesButton, 0, 1);
		GridPane.setConstraints(supportButton, 2, 1);
		layout.getChildren().addAll(label, salesButton, supportButton);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();



	}
}
