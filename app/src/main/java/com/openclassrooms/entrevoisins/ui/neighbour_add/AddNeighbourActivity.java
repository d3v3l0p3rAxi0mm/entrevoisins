package com.openclassrooms.entrevoisins.ui.neighbour_add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.databinding.ActivityAddNeighbourBinding;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.util.Objects;

public class AddNeighbourActivity extends AppCompatActivity {

    private NeighbourApiService mApiService;
    private String mNeighbourImage;
    private ActivityAddNeighbourBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNeighbourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getNeighbourApiService();
        init();

        binding.create.setOnClickListener(v -> {
            // add a new Neighbour object with false as favorite Item
            Neighbour neighbour = new Neighbour(
                    System.currentTimeMillis(),
                    Objects.requireNonNull(binding.nameLyt.getEditText()).getText().toString(),
                    mNeighbourImage,
                    Objects.requireNonNull(binding.addressLyt.getEditText()).getText().toString(),
                    Objects.requireNonNull(binding.phoneNumberLyt.getEditText()).getText().toString(),
                    Objects.requireNonNull(binding.webSiteLyt.getEditText()).getText().toString(),
                    Objects.requireNonNull(binding.aboutMeLyt.getEditText()).getText().toString(),
                    false
            );
            mApiService.createNeighbour(neighbour);
            AddNeighbourActivity.this.finish();
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        mNeighbourImage = randomImage();
        Glide.with(this).load(mNeighbourImage).placeholder(R.drawable.ic_account)
                .apply(RequestOptions.circleCropTransform()).into(binding.avatar);
        Objects.requireNonNull(binding.nameLyt.getEditText()).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                binding.create.setEnabled(s.length() > 0);
            }
        });

    }

    /**
     * Generate a random image. Useful to mock image picker
     * @return String
     */
    String randomImage() {
        return "https://i.pravatar.cc/150?u="+ System.currentTimeMillis();
    }

}
