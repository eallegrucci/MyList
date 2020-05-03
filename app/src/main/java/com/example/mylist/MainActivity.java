package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private listAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();
        buildList();
    }

    public void createList() {
        listItems = new ArrayList<>();
        listItems.add(new ListItem(R.drawable.nes, "Nintendo Entertainment System (NES)",
                "https://en.wikipedia.org/wiki/Nintendo_Entertainment_System"));
        listItems.add(new ListItem(R.drawable.snes, "Super Nintendo Entertainment System (SNES)",
                "https://en.wikipedia.org/wiki/Super_Nintendo_Entertainment_System"));
        listItems.add(new ListItem(R.drawable.n64, "Nintendo 64 (N64)",
                "https://en.wikipedia.org/wiki/Nintendo_64"));
        listItems.add(new ListItem(R.drawable.gamecube, "Nintendo GameCube",
                "https://en.wikipedia.org/wiki/GameCube"));
        listItems.add(new ListItem(R.drawable.wii, "Wii",
                "https://en.wikipedia.org/wiki/Wii"));
        listItems.add(new ListItem(R.drawable.wiiu, "Wii U",
                "https://en.wikipedia.org/wiki/Wii_U"));
        listItems.add(new ListItem(R.drawable.nswitch, "Nintendo Switch",
                "https://en.wikipedia.org/wiki/Nintendo_Switch"));
    }

//    public void itemClick(int position, String text) {
//        listItems.get(position).changeView("Clicked");
//        mAdapter.notifyItemChanged(position);
//    }

    public void buildList() {
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new listAdapter(listItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new listAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //itemClick(position, "Clicked");
                String ref = listItems.get(position).getReference();
                Intent i = new Intent(MainActivity.this, webView.class);
                i.putExtra("ref", ref);
                startActivity(i);
            }
        });
    }
}
