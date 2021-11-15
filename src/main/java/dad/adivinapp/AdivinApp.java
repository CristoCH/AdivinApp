package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class AdivinApp extends Application {
    private Label introducirLabel;
    private Button comprobarButton;
    private VBox rootPanel;
    private TextField numeroText;

    private Random random = new Random();
    private int aleatorio;
    private int contador = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        aleatorio = random.nextInt(100);

        introducirLabel = new Label();
        introducirLabel.setText("Introduce un número del 1 al 100");
        introducirLabel.setAlignment(Pos.CENTER);

        numeroText = new TextField();
        numeroText.setMaxWidth(150);


        comprobarButton = new Button();
        comprobarButton.setText("Comprobar");
        comprobarButton.setOnAction(e -> onComprobarButtonAction(e));


        rootPanel = new VBox();
        rootPanel.setSpacing(15);
        rootPanel.setAlignment(Pos.CENTER);
        rootPanel.getChildren().addAll(introducirLabel, numeroText, comprobarButton);

        Scene scene = new Scene(rootPanel, 320, 200);

        primaryStage.setTitle("AdivinApp");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    private void onComprobarButtonAction(ActionEvent e){

        String num = numeroText.getText();
        System.out.println(aleatorio);

        if(numeroText.getText().matches("[a-zA-Z]+")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("Error");
            alert.setContentText("El número introducido no es válido.");

            alert.showAndWait();

        }else if (numeroText.getText() == null || numeroText.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("Error");
            alert.setContentText("El número introducido no es válido.");

            alert.showAndWait();

        }else if(Integer.parseInt(num)<0 || Integer.parseInt(num) >100){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("Error");
            alert.setContentText("El número introducido no es válido.");

            alert.showAndWait();

        }else if(Integer.parseInt(num)<aleatorio){
            contador++;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("¡Has fallado!");
            alert.setContentText("El numero a adivinar es mayor que "+num+"."
                    +"\rVuelve a intentarlo.");


            alert.showAndWait();

        }else if (Integer.parseInt(num)>aleatorio) {
            contador++;
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("¡Has fallado!");
            alert.setContentText("El numero a adivinar es menor que " + num + "."
                    + "\rVuelve a intentarlo.");

            alert.showAndWait();

        }else{
            contador++;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("¡Has ganado!");
            alert.setContentText("Solo has necesitado "+contador+" intentos." +
                    "\rVuelve a jugar y hazlo mejor.");

            alert.showAndWait();
        }
    }
}

