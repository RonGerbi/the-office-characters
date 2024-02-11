package com.example.theofficecharacters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> characterDataSet;
    private RecyclerView characterRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterDataSet = new ArrayList<DataModel>();
        characterRecyclerView = findViewById(R.id.characterView);
        linearLayoutManager = new LinearLayoutManager(this);
        characterRecyclerView.setLayoutManager(linearLayoutManager);
        characterRecyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < CharacterData.characterImages.length; i++)
        {
            characterDataSet.add(new DataModel(CharacterData.characterNames[i],
                                                CharacterData.characterDescription[i],
                                                CharacterData.characterImages[i]));
        }

        adapter = new CustomAdapter(characterDataSet);
        characterRecyclerView.setAdapter(adapter);
    }
}