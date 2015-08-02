import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ListCalls
{
	public static void display(String title, String message)
	{
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);

		Label listlabel = new Label(message);

		Button back = new Button("Back");
		back.setOnAction(event -> {
			window.close();
		});
		Button exit = new Button("Exit");
		exit.setOnAction(event -> {
			if(AlertBox.display(Main.getExitTitle(), Main.getExitMessage())) {
				Main.closeProgram(0);
			}
		});
		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(listlabel, back, exit);

		Scene scene = new Scene(layout, 400, 600);
		window.setScene(scene);
		window.showAndWait();
	}
}
