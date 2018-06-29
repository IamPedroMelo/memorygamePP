package pt.ipg.memorygamepp;

public class HighScores {
    private int id;
    private static int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
