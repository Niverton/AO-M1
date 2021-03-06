package view;

import org.jgrapht.traverse.BreadthFirstIterator;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import model.Directions;
import model.Labyrinth;
import model.graph.Edge;
import model.graph.Graph;
import model.graph.Vertex;

public class ViewLabyrinth extends BaseView {
    protected static final Paint WALLCOLOR = Color.BURLYWOOD;
    protected static final Paint DOORCOLOR = Color.web("25154d");

    private Labyrinth labyrinth;
    private Pane      pane;

    public ViewLabyrinth(Labyrinth b, Pane pane) {
        this.labyrinth = b;
        this.pane = pane;
        pane.autosize();
        SPAN = 4;
    }

    /**
     * Dessiner la fenetre (le cadre).
     */
    public void drawFrame() {
        Rectangle square;
        square = new Rectangle(0, 0, SPAN * (labyrinth.getSize() * (CELL + WALL) + WALL), WALL * SPAN);
        square.setFill(WALLCOLOR);
        pane.getChildren().add(square);
        square = new Rectangle(0, SPAN * (labyrinth.getSize() * (CELL + WALL)),
                SPAN * (labyrinth.getSize() * (CELL + WALL) + WALL), WALL * SPAN);
        square.setFill(WALLCOLOR);
        pane.getChildren().add(square);
        square = new Rectangle(0, 0, WALL * SPAN, SPAN * (labyrinth.getSize() * (CELL + WALL) + WALL));
        square.setFill(WALLCOLOR);
        pane.getChildren().add(square);
        square = new Rectangle(SPAN * (labyrinth.getSize() * (CELL + WALL)), 0, WALL * SPAN,
                SPAN * (labyrinth.getSize() * (CELL + WALL) + WALL));
        square.setFill(WALLCOLOR);
        pane.getChildren().add(square);
        for (int x = 0; x < labyrinth.getSize() - 1; ++x) {
            float offsetX = ((WALL + CELL) + (WALL + CELL) * x) * SPAN;
            for (int y = 0; y < labyrinth.getSize() - 1; ++y) {
                float offsetY = ((WALL + CELL) + (WALL + CELL) * y) * SPAN;
                square = new Rectangle(offsetX, offsetY, WALL * SPAN, WALL * SPAN);
                square.setFill(WALLCOLOR);
                pane.getChildren().add(square);
            }
        }
    }

    /**
     * Dessiner les murs.
     */
    public void drawWallsAndDoor() {
        Graph door = labyrinth.getLabyrinth();
        BreadthFirstIterator<Vertex, Edge> iter = new BreadthFirstIterator<Vertex, Edge>(door);

        while (iter.hasNext()) {
            Vertex v = iter.next();
            for (Directions dir : Directions.values()) {
                boolean isOpenDoor = labyrinth.isOpenDoor(v, dir);
                if (v.inBorders(0, labyrinth.getSize(), dir) && (labyrinth.isWall(v, dir) || isOpenDoor)) {
                    int xs = v.getX();
                    int ys = v.getY();
                    int xt = xs;
                    int yt = ys;
                    switch (dir) {
                        case North:
                            yt--;
                        break;
                        case South:
                            yt++;
                        break;
                        case East:
                            xt++;
                        break;
                        case West:
                            xt--;
                        break;
                    }
                    if (isOpenDoor)
                        drawWall(xs, ys, xt, yt, true);
                    else
                        drawWall(xs, ys, xt, yt, false);
                }
            }
        }
    }

    /**
     * @param xs
     *            abscisse source
     * @param ys
     *            ordonnee source
     * @param xt
     *            abscisse destination
     * @param yt
     *            ordnnees destination
     * @param isDoor
     *            Est ce qu'il s'agit d'une porte ou non 
     */
    public void drawWall(int xs, int ys, int xt, int yt, boolean isDoor) {
        float x = 0, y = 0;
        float xspan = 0, yspan = 0;

        if (ys == yt) {
            x = ((WALL + CELL) + (WALL + CELL) * ((int) (xs + xt) / 2)) * SPAN;
            y = ((WALL + ys * (WALL + CELL)) * SPAN);
            xspan = WALL * SPAN;
            yspan = CELL * SPAN;
            Rectangle square = new Rectangle(x, y, xspan, yspan);
            if (isDoor) {
                square.setRotate((CELL * SPAN));
                square.setFill(DOORCOLOR);
            } else {
                square.setFill(WALLCOLOR);
            }
            pane.getChildren().add(square);
        } else if (xt == xs) {
            x = (WALL + xs * (WALL + CELL)) * SPAN;
            y = ((WALL + CELL) + (WALL + CELL) * ((int) (ys + yt) / 2)) * SPAN;
            ;
            xspan = CELL * SPAN;
            yspan = WALL * SPAN;
            Rectangle square = new Rectangle(x, y, xspan, yspan);

            if (isDoor) {
                square.setRotate((CELL * SPAN) / 2);
                square.setFill(DOORCOLOR);
            } else {
                square.setFill(WALLCOLOR);
            }
            pane.getChildren().add(square);
        }
    }

    @Override
    public void view() {
        this.drawFrame();
        this.drawWallsAndDoor();
    }

    @Override
    public void update() {
    }
}
