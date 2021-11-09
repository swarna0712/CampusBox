package com.example.campusbox;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class RidesAdapter extends RecyclerView.Adapter<RidesAdapter.RideViewHolder> {
    private Context mCtx;
    private List<Display> RideList;

    public RidesAdapter(Context mCtx, List<Display> RideList){
        this.mCtx = mCtx;
        this.RideList = RideList;
    }

    @NonNull
    @Override
    public RideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RideViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.all_posts, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RideViewHolder holder, int position) {
        Display display = RideList.get(position);

        holder.source.setText(display.getMsource());
        holder.destination.setText(display.getMdest());
        holder.date.setText(display.getMdate());
        holder.time.setText(display.getMtime());
        holder.maxpass.setText(display.getMmaxpass());
        holder.name.setText(display.getMname());
        holder.email.setText(display.getMemail());
        holder.phone.setText(display.getMphone());

    }

    @Override
    public int getItemCount() {
        return RideList.size();
    }

    static class RideViewHolder extends RecyclerView.ViewHolder {

        TextView source, destination, date, time, maxpass, name, email, phone;

        public RideViewHolder(View itemView) {
            super(itemView);

            source = itemView.findViewById(R.id.post_source);
            destination = itemView.findViewById(R.id.post_dest);
            date = itemView.findViewById(R.id.Date);
            time = itemView.findViewById(R.id.Time);
            maxpass = itemView.findViewById(R.id.post_max_pass);
            name = itemView.findViewById(R.id.post_username);
            email = itemView.findViewById(R.id.post_email);
            phone = itemView.findViewById(R.id.post_phone);

        }

    }

}
