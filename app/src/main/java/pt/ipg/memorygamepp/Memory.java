package pt.ipg.memorygamepp;

import android.graphics.drawable.Drawable;


public class Memory {


    private boolean isMatched = false;
    private boolean isFlipped = false;
    private Drawable back;




    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setFlipped(boolean flipped) {
        isFlipped = flipped;
    }

}
