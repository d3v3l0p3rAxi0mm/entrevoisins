package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.openclassrooms.entrevoisins.databinding.ActivityListNeighbourBinding;
import com.openclassrooms.entrevoisins.ui.neighbour_add.AddNeighbourActivity;

public class ListNeighbourActivity extends AppCompatActivity {

    private ActivityListNeighbourBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListNeighbourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        ListNeighbourPagerAdapter mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager());
        binding.container.setAdapter(mPagerAdapter);
        binding.container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.tabs));
        binding.tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(binding.container));

        binding.addNeighbour.setOnClickListener(v -> {
            Intent addNeighbourIntent = new Intent(binding.addNeighbour.getContext(), AddNeighbourActivity.class);
            binding.addNeighbour.getContext().startActivity(addNeighbourIntent);
        });

    }

}
