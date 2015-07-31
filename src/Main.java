import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	Stage window;

	Scene mainScene;

	Label mainLabel;

	Button addButton;

	VBox mainLayout;
	public static void main (String[] args)
	{
		launch (args);
	}

	@Override
	public void start (Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("My Application");

		addButton = new Button("Add A Call");
		addButton.setOnAction(event -> {
			String result = SelectType.display();
			System.out.println(result);
		});

		mainLabel = new Label("Call Center System");

		mainLayout = new VBox(20);
		mainLayout.getChildren().addAll(mainLabel, addButton);
		mainLayout.setAlignment(Pos.CENTER);

		mainScene = new Scene(mainLayout, 250, 300);

		window.setScene(mainScene);
		window.show();


	}


}
