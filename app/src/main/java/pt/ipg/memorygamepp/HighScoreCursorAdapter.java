package pt.ipg.memorygamepp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HighScoreCursorAdapter extends RecyclerView.Adapter<HighScoreCursorAdapter.HighScoreViewHolder>{

    private Context context;
    private Cursor cursor = null;

    public HighScoreCursorAdapter(Context context){
        this.context = context;
    }

    public void refreshData(Cursor cursor){
        if(this.cursor != cursor){
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public HighScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_pontuacao,parent,false);

        return new HighScoreViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HighScoreCursorAdapter.HighScoreViewHolder holder, int position) {
        cursor.moveToPosition(position);
        HighScores highscores = DbTableHighScores.getCurrentHighScoresFromCursor(cursor);
        holder.setHighScores(highscores);

    }

    @Override
    public int getItemCount() {
        if(cursor == null) return 0;

        return cursor.getCount();
    }

    public class HighScoreViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewUsername;
        private TextView textViewScore;

        public HighScoreViewHolder(View itemView){
            super(itemView);

            textViewUsername = itemView.findViewById(R.id.textViewUserItem);
            textViewScore = itemView.findViewById(R.id.textViewScoreItem);
        }

        public void setHighScores(HighScores highscores) {
            textViewUsername.setText(20);/*highscores.getUserId()*/
            textViewScore.setText(highscores.getScore());
        }
    }
}


