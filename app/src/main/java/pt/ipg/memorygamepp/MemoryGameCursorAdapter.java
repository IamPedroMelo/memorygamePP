package pt.ipg.memorygamepp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class MemoryGameCursorAdapter extends RecyclerView.Adapter<MemoryGameCursorAdapter.MemoryGameViewHolder>{
    @NonNull
    @Override
    public MemoryGameCursorAdapter.MemoryGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MemoryGameCursorAdapter.MemoryGameViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MemoryGameViewHolder extends RecyclerView.ViewHolder {
        public MemoryGameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
