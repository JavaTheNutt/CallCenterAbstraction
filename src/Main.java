import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
	private static CallCenter center = new CallCenter();
	private static String exitTitle = "Confirm Exit";
	private static String exitMessage = "Are you sure you wish to exit?";
	Stage window;

	Scene mainScene;

	Label mainLabel;
	Label addLabel;
	Label removeLabel;
	Label listAllLabel;

	Button addButton;
	Button closeButton;
	Button listAllButton;
	Button removeButton;

	GridPane mainLayout;
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
			if(check) {
				closeProgram(0);
			}
		});

		addButton = new Button("Add");
		addButton.setOnAction(event -> {
			String result = SelectType.display();
		});
		GridPane.setConstraints(addButton , 1, 2);

		addLabel = new Label("Add a call");
		GridPane.setConstraints(addLabel, 0, 2);

		removeButton = new Button("Remove");
		removeButton.setOnAction(event1 -> {
			RemoveCallGui.display();
		});
		GridPane.setConstraints(removeButton, 1, 3);

		removeLabel = new Label("Remove a call");
		GridPane.setConstraints(removeLabel, 0, 3);

		closeButton = new Button("Exit");
		closeButton.setOnAction(event -> {
			boolean check = AlertBox.display(exitTitle, exitMessage);
			if(check) {
				closeProgram(0);
			}
		});
		GridPane.setConstraints(closeButton, 1, 12);

		listAllButton = new Button("List");
		listAllButton.setOnAction(event -> {
			String list = center.listAll();
			ListCalls.display("List all calls", list);
		});
		GridPane.setConstraints(listAllButton, 1, 4);

		listAllLabel = new Label("List all calls");
		GridPane.setConstraints(listAllLabel, 0, 4);
		mainLabel = new Label("Call Center System");
		GridPane.setConstraints(mainLabel, 0, 1);

		mainLayout = new GridPane();
		mainLayout.getChildren().addAll(mainLabel, addButton, listAllButton, closeButton, removeButton, addLabel, listAllLabel, removeLabel);
		mainLayout.setVgap(10);
		mainLayout.setHgap(10);
		mainLayout.setAlignment(Pos.CENTER);

		mainScene = new Scene(mainLayout, 500, 700);

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

	public static boolean addToCenter(Call callIn)
	{
		if(center.addCall(callIn))
		{
			return true;
		}
		return false;
	}

	public static boolean removeFromCenter(String idIn)
	{
		if(center.removeCall(idIn)){
			return true;
		}
		return false;
	}
}
