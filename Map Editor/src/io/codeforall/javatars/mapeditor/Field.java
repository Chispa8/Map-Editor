package io.codeforall.javatars.mapeditor;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private Rectangle square, field;
    private Rectangle[][] rectangles;
    public static final int PADDING = 10;
    private int cellSize = 15;
    private int cols, rows, valueX, valueY;


    public Field(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void drawField() {
        valueX = PADDING;
        valueY = PADDING;
        this.field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
        this.field.draw();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                Rectangle rect1 = new Rectangle(valueX,valueY,cellSize,cellSize);
                rect1.draw();
                valueX += cellSize;
            }
            valueX = PADDING;
            valueY += cellSize;

        }
    }
    //rectangle inside the grid. in this case, green.
    public void drawRect() {
        square = new Rectangle(10, 10, cellSize, cellSize);
        square.setColor(Color.GREEN);
        square.fill();
    }

    public void moveRight() {
        if (square.getX() + cellSize < field.getX() + field.getWidth()) {
            square.translate(cellSize, 0);
        }
    }

    public void moveLeft() {
        if (square.getX() - cellSize >= field.getX()) {
            square.translate(-cellSize, 0);
        }
    }

    public void moveUp() {
        if (square.getY() - cellSize >= field.getY()) {
            square.translate(0, -cellSize);
        }
    }

    public void moveDown() {
        if (square.getY() + cellSize < field.getY() + field.getHeight()) {
            square.translate(0, cellSize);
        }
    }
    public void paint() {
        // Verifica si ya hay un rectángulo pintado en la posición actual
        if (rectangles[valueX / cellSize][valueY / cellSize] != null) {
            return; // Si ya hay un rectángulo pintado, no hacemos nada
        }

        // Crea un nuevo rectángulo en la posición actual
        Rectangle rect1 = new Rectangle(valueX, valueY, cellSize, cellSize);
        rect1.setColor(Color.RED); // Por ejemplo, aquí estamos pintando el rectángulo de color rojo
        rect1.fill();

        // Almacena el rectángulo en la matriz para futuras referencias
        rectangles[valueX / cellSize][valueY / cellSize] = rect1;
    }

    public void removePaint() {
        // Verifica si hay un rectángulo pintado en la posición actual
        if (rectangles[valueX / cellSize][valueY / cellSize] == null) {
            return; // Si no hay un rectángulo pintado, no hacemos nada
        }

        // Elimina el rectángulo pintado
        rectangles[valueX / cellSize][valueY / cellSize].delete();
        rectangles[valueX / cellSize][valueY / cellSize] = null; // Establece la referencia del rectángulo a null para indicar que ya no está pintado
    }


}
