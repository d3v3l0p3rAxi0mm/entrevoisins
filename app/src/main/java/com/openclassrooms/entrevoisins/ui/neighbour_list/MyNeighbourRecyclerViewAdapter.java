package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.DeleteFavoriteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_profile.ProfileNeighbourActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Neighbour neighbour = mNeighbours.get(position);
        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(v -> {
            if (mDisplayFavoriteList) {
                EventBus.getDefault().post(new DeleteFavoriteNeighbourEvent(neighbour));
            } else {
                EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
            }
        });

        holder.mNeighbourName.setOnClickListener(v -> {
            Intent intentNameClick = new Intent(holder.mNeighbourName.getContext(), ProfileNeighbourActivity.class);
            putExtraAllNeighbourFieldsInIntent(intentNameClick, neighbour);
            holder.mNeighbourName.getContext().startActivity(intentNameClick);
        });

        holder.mNeighbourAvatar.setOnClickListener(v -> {
            Intent intentAvatarClick = new Intent(holder.mNeighbourAvatar.getContext(), ProfileNeighbourActivity.class);
            putExtraAllNeighbourFieldsInIntent(intentAvatarClick, neighbour);
            holder.mNeighbourAvatar.getContext().startActivity(intentAvatarClick);
        });


    }


    private void putExtraAllNeighbourFieldsInIntent(Intent intent, Neighbour neighbour) {
        intent.putExtra("neighbourId",neighbour.getId());
        intent.putExtra("neighbourName",neighbour.getName());
        intent.putExtra("neighbourAvatarUrl",neighbour.getAvatarUrl());
        intent.putExtra("neighbourAddress",neighbour.getAddress());
        intent.putExtra("neighbourPhoneNumber",neighbour.getPhoneNumber());
        intent.putExtra("neighbourWebSite",neighbour.getWebSite());
        intent.putExtra("neighbourAboutMe",neighbour.getAboutMe());
        intent.putExtra("neighbourIsFavorite",neighbour.getIsFavorite());
    }


    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
