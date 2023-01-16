package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.databinding.FragmentNeighbourBinding;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.DeleteFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_profile.ProfileNeighbourActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    private final boolean mDisplayFavoriteList;

    public MyNeighbourRecyclerViewAdapter(List<Neighbour> items, boolean displayFavoriteList) {
        mDisplayFavoriteList = displayFavoriteList;
        mNeighbours = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FragmentNeighbourBinding fragmentNeighbourBinding = FragmentNeighbourBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(fragmentNeighbourBinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.bindView(neighbour, mDisplayFavoriteList);
    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final FragmentNeighbourBinding fragmentNeighbourBinding;
        private final NeighbourApiService mApiService = DI.getNeighbourApiService();

        public ViewHolder(@NonNull FragmentNeighbourBinding fragmentNeighbourBinding) {
            super(fragmentNeighbourBinding.getRoot());
            this.fragmentNeighbourBinding = fragmentNeighbourBinding;
        }

        public void bindView(Neighbour neighbour, Boolean displayFavoriteList) {
            fragmentNeighbourBinding.itemListName.setText(neighbour.getName());
            Glide.with(fragmentNeighbourBinding.itemListAvatar.getContext())
                    .load(neighbour.getAvatarUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(fragmentNeighbourBinding.itemListAvatar);


            fragmentNeighbourBinding.itemListDeleteButton.setOnClickListener(v -> {
                if (displayFavoriteList) {
                    EventBus.getDefault().post(new DeleteFavoriteNeighbourEvent(neighbour));
                } else {
                    EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
                }
            });

            fragmentNeighbourBinding.itemListName.setOnClickListener(v -> {
                Intent intentNameClick = new Intent(fragmentNeighbourBinding.itemListName.getContext(), ProfileNeighbourActivity.class);
                mApiService.setSelectedNeighbour(neighbour);
                fragmentNeighbourBinding.itemListName.getContext().startActivity(intentNameClick);
            });

            fragmentNeighbourBinding.itemListAvatar.setOnClickListener(v -> {
                Intent intentAvatarClick = new Intent(fragmentNeighbourBinding.itemListAvatar.getContext(), ProfileNeighbourActivity.class);
                mApiService.setSelectedNeighbour(neighbour);
                fragmentNeighbourBinding.itemListAvatar.getContext().startActivity(intentAvatarClick);
            });

        }

    }
}
