package sistemas.dwm.com.br.mypokerscore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ScoresFragment extends Fragment {
    private List<Player> playerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlayersAdapter pAdapter;
    private View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_scores, container, false);

        recyclerView = myView.findViewById(R.id.recycler_view);

        pAdapter = new PlayersAdapter(playerList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        preparePlayerData();

        return myView;
    }

    private void preparePlayerData() {
        playerList.add(new Player("Daniel Leal", 14.43, 3));
        playerList.add(new Player("Humberto Junior", 12.4, 4));
        playerList.add(new Player("Márcio Borges", 7.1, 8));

        pAdapter.notifyDataSetChanged();
    }

}
