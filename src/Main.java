import javafx.application.Application;
import javafx.collections.ObservableList;
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

	GridPane mainLayout;
	public static void main (String[] args)
	{
		SalesCall call01 = new SalesCall("#437436hfd", 23, "open", true, "Joe Wemyss", 5, "Sales", "#044234", 25.12);
		SalesCall call03 = new SalesCall("#437436hfd", 23, "open", true, "Joe Wemyss", 5, "Sales", "#044234", 25.12);
		SalesCall call04 = new SalesCall("#437436hfd", 23, "open", true, "Joe Wemyss", 5, "Sales", "#044234", 25.12);
		SalesCall call05 = new SalesCall("#437436hfd", 23, "open", true, "Joe Wemyss", 5, "Sales", "#044234", 25.12);
		SalesCall call06 = new SalesCall("#437436hfd", 23, "open", true, "Joe Wemyss", 5, "Sales", "#044234", 25.12);
		SupportCall call02 = new SupportCall("##09iiklkjd", 10, "pending", false, "Michelle Power", 3, "Support", "#99653", "0000009899");
		SupportCall call07 = new SupportCall("##09iiklkjd", 10, "pending", false, "Michelle Power", 3, "Support", "#99653", "0000009899");
		SupportCall call08 = new SupportCall("##09iiklkjd", 10, "pending", false, "Michelle Power", 3, "Support", "#99653", "0000009899");
		SupportCall call09 = new SupportCall("##09iiklkjd", 10, "pending", false, "Michelle Power", 3, "Support", "#99653", "0000009899");
		SupportCall call10 = new SupportCall("##09iiklkjd", 10, "pending", false, "Michelle Power", 3, "Support", "#99653", "0000009899");

		center.addCall(call01);
		center.addCall(call03);
		center.addCall(call04);
		center.addCall(call05);
		center.addCall(call06);
		center.addCall(call07);
		center.addCall(call08);
		center.addCall(call09);
		center.addCall(call10);
		center.addCall(call02);
		launch(args);

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

		Label mainLabel = new Label("Call Center System");
		Label addLabel = new Label("Add a call");
		Label removeLabel = new Label("Remove a call");
		Label updateStatusLabel = new Label("Update call status");
		Label checkFullLabel = new Label("Check if the call list is full");
		Label checkEmptyLabel = new Label("Check if the call list is empty");
		Label listAllLabel = new Label("List all calls");
		Label detailsLabel = new Label("Call Details");
		Label updateSuggestedLabel = new Label("Update suggested Length of calls");


		Button addButton = new Button("Go");
		Button removeButton = new Button("Go");
		Button updateStatusButton = new Button("Go");
		Button checkFullButton = new Button("Go");
		Button checkEmptyButton = new Button("Go");
		Button closeButton = new Button("Go");
		Button listAllButton = new Button("Go");
		Button detailsButton = new Button("Go");
		Button updateSuggestedButton = new Button("Go");

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
			TableList.display("All Calls", getAllFromCenter());
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

		updateSuggestedButton.setOnAction(event1 -> UpdateSuggestedGui.display());
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
		GridPane.setConstraints(updateSuggestedLabel, 0, 9);
		GridPane.setConstraints(updateSuggestedButton, 1, 9);
		GridPane.setConstraints(closeButton, 1, 12);

		mainLayout = new GridPane();
		mainLayout.getChildren().addAll(mainLabel, addButton, listAllButton, closeButton, removeButton,
				addLabel, listAllLabel, removeLabel, updateStatusLabel, updateStatusButton, checkEmptyButton,
				checkEmptyLabel, checkFullButton, checkFullLabel, detailsButton, detailsLabel, updateSuggestedLabel, updateSuggestedButton);
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
		if(center.addCall(callIn)) {
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

	public static String listAll()
	{
		String list = center.listAll();
		return list;
	}
	public static String callToString(String idIn)
	{
		String list;
		Call callRequested = center.getItem(idIn);
		list = callRequested.toString();
		return list;
	}
	public static Call getLongest()
	{
		return center.longestCall();
	}
	public static Call getShortest()
	{
		return center.shortestCall();
	}
	public static String aboveSuggested()
	{
		if(center.listCallsAboveSuggestedLength().trim().length() > 0){
			return center.listCallsAboveSuggestedLength();
		}
		return "No calls above suggestedLength";
	}
	private static ObservableList<Call> getAllFromCenter()
	{
		return center.getCalls();
	}
	public static boolean statusUpdate(String idIn, String status)
	{
		if(center.updateStatus(idIn, status)){
			return true;
		}
		return false;
	}
	public static CallCenter getCenter()
	{
		return center;
	}
}
