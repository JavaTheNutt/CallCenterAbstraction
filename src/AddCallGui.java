import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddCallGui
{
	private static String callId;
	private static int numMinutes;
	private static String callStatus;
	private static boolean callBackCustomer;
	private static String callAsweredBy;
	private static int customerSatisfactionRating;
	private static int suggestedLengthofCall = 2;
	private static String callType;

	public static void display(String typeIn)
	{
		callType = typeIn;
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Add a call");
		window.setMinWidth(250);
		window.setMinHeight(300);

		Label label = new Label("Add a Call");

		Button submit = new Button("Submit");
		Button exit = new Button("Exit");

		submit.setOnAction(event -> {
			window.close();
		});
		exit.setOnAction(event -> {
			window.close();
		});

		VBox layout = new VBox(20);
		layout.getChildren().addAll(label, submit, exit);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}

}
