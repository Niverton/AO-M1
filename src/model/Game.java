package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import model.graph.Vertex;
import model.interfaces.IGame;

/**
 * Le modele du jeu. Possede tout les sous-modeles de logique de jeu.
 * C'est un singleton.
 */
public class Game extends Observable implements IGame {
    private static Game instance;

    private Labyrinth labyrinth;
    private Player    player;
    private BadBoys   badBoys;
    private Candies   candies;
    private Door      door;

    private ListObject listObject;
    private boolean    end;
    private boolean    lose;
    private int        score;

    private Game() {
        labyrinth = new Labyrinth(16);

        player = new Player(4);

        int nbBadBoys = 3;
        badBoys = new BadBoys(nbBadBoys);
        Random r = new Random();
        List<Point2D> lp = new ArrayList<Point2D>();
        for (int i = 0; i < nbBadBoys; i++) {
            Point2D p = new Point2D(r.nextInt(this.labyrinth.getSize()), r.nextInt(this.labyrinth.getSize()));
           
            lp.add(p);
        }
        badBoys.setAllInitialPos(lp);

        listObject = new ListObject();
        candies = new Candies();
        Point2D p = labyrinth.getFurther(new Vertex(player.getPosX(), player.getPosY(), 0));
        door = new Door("door", p);
        end = false;
        lose = false;
        score = 0;
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void movePlayer(Directions dir) {
        Vertex v = new Vertex(player.getPosX(), player.getPosY(), 0);

        if (!labyrinth.isWall(v, dir) && !this.end) {
            player.move(dir);
            this.setChanged();
            this.notifyObservers();
            if (player.getPosition().equals(door.getPosition())) {
                end = true;
            }
            Point2D p_pos = player.getPosition();

            score += candies.maybeEaten(p_pos);
        }

    }

    /**
     * Deplace les mechants.
     * TODO
     * Pour l'instant la direction est aleatoire, a ameliorer en utilisant
     * l'algorithme de manhattan
     */
    public void moveBadBoys() {
        for (BadBoy bb : badBoys.getList()) {
            Vertex source = new Vertex(bb.getPosX(), bb.getPosY(), 0);
            Vertex target = new Vertex(player.getPosX(), player.getPosY(), 0);
           
            Directions dir = this.labyrinth.getNextDir(source, target);
            
           
            if (dir != null && !this.end  && !labyrinth.isWall(source, dir)) {
                bb.move(dir);

                if (player.getPosition().equals(bb.getPosition())) {
                    // on replace le mechants a une position aleatoire.
                    Timeline t = new Timeline(new KeyFrame(Duration.seconds(0.2), ae -> {
                        Random r = new Random();
                      
                        Point2D p = new Point2D(this.labyrinth.getSize() - player.getPosX()-1,this.labyrinth.getSize()-1 - player.getPosY() );// labyrinth.getFurther(new Vertex(player.getPosX(), player.getPosY(), 0));
                        bb.setPosition(p);
                    }));
                    t.play();

                    player.loseLife();
                    if (player.getLives() <= 0) {
                        this.end = true;
                        lose = true;
                    }
                }
            }
        }
        this.setChanged();
        this.notifyObservers();
    }

    public BadBoys getBadBoys() {
        return badBoys;
    }

    public Player getPlayer() {
        return player;
    }

    public ListObject getListObject() {
        return listObject;
    }

    public Candies getCandies() {
        return this.candies;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public Door getDoor() {
        return this.door;
    }

    /**
     * @return si le jeu est termine
     */
    public boolean isEnd() {
        return this.end;
    }

    /**
     * Est-ce que le joueur a perdu ?
     */
    public boolean getLose() {
        return this.lose;
    }

    /**
     * Remet la partie a 0
     */
    public void retry() {
        this.player.setLives(5);
        for (BadBoy bb : badBoys.getList()) {
            Random r = new Random();
            bb.setPosition(new Point2D(r.nextInt(this.labyrinth.getSize()), r.nextInt(this.labyrinth.getSize())));
        }
        player.setPosition(new Point2D(0,0));
        end = false;
        lose = false;
        score = 0;
        this.setChanged();
        this.notifyObservers();
    }
}
