package view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Candy;
import model.Game;

public class CandyView extends BaseView {
    private Group           group;
    private List<ImageView> sprites;
    private Game            g;

    public CandyView(Pane pane) {
        this.group = new Group();
        g = Game.getInstance();
        sprites = new ArrayList<ImageView>();
        pane.getChildren().add(group);
    }

    @Override
    public void view() {
        update();
    }

    @Override
    public void update() {
        group.getChildren().clear();
        sprites.clear();

        List<Candy> candies = g.getCandies().getCandies();
        for (Candy c : candies) {

            ImageView v = new ImageView(c.getSprite());
            double xt = (int) ((WALL + c.getPosX() * (WALL + CELL)) * SPAN);
            double yt = (int) ((WALL + c.getPosY() * (WALL + CELL)) * SPAN);
            v.setFitWidth(CELL * SPAN);
            v.setFitHeight(CELL * SPAN);
            v.setX(xt);
            v.setY(yt);

            sprites.add(v);
            group.getChildren().add(v);
        }
    }

}
