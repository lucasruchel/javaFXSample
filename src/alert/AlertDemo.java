package alert;



import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AlertDemo extends Application{
	CheckBox cbInformacao;
	CheckBox cbConfirmacao;
	CheckBox cbAviso;
	
	CheckBox cbErro;
	CheckBox cbNada;
	CheckBox cbCustom;
	
	DropShadow shadow;
	
	Scene scene;
	Group root;
	
	public AlertDemo() {
		root=new Group();
		scene = new Scene(root);
		
		
	}
	
	public void createGui() {
		createControls();
		makeLayout();
		makeAlerts();
	}
	private void makeAlerts()
	{
	 cbInformacao.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	     alert.setTitle( "Alerta informação");
	     alert.setHeaderText("Cabeçalho do Alerta...");
	     alert.setContentText("Informação importante!");
	     alert.showAndWait();
	 });
	 cbAviso.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.WARNING);
	     alert.setTitle( "Alerta de Aviso");
	     alert.setHeaderText("Cabeçalho do Alerta...");
	     alert.setContentText("Informação de Aviso!");
	     alert.showAndWait();
	 });
	 cbErro.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.ERROR);
	     alert.setTitle( "Alerta de Erro");
	     alert.setHeaderText("Cabeçalho do Alerta...");
	     alert.setContentText("Informação de Erro!");
	     alert.showAndWait();
	 });
	/* cbCustom.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.ERROR);
	     alert.setTitle( "Alerta Customizado");
	     alert.setHeaderText("Alerta Customizado");
	     alert.setContentText("Informação Customizada!");
	     

	     
	     
	     alert.showAndWait();
	 }); */
	 cbConfirmacao.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	     alert.setTitle( "Alerta de Confirmação");
	     alert.setHeaderText("Cabeçalho do Alerta...");
	     alert.setContentText("Informação de Confirmação!");
	     alert.showAndWait();
	 });
	 cbNada.setOnAction(ActionEvent->
	 {
	     Alert alert = new Alert(Alert.AlertType.NONE);
	     alert.setTitle( "Alerta de Nada");
	     alert.setHeaderText("Cabeçalho do Alerta...");
	     alert.setContentText("Informação de nada!");
	     alert.showAndWait();
	 });
	 
	 cbCustom.setOnAction((e)->{
		 String string="seuBarriga.png";
		 
		loadFile(string);
	 });
	}
	
	private void makeLayout()
	{
	   //layout
	   BorderPane bp = new BorderPane();
	   
	   
	   bp.setPadding(new Insets(20, 20, 20, 20));

	   BorderPane.setAlignment(cbInformacao, Pos.CENTER);
	   bp.setTop(cbInformacao);
	   
	   
	   
	   bp.setBottom(cbConfirmacao);
	   
	   BorderPane.setAlignment(cbConfirmacao, Pos.CENTER);
	   
	   VBox vb = new VBox();
	   vb.setPadding(new Insets(20, 20, 20, 20));
	   vb.setSpacing(30);
	   vb.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);;
	   bp.setCenter(vb);
	   vb.getChildren().addAll(cbNada,cbCustom);
	   
	   bp.setLeft(cbAviso);
	   cbAviso.setRotate(-90);
	   cbAviso.setTranslateY(50);
	   cbAviso.setBorder(new Border(new BorderStroke(
	             Color.DARKGRAY, BorderStrokeStyle.SOLID, 
	             null, null)));
	   
	   
	   bp.setRight(cbErro);
	   cbErro.setRotate(90);
	   cbErro.setTranslateY(50);
	   cbErro.setBorder(new Border(new BorderStroke(
	             Color.DARKGRAY, BorderStrokeStyle.SOLID, 
	             null, null)));
	   
	   root.getChildren().addAll(bp);
	}
	   

	private CheckBox createCheckBox(String txt, String iconFile){
		Image img = new Image(getClass().getResourceAsStream(iconFile));
		ImageView iv = new ImageView(img);
		iv.setFitHeight(20);
		iv.setPreserveRatio(true);
		CheckBox cb = new CheckBox(txt);
		cb.setGraphic(iv);
		cb.setStyle("-fx-font:22 arial; -fx-base: #b6e7c9;");
		cb.setPrefHeight(20);
		cb.setOnMouseEntered(e->{cb.setEffect(shadow);});
		cb.setOnMouseExited(e->{cb.setEffect(null);});
		
		return cb;
		
	}
	@Override
	public void init() throws Exception {
		createGui();
	}
	private void createControls(){
		shadow = new DropShadow();
		
		cbInformacao = createCheckBox("Alerta de Informacao", "img/information.png");
		cbAviso = createCheckBox("Aviso de Alerta", "img/warning.png");
		cbNada = createCheckBox("Alerta de Nada", "img/nothing.png");
		cbCustom = createCheckBox("alerta Customizado", "img/custom.png");
		cbConfirmacao = createCheckBox("Alerta de Confirmação", "img/confirmation.png");
		cbErro = createCheckBox("Alerta de Erro", "img/error.png");
	}
	private void loadFile(String file)
	{
	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Alerta Customizado");
	    alert.setHeaderText(null);
	    alert.setContentText("Não foi possível carregar o arquivo :"+file);
	    
	    alert.getDialogPane().setExpandableContent(new ExceptionView(
	    	     "Ocorreu a seguinte exceção: ", new FileNotFoundException()));
	    
	    alert.showAndWait();
	    
	  
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("alerts");
		
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args) {
		launch();
	}

}
