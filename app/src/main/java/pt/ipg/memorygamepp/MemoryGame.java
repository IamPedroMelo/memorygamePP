package pt.ipg.memorygamepp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.GridLayout;


public class MemoryGame extends android.support.v7.widget.AppCompatButton {

    protected int row;
    protected int col;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    protected Drawable front;
    protected Drawable back;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("RestrictedApi")
    public MemoryGame (Context context , int r, int c , int frontImageDrawableId) {
        super(context);
        row = r;
        col = c;
        frontDrawableId = frontImageDrawableId;

        front = AppCompatDrawableManager.get().getDrawable(context, frontImageDrawableId);
        back = AppCompatDrawableManager.get().getDrawable(context, R.drawable.botao_question_mark);

        setBackground(back);

       // GridLayout.LayoutParams tempParams = new GridLayout.LayoutParams(GridLayout.spec(r),GridLayout.spec(c));

       // tempParams.width = (int) getResources().getDisplayMetrics().density*50;
        //tempParams.height = (int) getResources().getDisplayMetrics().density*50;

        //setLayoutParams(tempParams);

    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public int getFrontDrawableId() {
        return frontDrawableId;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void flip() {
        if (isMatched) return;
        if (isFlipped) {
            setBackground(back);
            isFlipped = false;
        } else {
            setBackground(front);
            isFlipped = true;
        }
    }

}
