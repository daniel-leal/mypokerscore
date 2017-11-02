package sistemas.dwm.com.br.mypokerscore;

/**
 * Created by Daniel Leal on 31/10/2017.
 */

public class Player {
    private String name;
    private String score;

    public Player(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
