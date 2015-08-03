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
	Label updateStatusLabel;
	Label checkFullLabel;
	Label checkEmptyLabel;
	Label detailsLabel;

	Button addButton;
	Button closeButton;
	Button listAllButton;
	Button removeButton;
	Button updateStatusButton;
	Button checkFullButton;
	Button checkEmptyButton;
	Button detailsButton;

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

		mainLabel = new Label("Call Center System");
		addLabel = new Label("Add a call");
		removeLabel = new Label("Remove a call");
		updateStatusLabel = new Label("Update call status");
		checkFullLabel = new Label("Check if the call list is full");
		checkEmptyLabel = new Label("Check if the call list is empty");
		listAllLabel = new Label("List all calls");
		detailsLabel = new Label("Call Details");


		addButton = new Button("Add");
		removeButton = new Button("Remove");
		updateStatusButton = new Button("Update");
		checkFullButton = new Button("Check");
		checkEmptyButton = new Button("Check");
		closeButton = new Button("Exit");
		listAllButton = new Button("List");
		detailsButton = new Button("Details");

		addButton.setOnAction(event -> {
			String result = SelectType.display();
		});

		removeButton.setOnAction(event1 -> {
			RemoveCallGui.display();
		});

		updateStatusButton.setOnAction(event1 -> {
			UpdateStatusGui.display();
		});

		listAllButton.setOnAction(event -> {
			String list = center.listAll();
			ListCalls.display("List all calls", list);
		});

		checkFullButton.setOnAction(event1 -> {
			if(center.isFull()){
				PopUp.display("Full", "The call center is full.");
			} else {
				PopUp.display("Not Full", "The call center is not full");
			}
		});

		checkEmptyButton.setOnAction(event1 -> {
			if(center.isEmpty()){
				PopUp.display("Empty", "The call center is empty");
			} else {
				PopUp.display("Not Empty", "The call center is not empty");
			}
		});
		detailsButton.setOnAction(event1 -> {
			DetailsMenu.display();
		});

		closeButton.setOnAction(event -> {
			boolean check = AlertBox.display(exitTitle, exitMessage);
			if(check) {
				closeProgram(0);
			}
		});

		GridPane.setConstraints(mainLabel, 0, 1);
		GridPane.setConstraints(addLabel, 0, 2);
		GridPane.setConstraints(addButton, 1, 2);
		GridPane.setConstraints(removeLabel, 0, 3);
		GridPane.setConstraints(removeButton, 1, 3);
		GridPane.setConstraints(listAllLabel, 0, 4);
		GridPane.setConstraints(listAllButton, 1, 4);
		GridPane.setConstraints(updateStatusLabel, 0, 5);
		GridPane.setConstraints(updateStatusButton, 1, 5);
		GridPane.setConstraints(checkFullLabel, 0, 6);
		GridPane.setConstraints(checkFullButton, 1, 6);
		GridPane.setConstraints(checkEmptyLabel, 0, 7);
		GridPane.setConstraints(checkEmptyButton, 1, 7);
		GridPane.setConstraints(detailsLabel, 0, 8);
		GridPane.setConstraints(detailsButton, 1, 8);
		GridPane.setConstraints(closeButton, 1, 12);

		mainLayout = new GridPane();
		mainLayout.getChildren().addAll(mainLabel, addButton, listAllButton, closeButton, removeButton,
				addLabel, listAllLabel, removeLabel, updateStatusLabel, updateStatusButton, checkEmptyButton,
				checkEmptyLabel, checkFullButton, checkFullLabel, detailsButton, detailsLabel);
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

	public static boolean getFromCenter(String idIn)
	{
		Call callRequested = center.getItem(idIn);
		if(callRequested == null){
			return false;
		}
		return true;
	}

	public static boolean statusUpdate(String idIn, String status)
	{
		if(center.updateStatus(idIn, status)){
			return true;
		}
		return false;
	}
}
