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
	private static String itemRef;
	private static double price;
	private static String error;
	private static String ticketNo;

	private static TextField callIdInput;
	private static TextField numMinutesInput;
	private static ChoiceBox<String> callStatusInput;
	private static CheckBox callbackCustomerInput;
	private static TextField callAnsweredByInput;
	private static ChoiceBox<Integer> customerSatisfactionRatingInput;
	private static TextField itemRefInput;
	private static TextField priceInput;
	private static TextField errorInput;
	private static TextField ticketNoInput;


	public static void display(String typeIn)
	{
		callType = typeIn;
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a " + callType + " call");
		window.setMinWidth(250);
		window.setMinHeight(300);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}

		});

		Label topLabel = new Label("Add a Call");
		GridPane.setConstraints(topLabel, 1, 0);

		Label callIdLabel = new Label("Call Id:");
		GridPane.setConstraints(callIdLabel, 1, 1);

		callIdInput = new TextField();
		GridPane.setConstraints(callIdInput, 2, 1);

		Label numMinutesLabel = new Label("Length of call:");
		GridPane.setConstraints(numMinutesLabel, 1, 2);

		numMinutesInput = new TextField();
		GridPane.setConstraints(numMinutesInput, 2, 2);

		Label callStatusLabel = new Label("Call Status(open, pending, closed):");
		GridPane.setConstraints(callStatusLabel, 1, 3);

		callStatusInput = new ChoiceBox();
		callStatusInput.getItems().addAll("Open", "Pending", "Closed");
		callStatusInput.setValue("Open");
		GridPane.setConstraints(callStatusInput, 2, 3);

		Label callbackCustomerLabel = new Label("Does the customer require a call back?:");
		GridPane.setConstraints(callbackCustomerLabel, 1, 4);

		callbackCustomerInput = new CheckBox();
		GridPane.setConstraints(callbackCustomerInput, 2, 4);

		Label callAnsweredByLabel = new Label("Call Answered By:");
		GridPane.setConstraints(callAnsweredByLabel, 1, 5);

		callAnsweredByInput = new TextField();
		GridPane.setConstraints(callAnsweredByInput, 2, 5);

		Label customerSatisfactionRatingLabel = new Label("Customer Satisfaction Rating(1-5):");
		GridPane.setConstraints(customerSatisfactionRatingLabel, 1, 6);

		customerSatisfactionRatingInput = new ChoiceBox();
		customerSatisfactionRatingInput.getItems().addAll(1, 2, 3, 4, 5);
		customerSatisfactionRatingInput.setValue(5);
		GridPane.setConstraints(customerSatisfactionRatingInput, 2, 6);

		Label itemRefLabel = new Label("Item reference number (Sales only):");
		GridPane.setConstraints(itemRefLabel, 1, 7);

		itemRefInput = new TextField();
		GridPane.setConstraints(itemRefInput, 2, 7);

		Label priceLabel = new Label("Price (Sales Only):");
		GridPane.setConstraints(priceLabel, 1, 8);

		priceInput = new TextField();
		GridPane.setConstraints(priceInput, 2, 8);

		Label errorLabel = new Label("Error Code (Support Only):");
		GridPane.setConstraints(errorLabel, 1, 9);

		errorInput = new TextField();
		GridPane.setConstraints(errorInput, 2, 9);

		Label ticketNoLabel = new Label("Ticket Number (Support Only):");
		GridPane.setConstraints(ticketNoLabel, 1, 10);

		ticketNoInput = new TextField();
		GridPane.setConstraints(ticketNoInput, 2, 10);

		Button back = new Button("Back");
		GridPane.setConstraints(back, 0, 11);
		Button submit = new Button("Submit");
		GridPane.setConstraints(submit, 1, 11);
		Button exit = new Button("Exit");
		GridPane.setConstraints(exit, 2, 11);

		back.setOnAction(event1 -> {
			boolean check = AlertBox.display("Confirm back", "If you go back, data you entered may be lost. Continue?");
			if(check) {
				window.close();
			}
		});

		submit.setOnAction(event -> {
			boolean check = validateInput();
			boolean isAdded;
			if(check) {
				if(callType.equals("Sales")) {
					SalesCall salesCall = new SalesCall(callId, numMinutes, callStatus, callBackCustomer, callAnsweredBy, customerSatisfactionRating, callType, itemRef, price);
					isAdded = Main.addToCenter(salesCall);
					if(isAdded){
						PopUp.display("Success", "Sales call added successfully");
						window.close();
					}
					else{
						PopUp.display("Failed", "Failed to add call");
					}
				} else {
					SupportCall supportCall = new SupportCall(callId, numMinutes, callStatus, callBackCustomer, callAnsweredBy, customerSatisfactionRating, callType, error, ticketNo);
					isAdded = Main.addToCenter(supportCall);
					if(isAdded){
						PopUp.display("Success", "Support call added successfully");
						window.close();
					}
					else{
						PopUp.display("Failed", "Failed to add call");
					}
				}
			} else{
				PopUp.display("Failed", "Failed to add call");
			}
		});
		exit.setOnAction(event -> {
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});

		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		layout.getChildren().addAll(topLabel, callIdInput, callIdLabel, numMinutesInput, numMinutesLabel, callStatusLabel, callStatusInput,
				submit, exit, callbackCustomerLabel, callbackCustomerInput, callAnsweredByLabel, callAnsweredByInput, customerSatisfactionRatingLabel,
				customerSatisfactionRatingInput, itemRefLabel, itemRefInput, priceLabel, priceInput, errorLabel, errorInput, ticketNoLabel, ticketNoInput, back);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

	private static boolean validateInput()
	{
		callStatus = callStatusInput.getValue();
		customerSatisfactionRating = customerSatisfactionRatingInput.getValue();
		if(callIdInput.getText().trim().length() > 0) {
			callId = callIdInput.getText();
		} else {
			System.out.println("Please enter a call ID");
			return false;
		}

		if(callAnsweredByInput.getText().trim().length() > 0) {
			callAnsweredBy = callAnsweredByInput.getText();
		} else {
			System.out.println("Please enter the person who answered the call");
			return false;
		}
		if(isInt(numMinutesInput, numMinutesInput.getText())) {
			numMinutes = Integer.parseInt(numMinutesInput.getText());
		} else {
			System.out.println("Please enter a number for the length of the call.");
			return false;
		}
		if(callType.equals("Sales")) {
			if(errorInput.getText().trim().length() > 0) {
				System.out.println("Error field not required for sales call");
				return false;
			}
			if(ticketNoInput.getText().trim().length() > 0) {
				System.out.println("Ticket number field not required for sales call");
				return false;
			}
			if(itemRefInput.getText().trim().length() > 0) {
				itemRef = itemRefInput.getText();
			} else {
				System.out.println("Please enter an item reference number.");
				return false;
			}
			if(priceInput.getText().trim().length() > 0) {
				if(isDouble(priceInput, priceInput.getText())) {
					price = Double.parseDouble(priceInput.getText());
				} else {
					System.out.println("Please enter a valid number for price");
					return false;
				}
			} else {
				System.out.println("Please enter a value for the price field");
				return false;
			}
		} else if(callType.equals("Support")) {
			if(itemRefInput.getText().trim().length() > 0) {
				System.out.println("Item reference number not required for support call");
				return false;
			}
			if(priceInput.getText().trim().length() > 0) {
				System.out.println("Price field not required for support call");
				return false;
			}
			if(errorInput.getText().trim().length() > 0) {
				error = errorInput.getText();
			} else {
				System.out.println("Please enter an error code");
				return false;
			}
			if(ticketNoInput.getText().trim().length() > 0) {
				ticketNo = ticketNoInput.getText();
			} else {
				System.out.println("Please enter the ticket number");
				return false;
			}
		}
		if(callbackCustomerInput.isSelected()) {
			callBackCustomer = true;
		} else {
			callBackCustomer = false;
		}
		return true;
	}

	private static boolean isInt(TextField input, String message)
	{
		try {
			int length = Integer.parseInt(message);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Fail");
			return false;
		}
	}

	private static boolean isDouble(TextField input, String message)
	{
		try {
			double priceIn = Double.parseDouble(message);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Fail");
			return false;
		}
	}
}











