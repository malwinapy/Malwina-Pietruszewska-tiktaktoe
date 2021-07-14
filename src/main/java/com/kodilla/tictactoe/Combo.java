package com.kodilla.tictactoe;

public class Combo {
    public Tile[] tiles;
    public Combo(Tile... tiles) {
        this.tiles = tiles;
    }

    public boolean isComplete() {
        if (tiles[0].getValue().isEmpty())
            return false;

        return tiles[0].getValue().equals(tiles[1].getValue())
                && tiles[0].getValue().equals(tiles[2].getValue());
    }
    public int countX() {
        int count = 0;
        for(int i=0;i<3;i++)
        {
            if(tiles[i].getValue()=="X")
            {
                count++;
            }
        }
        return count;
    }
    public int countO() {
        int count = 0;
        for(int i=0;i<3;i++)
        {
            if(tiles[i].getValue()=="O")
            {
                count++;
            }
        }
        return count;
    }

}