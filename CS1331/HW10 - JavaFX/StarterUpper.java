/*I worked on the homework assignment alone, using only course materials*/
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Collections;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import java.io.File;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
/**
 *StarterUpper Class
 *@author JhaDeya Rhymes
 *@version 1.0
 **/
public class StarterUpper extends Application {
    /**
      *main method
      *@param args takes in string argument
      */
    public static void main(String[] args) {
        launch(args);
    }
    /**
      *sets up stage
      *@param mainStage takes in stage object
     **/
    public void start(Stage mainStage) {
        mainStage.setTitle("Problem Ideation Form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Hello, I'm glad you are interested in launching a startup.");
        scenetitle.setFont(Font.font("Comic Sans", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0);
        Label n = new Label("Jha'Deya Rhymes");
        grid.add(n, 0, 1);

        Label question2 = new Label("What is the problem?");
        grid.add(question2, 0, 2);
        TextField problem = new TextField();
        grid.add(problem, 1, 2);

        Label q3 = new Label("Who is the target customer");
        grid.add(q3, 0, 3);
        TextField targetCustomer = new TextField();
        grid.add(targetCustomer, 1, 3);

        Label q4 = new Label("How badly does the customer NEED this problem fixed (1-10)?");
        grid.add(q4, 0, 4);
        TextField customerNeed = new TextField();
        grid.add(customerNeed, 1, 4);

        Label q5 = new Label("How many people do you know who might experience this problem?");
        grid.add(q5, 0, 5);
        TextField knownPeopleWithProblem = new TextField();
        grid.add(knownPeopleWithProblem, 1, 5);

        Label q6 = new Label("How big is the target market?");
        grid.add(q6, 0, 6);
        TextField targetMarketSize = new TextField();
        grid.add(targetMarketSize, 1, 6);

        Label q7 = new Label("Who are the competitors/existing solutions?");
        grid.add(q7, 0, 7);
        TextField competitors = new TextField();
        grid.add(competitors, 1, 7);

        Label q8 = new Label("How long will it take to actually begin making a profit?");
        grid.add(q8, 0, 8);
        TextField profit = new TextField();
        grid.add(profit, 1, 8);

        List<StartUpIdea> list = new ArrayList<StartUpIdea>();

        //list.add(idea);
        HBox buttons = new HBox(10);
        // hboxName.getChildren().addAll(btn1, btn2, btn3, btn4);
        // OR
        // hboxName.getChildren().add(btn1);
        // hboxName.getChildren().add(btn2);
        // etc.
        // add to list
        Button btn1 = new Button();
        btn1.setText("Add to List");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                try {
                    String ptext = problem.getText();
                    String ctext = targetCustomer.getText();
                    int ppltext = Integer.parseInt(knownPeopleWithProblem.getText());
                    int ntext = Integer.parseInt(customerNeed.getText());
                    int mtext = Integer.parseInt(targetMarketSize.getText());
                    int protext = Integer.parseInt(profit.getText());
                    if (ppltext < 0 || ntext < 0 || mtext < 0 || protext < 0) {
                        throw new NumberFormatException();
                    }
                    String comtext = competitors.getText();
                    if (ptext.equals("") || ctext.equals("") || comtext.equals("")) {
                        throw new IllegalArgumentException();
                    }
                    StartUpIdea idea = new StartUpIdea(ptext, ctext, ntext, ppltext, mtext, comtext, protext);
                    list.add(idea);
                } catch (IllegalArgumentException nfe) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setHeaderText("Invalid Type");
                    a.setContentText("Please make sure an appropriate string or integer is typed.");
                    a.showAndWait();
                }
            }
        });

        //sorts list
        Button btn2 = new Button();
        btn2.setText("Sort List");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                Collections.sort(list);
            }
        });

        Button btn3 = new Button();
        btn3.setText("Clear Form");
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                //new Alert(Alert.AlertType)
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to clear your form?");
                confirm.showAndWait();
                if (confirm.getResult() == ButtonType.OK) {
                    problem.clear();
                    targetCustomer.clear();
                    customerNeed.clear();
                    knownPeopleWithProblem.clear();
                    targetMarketSize.clear();
                    competitors.clear();
                    profit.clear();
                    File idea = new File("ideas.txt");
                    if (idea.exists()) {
                        idea.delete();
                    }
                }
            }
        });

        Button btn4 = new Button();
        btn4.setText("Save Idea");
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                File idea = new File("ideas.txt");
                FileUtil.saveIdeasToFile(list, idea);
            }

        });
        btn4.setOnAction(event -> {
                File idea = new File("ideas.txt");
                FileUtil.saveIdeasToFile(list, idea);
            });
        buttons.getChildren().addAll(btn1, btn2, btn3, btn4);
        grid.add(buttons, 0, 9);
        Scene scene = new Scene(grid, 800, 600);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
