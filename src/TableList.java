import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class TableList
{
	private static TableView<Call> table = new TableView<>();

	public static void display(String title, ObservableList<Call> list)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setOnCloseRequest(event1 -> {
			event1.consume();
			boolean check = AlertBox.display(Main.getExitTitle(), Main.getExitMessage());
			if(check) {
				Main.closeProgram(0);
			}
		});
		window.setMinWidth(600);

		TableColumn<Call, String> callIdColumn = new TableColumn<>("Call Id");
		callIdColumn.setMinWidth(100);
		callIdColumn.setCellValueFactory(new PropertyValueFactory<>("callId"));

		TableColumn<Call, Integer> numMinutesColumn = new TableColumn<>("Call Length");
		numMinutesColumn.setMinWidth(50);
		numMinutesColumn.setCellValueFactory(new PropertyValueFactory<>("numMinutes"));

		TableColumn<Call, String> callStatusColumn = new TableColumn<>("Call Status");
		callStatusColumn.setMinWidth(50);
		callStatusColumn.setCellValueFactory(new PropertyValueFactory<>("callStatus"));

		TableColumn<Call, Boolean> callBackCustomerColumn = new TableColumn<>("Does the customer require a call back?");
		callBackCustomerColumn.setMinWidth(50);
		callBackCustomerColumn.setCellValueFactory(new PropertyValueFactory<>("callBackCustomer"));

		TableColumn<Call, String> callAnsweredByColumn = new TableColumn<>("Agent Name");
		callAnsweredByColumn.setMinWidth(80);
		callAnsweredByColumn.setCellValueFactory(new PropertyValueFactory<>("callAnsweredBy"));

		TableColumn<Call, Integer> customerSatisfactionRatingColumn = new TableColumn<>("Rating");
		customerSatisfactionRatingColumn.setMinWidth(50);
		customerSatisfactionRatingColumn.setCellValueFactory(new PropertyValueFactory<>("customerSatisfactionRating"));

		TableColumn<Call, Integer> callTypeColumn = new TableColumn<>("Call Type");
		callTypeColumn.setMinWidth(50);
		callTypeColumn.setCellValueFactory(new PropertyValueFactory<>("callType"));

		table.setItems(list);
		table.getColumns().addAll(callIdColumn, numMinutesColumn, callStatusColumn, callBackCustomerColumn, callAnsweredByColumn, customerSatisfactionRatingColumn, callTypeColumn);

		VBox layout = new VBox(20);
		layout.getChildren().addAll(table);
		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.showAndWait();
	}
}
