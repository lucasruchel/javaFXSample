package labelDemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelDemo extends Application {
    Label lSearch;
    Label lValues;
    Label lWrapped;

    public LabelDemo()
    {
        this.lSearch = new Label("Search");
        Image image = new
                Image(getClass().getResourceAsStream("img/Search.png"));
        this.lSearch.setGraphic(new ImageView(image));
        this.lSearch.setTextFill(Color.web("#0076a3"));
        this.lSearch.setFont(Font.font("Arial", 30));

        this.lValues = new Label("Values");
        this.lValues.setFont(Font.font("Cambria", 32));
        this.lValues.setTranslateX(200);
        this.lValues.setTranslateY(50);
        this.lValues.setRotate(-90);

        this.lWrapped = new Label("A label that needs to be wrapped");
        this.lWrapped.setWrapText(true);
        this.lWrapped.setTranslateX(300);
        this.lWrapped.setTranslateY(50);
        this.lWrapped.setMaxWidth(80);
        this.lWrapped.setTextOverrun(OverrunStyle.CENTER_WORD_ELLIPSIS);

    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Labels");
        Group root  = new Group();

        root.getChildren().add(this.lSearch);
        root.getChildren().add(this.lValues);
        root.getChildren().add(this.lWrapped);

        Scene scene = new Scene(root, 400,150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


