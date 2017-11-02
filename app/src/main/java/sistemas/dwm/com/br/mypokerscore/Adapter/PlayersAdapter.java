package sistemas.dwm.com.br.mypokerscore.Adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sistemas.dwm.com.br.mypokerscore.Model.Player;
import sistemas.dwm.com.br.mypokerscore.R;

/**
 * Created by Daniel Leal on 31/10/2017.
 */

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {
    private List<Player> playerList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView score, name, recompra;

        public MyViewHolder(View view) {
            super(view);
            score = view.findViewById(R.id.score);
            recompra = view.findViewById(R.id.recompra);
            name = view.findViewById(R.id.name);
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

        Resources res = holder.itemView.getResources();

        holder.name.setText(player.getName());
        holder.score.setText(res.getString(R.string.score_msg, String.valueOf(player.getScore())));
        holder.recompra.setText(res.getString(R.string.recompra_msg, String.valueOf(player.getRecompra())));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
