package sistemas.dwm.com.br.mypokerscore.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sistemas.dwm.com.br.mypokerscore.Pattern.DividerItemDecoration;
import sistemas.dwm.com.br.mypokerscore.Model.Player;
import sistemas.dwm.com.br.mypokerscore.Adapter.PlayersAdapter;
import sistemas.dwm.com.br.mypokerscore.R;

public class ListRankActivity extends AppCompatActivity {
    private List<Player> playerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlayersAdapter pAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rank);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        pAdapter = new PlayersAdapter(playerList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        preparePlayerData();
    }

    private void preparePlayerData() {
        Player player = new Player("Alexandre", "Score: 54332 pts");
        playerList.add(player);

        player = new Player("Daniel", "Score: 30 pts");
        playerList.add(player);

        player = new Player("Andinho", "Score: 25 pts");
        playerList.add(player);

        player = new Player("Humberto", "Score: 20 pts");
        playerList.add(player);

        pAdapter.notifyDataSetChanged();
    }
}
