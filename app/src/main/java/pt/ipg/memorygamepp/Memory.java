package pt.ipg.memorygamepp;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;

public class Memory {


    private boolean isMatched = false;
    private boolean isFlipped = false;
    private Drawable back;

    back = AppCompatDrawableManager.getDrawable(R.drawable.botao_question_mark);

    back = AppCompatDrawableManager.get()
    setBackground(back);


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
