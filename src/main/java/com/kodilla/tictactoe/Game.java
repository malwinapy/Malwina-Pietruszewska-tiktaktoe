package com.kodilla.tictactoe;

import java.util.ArrayList;
        import java.util.List;

public class Game {
    public static boolean turnX = true;
    public static boolean playable = true;
    public static int scoreX = 0;
    public static int draw = 0;
    public static int scoreCom = 0;
    public static int round = 0;
    public static Tile[][] tile = new Tile[3][3];
    public static List<Combo> combos = new ArrayList<>();
    public Game()
    {
        playable = true;
        turnX = true;
        scoreX = 0;
        scoreCom = 0;
        draw = 0;
        round = 0;
    }
    public static void checkState() {
        if(!Game.playable) return;
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false;
                Main.playWinAnimation(combo);
                if(combo.tiles[0].getValue() == "X") {
                    scoreX++;
                    Main.userScore.setText("User Score: " + scoreX);
                    return;
                }
                else {
                    scoreCom++;
                    Main.computerScore.setText("Computer Score: " + scoreCom);
                    return;
                }
            }
        }
        round++;
        if(round==9)
        {
            draw++;
            Main.draws.setText("Draws: " + draw);
            playable = false;
        }
    }

    public static void computerChoose() {
        int valX;
        int valO;
        int maxValX=-1;
        int maxValO=-1;
        int maxSecond = -1;
        int check = 0;
        Combo maxX=null;
        Combo maxO=null;
        Combo secondaryChoose=null;
        if(!Game.playable) return;
        for (Combo combo : combos) {
            valX = combo.countX();
            valO = combo.countO();
            if(valX>maxValX) {
                maxValX = valX;
                maxX = combo;
            }
            if(valO>maxValO) {
                maxValO = valO;
                maxO = combo;
            }
            if(valX>valO) {
                secondaryChoose = maxX;
            }
            else {
                secondaryChoose = maxO;
            }
        }
        if(maxValX>maxValO) {
            for(int i=0;i<3;i++) {
                if(maxX.tiles[i].getValue()=="") {
                    maxX.tiles[i].text.setText("O");
                    check = 1;
                    break;
                }
            }
        }
        else {
            for(int i=0;i<3;i++) {
                if (maxO.tiles[i].getValue() == "") {
                    maxO.tiles[i].text.setText("O");
                    System.out.println("need to win");
                    check = 1;
                    break;
                }
            }
            System.out.println("need to win");
        }
        //if max combo is full find somewhere to fill
        if(check==0) {
            for(Tile[] title : tile) {
                for(Tile temp: title) {
                    if(temp.getValue()=="")
                    {
                        temp.text.setText("O");
                        check = 1;
                        break;
                    }
                }
                if(check==1) break;
            }
        }
        System.out.println(maxValX +" "+ maxValO);
        turnX = true;
    }
    public static void reset() {
        for(Tile[] title : tile)
        {
            for(Tile temp: title)
            {
                temp.text.setText("");
                temp.setStyle("-fx-background-color: #FFFFFF;");
            }
        }
        round = 0;
        playable = true;
        turnX = true;
    }

}