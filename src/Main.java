import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	private static String exitTitle = "Confirm Exit";
	private static String exitMessage = "Are you sure you wish to exit?";
	Stage window;

	Scene mainScene;

	Label mainLabel;

	Button addButton;
	Button closeButton;

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
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(exitTitle, exitMessage);
			if(check)
			{
				closeProgram(0);
			}

		});

		addButton = new Button("Add A Call");
		addButton.setOnAction(event -> {
			String result = SelectType.display();
			System.out.println(result);
		});

		closeButton = new Button("Exit");
		closeButton.setOnAction(event -> {
			boolean check = AlertBox.display(exitTitle, exitMessage);
			if(check)
			{
				closeProgram(0);
			}
		});

		mainLabel = new Label("Call Center System");

		mainLayout = new VBox(20);
		mainLayout.getChildren().addAll(mainLabel, addButton, closeButton);
		mainLayout.setAlignment(Pos.CENTER);

		mainScene = new Scene(mainLayout, 250, 300);

		window.setScene(mainScene);
		window.show();


	}

	public static void closeProgram(int code)
	{
		System.exit(code);
	}
	public static String getExitTitle()
	{
		return exitTitle;
	}
	public static String getExitMessage ()
	{
		return exitMessage;
	}

}
