package loginDialogDemo;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class LoginDialog extends Dialog<Pair<String,String>>{
	TextField tfUser;
	PasswordField pfSenha;
	int userNameMaxLenght;
	int passwordMaxLenght;
	Button bLogin,bCancel;
	
	public LoginDialog(int userMaxLenght,int passMaxLenght){
		this.userNameMaxLenght = userMaxLenght;
		this.passwordMaxLenght = passMaxLenght;
		
		createGui();
		
		//Request focus on the username field by default
		Platform.runLater(()->tfUser.requestFocus());
	}
	public void createGui(){
		//Create the custo dialog.
		super.setTitle("Login Dialog");
		super.setHeaderText(null);
		// Set the icon (must be included in the project
		super.setGraphic(new ImageView(getClass().getResource("img/login.jpg").toString()));
		
		//controlos
		ButtonType btLogin = new ButtonType("Login",ButtonData.OK_DONE);
		ButtonType btCancel = new ButtonType("Cancelar",ButtonData.CANCEL_CLOSE);
		
		super.getDialogPane().getButtonTypes().addAll(btLogin,btCancel);
		bLogin = (Button) super.getDialogPane().lookupButton(btLogin);
		bCancel = (Button) super.getDialogPane().lookupButton(btCancel);
		
		tfUser = new TextField();
		tfUser.setPromptText("login");
		Label lUser = new Label("Usuario: ");
		lUser.setLabelFor(tfUser);
		
		pfSenha = new PasswordField();
		pfSenha.setPromptText("password");
		Label lpass = new Label("Senha: ");
		lpass.setLabelFor(pfSenha);
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.add(lUser,0,0);
		grid.add(tfUser,1,0);
		
		
		grid.add(bLogin,0,1);
		
		grid.add(bCancel, 1, 1);
		
		
		super.getDialogPane().setContent(grid);
		
		
	}
}
