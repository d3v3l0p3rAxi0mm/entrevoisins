package com.openclassrooms.entrevoisins.ui.neighbour_profile;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.item_profile_name)
    TextView mNeighbourName;
    @BindView(R.id.item_pic_profile_name)
    TextView mNeighbourNameOnPic;
    @BindView(R.id.item_profile_address)
    TextView mNeighbourAddress;
    @BindView(R.id.item_profile_phone)
    TextView mNeighbourPhoneNumber;
    @BindView(R.id.item_profile_avatar)
    ImageView mNeighbourAvatarUrl;
    @BindView(R.id.item_profile_website)
    TextView mNeighbourWebSite;
    @BindView(R.id.item_aboutme)
    TextView mNeighbourAboutMe;
    @BindView(R.id.fav_neighbour)
    FloatingActionButton mFavoriteButton;
    @BindView(R.id.back)
    FloatingActionButton backButton;

    private boolean mNeighbourIsFavorite;
    private Neighbour mNeighbour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        // Call apiService
        NeighbourApiService mApiService = DI.getNeighbourApiService();
        // Bind all widgets
        ButterKnife.bind(this);

        mNeighbour = mApiService.getSelectedNeighbour();
        mNeighbourNameOnPic.setText(mNeighbour.getName());
        mNeighbourName.setText(mNeighbour.getName());
        mNeighbourAddress.setText(mNeighbour.getAddress());
        mNeighbourPhoneNumber.setText(mNeighbour.getPhoneNumber());
        mNeighbourWebSite.setText(mNeighbour.getWebSite());
        Glide.with(this.getApplicationContext()).load(mNeighbour.getAvatarUrl()).centerCrop().into(mNeighbourAvatarUrl);
        mNeighbourAboutMe.setText(mNeighbour.getAboutMe());
        mNeighbourAboutMe.setText(mNeighbour.getAboutMe());
        mNeighbourIsFavorite = mNeighbour.getIsFavorite();
        // change favorite icon based on favorite status Neighbour
        if (mNeighbourIsFavorite) {
            mFavoriteButton.setImageResource(R.drawable.ic_baseline_star_24);
        } else {
            mFavoriteButton.setImageResource(R.drawable.ic_baseline_star_border_24);
        }

        mFavoriteButton.setOnClickListener(v -> {
            String toastMessage;
            if (mNeighbourIsFavorite) {
                mNeighbourIsFavorite = false;
                toastMessage = mNeighbour.getName() + " " + getResources().getString(R.string.removedFromFavorite);
                mFavoriteButton.setImageResource(R.drawable.ic_baseline_star_border_24);
                mApiService.deleteFavoriteNeighbour(mNeighbour);

            } else {
                mNeighbourIsFavorite = true;
                toastMessage = mNeighbour.getName() + " " +  getResources().getString(R.string.addIntoFavorite);
                mFavoriteButton.setImageResource(R.drawable.ic_baseline_star_24);
                mApiService.addFavoriteNeighbour(mNeighbour);

            }
            Toast.makeText(v.getContext(), toastMessage, Toast.LENGTH_SHORT).show();
        });

        backButton.setOnClickListener(v -> ProfileNeighbourActivity.this.finish());

    }

}