package com.example.rcvapirettrofit.AdapterAPI;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rcvapirettrofit.R;
import com.example.rcvapirettrofit.model.User;

import java.util.List;

public class ApdapterRcvAPI extends RecyclerView.Adapter<ApdapterRcvAPI.userViewHolder> {

    private final List<User> listUser;

    public ApdapterRcvAPI(List<User> listUser) {
        this.listUser = listUser;
    }

    public static class userViewHolder  extends RecyclerView.ViewHolder {
        public final TextView tvId, tvTitle;

        public  userViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
        return new ApdapterRcvAPI.userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        User user = listUser.get(position);
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvTitle.setText(user.getTitle());

    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }


}
