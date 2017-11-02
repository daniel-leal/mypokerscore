package sistemas.dwm.com.br.mypokerscore;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel Leal on 31/10/2017.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {
    private List<Player> playerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView score, name;

        public MyViewHolder(View view) {
            super(view);
            score = (TextView) view.findViewById(R.id.score);
            name = (TextView) view.findViewById(R.id.name);
        }
    }

    public PlayersAdapter(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.name.setText(player.getName());
        holder.score.setText(player.getScore());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
