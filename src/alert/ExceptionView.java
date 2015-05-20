package alert;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ExceptionView extends GridPane
{
   private TextArea textArea;
   private Label label;
   
   public ExceptionView(String title, Exception e)
   {
	   init (title);
	   setException(e);
   }
   private void init(String title)
   {
      label = new Label(title);
      textArea = new TextArea("Exception:");
      textArea.setEditable(false);
      textArea.setWrapText(true);
      textArea.setMaxWidth(Double.MAX_VALUE);
      textArea.setMaxHeight(Double.MAX_VALUE);

      super.setVgrow(textArea, Priority.ALWAYS);
      super.setHgrow(textArea, Priority.ALWAYS);

      super.setMaxWidth(Double.MAX_VALUE);
      super.add(label, 0, 0);
      super.add(textArea, 0, 1);
   }
   public void setException(Exception e)
   {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      textArea.setText(sw.toString());
   }
}
