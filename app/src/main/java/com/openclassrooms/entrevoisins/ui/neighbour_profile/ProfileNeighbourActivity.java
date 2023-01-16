package com.openclassrooms.entrevoisins.ui.neighbour_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.databinding.ActivityProfileNeighbourBinding;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class ProfileNeighbourActivity extends AppCompatActivity {

    private boolean mNeighbourIsFavorite;
    private Neighbour mNeighbour;
    private ActivityProfileNeighbourBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileNeighbourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Call apiService
        NeighbourApiService mApiService = DI.getNeighbourApiService();

        mNeighbour = mApiService.getSelectedNeighbour();

        binding.itemPicProfileName.setText(mNeighbour.getName());
        binding.itemProfileName.setText(mNeighbour.getName());
        binding.itemProfileAddress.setText(mNeighbour.getAddress());
        binding.itemProfilePhone.setText(mNeighbour.getPhoneNumber());
        binding.itemProfileWebsite.setText(mNeighbour.getWebSite());
        binding.itemAboutme.setText(mNeighbour.getAboutMe());
        Glide.with(this.getApplicationContext()).load(mNeighbour.getAvatarUrl()).centerCrop().into(binding.itemProfileAvatar);
        mNeighbourIsFavorite = mNeighbour.getIsFavorite();

        // change favorite icon based on favorite status Neighbour
        if (mNeighbourIsFavorite) {
            binding.favNeighbour.setImageResource(R.drawable.ic_baseline_star_24);
        } else {
            binding.favNeighbour.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        binding.favNeighbour.setOnClickListener(v -> {
            String toastMessage;
            if (mNeighbourIsFavorite) {
                mNeighbourIsFavorite = false;
                toastMessage = mNeighbour.getName() + " " + getResources().getString(R.string.removedFromFavorite);
                binding.favNeighbour.setImageResource(R.drawable.ic_baseline_star_border_24);
                mApiService.deleteFavoriteNeighbour(mNeighbour);

            } else {
                mNeighbourIsFavorite = true;
                toastMessage = mNeighbour.getName() + " " +  getResources().getString(R.string.addIntoFavorite);
                binding.favNeighbour.setImageResource(R.drawable.ic_baseline_star_24);
                mApiService.addFavoriteNeighbour(mNeighbour);

            }
            Toast.makeText(v.getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        });

        binding.back.setOnClickListener(v -> ProfileNeighbourActivity.this.finish());

    }

}