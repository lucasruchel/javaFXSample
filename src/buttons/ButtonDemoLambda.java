package buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonDemoLambda extends Application {
	private static final Color color = Color.web("#464646");
	Button bAccept0, bAccept1, bAccept2;
	Button bDecline0, bDecline1;
	Label label;
	DropShadow shadow = new DropShadow();
	Scene scene;
	
	public ButtonDemoLambda() {
		createGUI();
		makeEvents();
	}
	private void createGUI() {
		createControls();
		makeLayout();
	}
	private void createControls() {
		Image imageOk = new Image(getClass().getResourceAsStream("img/ok.png"));
		ImageView iv = new ImageView(imageOk);
		iv.setFitHeight(30);
		iv.setPreserveRatio(true);
		bAccept0 = new Button("Accept", iv);
		bAccept0.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9");
		bAccept0.prefHeight(20);
		
		bAccept1 = new Button("Accept");
		
		bAccept2 =  new Button();
		iv.setFitHeight(30);
		iv.setPreserveRatio(true);
		bAccept2.setGraphic(iv);
		
		bDecline0 = new Button("Decline");
		bDecline1 = new Button();
		
		iv = new ImageView(new Image(getClass().getResourceAsStream("img/not.png")));
		
		iv.setFitHeight(30);
		iv.setPreserveRatio(true);
		bDecline1.setGraphic(iv);
		
		label = new Label();
		label.setFont(Font.font("Times New Roman",22));
		label.setTextFill(color);
	}
	private void makeLayout() {
		// LAYOUT
		
		VBox vbox = new VBox();
		vbox.setLayoutX(20);
		vbox.setLayoutY(20);
		vbox.setSpacing(10);
		
		vbox.getChildren().add(bAccept0);
		
		HBox hbox = new HBox();
		vbox.getChildren().add(hbox);
		hbox.getChildren().addAll(bAccept1,bDecline0,label);
		
		hbox.setSpacing(24);
		hbox.setAlignment(Pos.BASELINE_CENTER);
		
		hbox = new HBox();
		vbox.getChildren().add(hbox);
		hbox.getChildren().addAll(bAccept2,bDecline1);
		hbox.setSpacing(30);
		
		Group root = new Group();
		root.getChildren().add(vbox);
		scene = new Scene(root, 300, 100);
	}
	private void makeEvents() {
		bAccept0.setOnAction(this::setTextAccepted);
		bAccept1.setOnAction(this::setTextAccepted);
		bAccept2.setOnAction(this::setTextAccepted);
		
		
		bDecline0.setOnAction(this::setTextDeclined);
		bDecline1.setOnAction(this::setTextDeclined);
		
		bAccept0.setOnMouseEntered(this::setEffectShadow);
		bAccept0.setOnMouseExited(this::setEffectNull);
		
		bAccept1.addEventHandler(MouseEvent.MOUSE_ENTERED, this::setEffectShadow);
		bAccept1.setOnMouseExited(e->{bAccept1.setEffect(null);});

	}
	
	private void setTextAccepted(ActionEvent ae){
		label.setText("Accepted");
	}
	private void setTextDeclined(ActionEvent ae){
		label.setText("Declined");
	}
	private void setEffectShadow(MouseEvent me){
		((Button)me.getSource()).setEffect(shadow);
	}
	private void setEffectNull(MouseEvent me){
		((Button)me.getSource()).setEffect(null);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Buttons");
		
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch();
	}
}