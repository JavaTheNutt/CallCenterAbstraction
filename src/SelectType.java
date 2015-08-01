import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SelectType
{
	static String check;

	public static String display()
	{
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Select a call type");
		window.setMinWidth(250);
		window.setMinHeight(300);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check)
			{
				Main.closeProgram(0);
			}

		});

		Label label = new Label("Please select a call type");

		Button salesButton = new Button("Sales");
		Button supportButton = new Button("Support");
		Button backButton = new Button("Back");
		Button exitButton = new Button("Exit");

		salesButton.setOnAction(event -> {
			check = "Sales";
			AddCallGui.display(check);
		});
		supportButton.setOnAction(event -> {
			check = "Support";
			AddCallGui.display(check);

		});
		backButton.setOnAction(event1 -> window.close());

		exitButton.setOnAction(event -> {
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check)
			{
				Main.closeProgram(0);
			}
		});

		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, salesButton, supportButton, backButton, exitButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

		return check;
	}
}
