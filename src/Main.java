import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application
{
	Stage window;

	Label mainLabel;

	Button addButton;

	public static void main (String[] args)
	{
		launch (args);
	}

	@Override
	public void start (Stage primaryStage) throws Exception
	{
		window = primaryStage;
		window.setTitle("My Application");

	}


}
