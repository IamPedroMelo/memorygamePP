package pt.ipg.memorygamepp;

import android.content.Context;
import android.widget.Button;

public class MemoryGame extends Button {

    protected int row;
    protected int column;
    protected int frontDrawableId;

    protected boolean isFlipped = false;
    protected boolean isMatched = false;

    public MemoryGame (Context context , int r, int c , int frontImageDrawableId) {
        super(context);

        row = r;
        column = c;
        frontDrawableId = frontImageDrawableId;
    }

}
