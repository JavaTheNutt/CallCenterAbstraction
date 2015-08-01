import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddCallGui
{
	private static String callId;
	private static int numMinutes;
	private static String callStatus;
	private static boolean callBackCustomer;
	private static String callAnsweredBy;
	private static int customerSatisfactionRating;
	private static String callType;

	private static TextField callIdInput;
	private static TextField numMinutesInput;
	private static ChoiceBox<String> callStatusInput;
	private static CheckBox callbackCustomerInput;
	private static TextField callAnsweredByInput;
	private static ChoiceBox<Integer> customerSatisfactionRatingInput;




	public static void display(String typeIn)
	{
		callType = typeIn;
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a call");
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

		Label topLabel = new Label("Add a Call");
		GridPane.setConstraints(topLabel, 1, 0);

		Label callIdLabel = new Label("Call Id:");
		GridPane.setConstraints(callIdLabel, 0, 1);

		callIdInput = new TextField();
		GridPane.setConstraints(callIdInput, 1, 1);

		Label numMinutesLabel = new Label("Length of call:");
		GridPane.setConstraints(numMinutesLabel, 0, 2);

		numMinutesInput = new TextField();
		GridPane.setConstraints(numMinutesInput, 1, 2);

		Label callStatusLabel = new Label("Call Status(open, pending, closed):");
		GridPane.setConstraints(callStatusLabel, 0, 3);

		callStatusInput = new ChoiceBox();
		callStatusInput.getItems().addAll("Open", "Pending", "Closed");
		callStatusInput.setValue("Open");
		GridPane.setConstraints(callStatusInput, 1, 3);

		Label callbackCustomerLabel = new Label("Does the customer require a call back?:");
		GridPane.setConstraints(callbackCustomerLabel, 0, 4);

		callbackCustomerInput = new CheckBox();
		GridPane.setConstraints(callbackCustomerInput, 1, 4);

		Label callAnsweredByLabel = new Label("Call Answered By:");
		GridPane.setConstraints(callAnsweredByLabel, 0, 5);

		callAnsweredByInput = new TextField();
		GridPane.setConstraints(callAnsweredByInput, 1, 5);

		Label customerSatisfactionRatingLabel = new Label("Customer Satisfaction Rating(1-5):");
		GridPane.setConstraints(customerSatisfactionRatingLabel, 0, 6);

		customerSatisfactionRatingInput = new ChoiceBox();
		customerSatisfactionRatingInput.getItems().addAll(1, 2, 3, 4, 5);
		customerSatisfactionRatingInput.setValue(5);
		GridPane.setConstraints(customerSatisfactionRatingInput, 1, 6);

		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 0, 10);
		Button exit = new Button("Exit");
		GridPane.setConstraints(exit, 1, 10);

		submit.setOnAction(event -> {
			boolean check = validateInput();
			if(check)
			{
				if(callType.equals("Sales"))
				{
					SalesCall salesCall = new SalesCall(callId, numMinutes, callStatus, callBackCustomer, callAnsweredBy, customerSatisfactionRating, callType, "hgdhsgd", 45);
					System.out.println(salesCall.toString());
				}
			}

		});
		exit.setOnAction(event -> {
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check)
			{
				Main.closeProgram(0);
			}
		});

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		layout.getChildren().addAll(topLabel, callIdInput, callIdLabel, numMinutesInput, numMinutesLabel, callStatusLabel, callStatusInput, submit, exit, callbackCustomerLabel, callbackCustomerInput, callAnsweredByLabel, callAnsweredByInput, customerSatisfactionRatingLabel,  customerSatisfactionRatingInput);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	private static  boolean validateInput()
	{
		boolean check;
		callStatus = callStatusInput.getValue();
		customerSatisfactionRating = customerSatisfactionRatingInput.getValue();
		if(callIdInput.getText().trim().length() > 0)
		{
			callId = callIdInput.getText();
		}
		else
		{
			System.out.println("Please enter a call ID");
			return false;
		}

		if(callAnsweredByInput.getText().trim().length() > 0)
		{
			callAnsweredBy = callAnsweredByInput.getText();
		}
		else
		{
			System.out.println("Please enter the person who answered the call");
			return false;
		}
		if(isInt(numMinutesInput, numMinutesInput.getText()))
		{
			numMinutes = Integer.parseInt(numMinutesInput.getText());
		}
		else
		{
			System.out.println("Please enter a number for the length of the call.");
			return false;
		}

		if(callbackCustomerInput.isSelected())
		{
			callBackCustomer = true;
		}
		else
		{
			callBackCustomer = false;
		}
		return true;
	}
	private static boolean isInt(TextField input, String message)
	{
		try
		{
			int length = Integer.parseInt(message);
			System.out.println("Pass");
			return true;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Fail");
			return false;
		}
	}

}
