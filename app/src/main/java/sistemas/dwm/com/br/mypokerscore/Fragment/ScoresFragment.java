package sistemas.dwm.com.br.mypokerscore.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import sistemas.dwm.com.br.mypokerscore.Adapter.PlayersAdapter;
import sistemas.dwm.com.br.mypokerscore.Model.Player;
import sistemas.dwm.com.br.mypokerscore.R;


public class ScoresFragment extends Fragment {
    public static final String TAG = "ScoresFragment";
    private List<Player> playerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlayersAdapter pAdapter;
    private View myView;
    private FirebaseDatabase database;
    private DatabaseReference firebasePlayers;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_scores, container, false);

        // Get FirebaseInstance
        database = FirebaseDatabase.getInstance();
        firebasePlayers = database.getReference("jogadores");
        Query playersByScore = firebasePlayers.orderByChild("score");

        recyclerView = myView.findViewById(R.id.recycler_view);
        progressBar = myView.findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);

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
        firebasePlayers.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                playerList.clear();
                for(DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Player p = objSnapshot.getValue(Player.class);
                    playerList.add(p);
                }
                pAdapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }

}
