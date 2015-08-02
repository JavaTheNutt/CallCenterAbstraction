import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp
{
	public static void display(String title, String message)
	{
		Stage window = new Stage();
		window.setTitle(title);
		window.initModality(Modality.APPLICATION_MODAL);

		Label label = new Label(message);
		Button confirm = new Button("Ok");
		confirm.setOnAction(event -> window.close());

		VBox layout = new VBox(20);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, confirm);

		Scene scene = new Scene(layout, 250, 300);
		window.setScene(scene);
		window.showAndWait();
	}
}
