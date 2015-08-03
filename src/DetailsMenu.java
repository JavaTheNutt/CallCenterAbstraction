import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DetailsMenu
{
	public static void display()
	{
		Stage window = new Stage();
		window.setTitle("Call Details");
		window.initModality(Modality.APPLICATION_MODAL);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});

		Label topLabel = new Label("Call Details");
		Label specificCallLabel = new Label("Display details of a specific call");
		Label allCallsLabel = new Label("Display details of all calls");
		Label longestCallLabel = new Label("Display details of the longest call");
		Label shortestCallLabel = new Label("Display details of the shortest call");
		Label callsAboveSuggestedLengthLabel = new Label("Display the details of all calls above the suggested length");

		Button specificCallButton = new Button("Specific");
		Button allCallsButton = new Button("All");
		Button longestCallButton = new Button("Longest");
		Button shortestCallButton = new Button("Shortest");
		Button callsAboveSuggestedLengthButton = new Button("Above Suggested");

		GridPane layout = new GridPane();
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(15, 15, 15, 15));

		GridPane.setConstraints(topLabel, 1, 0, 2, 1);
		GridPane.setConstraints(specificCallLabel, 0, 1);
		GridPane.setConstraints(specificCallButton, 1, 1);

		layout.getChildren().addAll(topLabel, specificCallButton, specificCallLabel);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
