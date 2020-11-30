package cat.itb.roomba.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.itb.roomba.Database.Puntuacio;
import cat.itb.roomba.R;


class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView score;
    RelativeLayout layout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        score = itemView.findViewById(R.id.score);
        layout = itemView.findViewById(R.id.score_layout);
    }
}

public class ScoreAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Puntuacio> puntuacions;
    Context context;

    public ScoreAdapter(Context context, List<Puntuacio> puntuacions) {
        this.context = context;
        this.puntuacions = puntuacions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.score_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(puntuacions.get(position).getUser_name());
        holder.score.setText(String.valueOf(puntuacions.get(position).getPuntuacio()));
    }

    @Override
    public int getItemCount() {
        return puntuacions.size();
    }
}

