package com.kodilla.tictactoe;

        import javafx.application.Application;

        import javafx.geometry.Pos;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.*;
        import javafx.scene.text.Font;
        import javafx.stage.Stage;

public class Main extends Application {

    public static boolean playable = true;
    public static boolean turnX = true;
    public static Label computerScore = new Label("Computer Score: 0");
    public static Label userScore = new Label("Your Score: 0");
    public static Label draws = new Label("Draw: 0");

    public static Pane root = new Pane();

    private Parent createContent() {
        root.setPrefSize(850, 600);


        //Add score and button

        computerScore.setFont(new Font("Arial", 20));
        userScore.setFont(new Font("Arial", 20));
        draws.setFont(new Font("Arial", 20));
        Button resetButton = new Button("New Game");
        resetButton.setFont(new Font("Arial", 20));
        VBox controlPanel = new VBox(5);
        resetButton.setOnMouseClicked(event -> {
            Game.reset();
        });
        controlPanel.setLayoutX(650);
        controlPanel.setLayoutY(100);
        controlPanel.getChildren().add(userScore);
        controlPanel.getChildren().add(computerScore);
        controlPanel.getChildren().add(draws);
        controlPanel.getChildren().add(resetButton);
        controlPanel.setAlignment(Pos.CENTER);
        root.getChildren().add(controlPanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);

                Game.tile[j][i] = tile;
            }
        }

        // horizontal
        for (int i = 0; i < 3; i++) {
            Game.combos.add(new Combo(Game.tile[0][i], Game.tile[1][i], Game.tile[2][i]));
        }

        // vertical
        for (int x = 0; x < 3; x++) {
            Game.combos.add(new Combo(Game.tile[x][0], Game.tile[x][1], Game.tile[x][2]));
        }

        // diagonals
        Game.combos.add(new Combo(Game.tile[0][0], Game.tile[1][1], Game.tile[2][2]));
        Game.combos.add(new Combo(Game.tile[2][0], Game.tile[1][1], Game.tile[0][2]));

        return root;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Tic-Tac-Toe");
        Game.reset();
        primaryStage.show();
    }


    public static void playWinAnimation(Combo combo) {
        combo.tiles[0].setStyle("-fx-background-color: #08c2f1;");
        combo.tiles[1].setStyle("-fx-background-color: #08c2f1;");
        combo.tiles[2].setStyle("-fx-background-color: #08c2f1;");
    }




    public static void main(String[] args) {
        launch(args);
    }
}