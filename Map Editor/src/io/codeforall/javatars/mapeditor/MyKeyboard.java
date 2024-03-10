package io.codeforall.javatars.mapeditor;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
public class MyKeyboard implements KeyboardHandler{

    private Keyboard keyboard = new Keyboard(this);
    private Field square;

    public MyKeyboard(Field square){
        this.square = square;
    }
    public void addKeyboard(){
        //move right
        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRight);
        //move left
        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeft);
        //move Up
        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);
        //move Down
        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown);
        //P paint
        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_P); //key 80
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);
        //F exit
        KeyboardEvent exit = new KeyboardEvent();
        exit.setKey(KeyboardEvent.KEY_F); //key 70
        exit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(exit);
    }
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();
        if(key == 39) {
            square.moveRight();
        }
        if(key == 37){
            square.moveLeft();
        }
        if(key == 38){
            square.moveUp();
        }
        if(key == 40){
            square.moveDown();
        }
        if(key == 80){
            square.paint();
            square.removePaint();
        }
        if(key == 70){
            System.exit(0);
        }
    }
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
