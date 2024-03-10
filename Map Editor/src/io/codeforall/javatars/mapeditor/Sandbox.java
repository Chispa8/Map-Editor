package io.codeforall.javatars.mapeditor;

public class Sandbox {

    public static void main(String[] args) {

        Field newGrid = new Field(20,20);
        newGrid.drawRect();
        newGrid.drawField();
        MyKeyboard myKeyboard = new MyKeyboard(newGrid);
        myKeyboard.addKeyboard();
    }
}
