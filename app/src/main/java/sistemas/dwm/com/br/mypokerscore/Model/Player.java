package sistemas.dwm.com.br.mypokerscore.Model;

/**
 * Created by Daniel Leal on 31/10/2017.
 */
public class Player {
    private String name;
    private double score;
    private double recompra;

    public Player() {
    }

    public Player(String name, double score, double recompra) {
        this.name = name;
        this.score = score;
        this.recompra = recompra;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getRecompra() {
        return recompra;
    }

    public void setRecompra(double recompra) {
        this.recompra = recompra;
    }

    public Player(String name, String score) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
