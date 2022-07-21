package application;

import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Exercise15_1 extends Application {
	// declaring the attributes to make them accessible later.
	private GridPane grid;


	@Override
	public void start(Stage primaryStage) {
		// now we create the GridPane for the cards
		grid = new GridPane();
		grid.setPadding(new Insets(3, 3, 3, 3));
		grid.setHgap(5);
		grid.setVgap(5);
	
		//Create the refresh button
		VBox vBox = new VBox();
		  vBox.setSpacing(10);
		  vBox.setAlignment(Pos.CENTER);
		  Button refresh = new Button("Refresh");
		  vBox.getChildren().add(refresh);
		
		// make an instance of our event handler class
		HandHandler deal = new HandHandler();
		// register the handler with the hand button
		refresh.setOnAction(deal);
		
		
		// add button to the first cell in the grid
		grid.add(refresh, 0, 0);
		for (int i = 1; i <= 4; i++) {
			Integer rnd = (int) (Math.random() * 52) + 1;
			String s = rnd.toString();
			ImageView crd = new ImageView(s + ".png");
			grid.add(crd, i, 0);
		}
		
		Scene scene = new Scene(grid, 400, 150);
		primaryStage.setTitle("Exercise15_1"); // Sets the stage title
		primaryStage.setScene(scene); 
		primaryStage.show(); // Displays
	}
	// this is an event handler class 
	///every time the button is pressed, replay the selection of four cards and provide the new random cards to user.
	class HandHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			for (int i = 1; i <= 4; i++) {
				Integer rnd = (int) (Math.random() * 52) + 1;
				String s = rnd.toString();
				ImageView crd = new ImageView(s + ".png");
				grid.add(crd, i, 0);
			}
		}
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}

