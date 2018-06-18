package pt.ipg.memorygamepp;

public class HighScores {
    private int id;
    private int type;
    private String Score1;
    private String Score2;
    private String Score3;
    private String Score4;
    private String Score5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getScore1() {
        return Score1;
    }

    public void setScore1(String score1) {
        Score1 = score1;
    }

    public String getScore2() {
        return Score2;
    }

    public void setScore2(String score2) {
        Score2 = score2;
    }

    public String getScore3() {
        return Score3;
    }

    public void setScore3(String score3) {
        Score3 = score3;
    }

    public String getScore4() {
        return Score4;
    }

    public void setScore4(String score4) {
        Score4 = score4;
    }

    public String getScore5() {
        return Score5;
    }

    public void setScore5(String score5) {
        Score5 = score5;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

}
