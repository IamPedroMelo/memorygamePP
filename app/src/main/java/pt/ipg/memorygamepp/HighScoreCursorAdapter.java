package pt.ipg.memorygamepp;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HighScoreCursorAdapter extends RecyclerView.Adapter<HighScoreCursorAdapter.HighScoreViewHolder>{

    private Context context;

    public HighScoreCursorAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public HighScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.content_pontuacao,parent,false);

        return new HighScoreViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HighScoreCursorAdapter.HighScoreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HighScoreViewHolder extends RecyclerView.ViewHolder {
        public HighScoreViewHolder(View itemView){
            super(itemView);
        }
    }
}


