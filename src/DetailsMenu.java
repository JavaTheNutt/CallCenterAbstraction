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
		Button back = new Button("Back");

		specificCallButton.setOnAction(event1 -> SpecificCallGui.display());
		allCallsButton.setOnAction(event1 -> {
			String list = Main.listAll();
			ListCalls.display("All calls", list);
		});
		longestCallButton.setOnAction(event1 -> ListCalls.display("Longest Call", Main.getLongest().toString()));
		shortestCallButton.setOnAction(event1 -> ListCalls.display("Shortest Call", Main.getShortest().toString()));
		callsAboveSuggestedLengthButton.setOnAction(event1 -> ListCalls.display("Calls above suggested length", Main.aboveSuggested()));
		back.setOnAction(event -> window.close());

		GridPane layout = new GridPane();
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(15, 15, 15, 15));

		GridPane.setConstraints(topLabel, 1, 0, 2, 1);
		GridPane.setConstraints(specificCallLabel, 0, 1);
		GridPane.setConstraints(specificCallButton, 1, 1);
		GridPane.setConstraints(allCallsLabel, 0, 2);
		GridPane.setConstraints(allCallsButton, 1, 2);
		GridPane.setConstraints(longestCallLabel, 0, 3);
		GridPane.setConstraints(longestCallButton, 1, 3);
		GridPane.setConstraints(shortestCallLabel, 0, 4);
		GridPane.setConstraints(shortestCallButton, 1, 4);
		GridPane.setConstraints(callsAboveSuggestedLengthLabel, 0, 5);
		GridPane.setConstraints(callsAboveSuggestedLengthButton, 1, 5);
		GridPane.setConstraints(back, 0, 6);

		layout.getChildren().addAll(topLabel, specificCallButton, specificCallLabel, allCallsButton, allCallsLabel,
				longestCallButton,longestCallLabel,shortestCallButton,shortestCallLabel, callsAboveSuggestedLengthLabel, callsAboveSuggestedLengthButton,back);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
