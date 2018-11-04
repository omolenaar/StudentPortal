package com.example.olgam.studentportal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter <PortalAdapter.PortalViewHolder> {
    //fields
    private final List<Portal> listPortal;
    final private PortalClickListener mPortalClickListener;
    private static final String Tag = "TAG";

    public interface PortalClickListener {
        void portalOnClick(int i);
    }
    //constructor

    PortalAdapter(List<Portal> listPortal, PortalClickListener mPortalClickListener)
    {
        //Context context1 = context;
        this.listPortal = listPortal;
        this.mPortalClickListener = mPortalClickListener;
    }

    @NonNull
    @Override
    public PortalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new PortalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortalViewHolder holder, int position) {
        final Portal portal = listPortal.get(position);
        holder.portalName.setText(portal.getmPortalName());
    }

    @Override
    public int getItemCount() {
        if (listPortal == null)
            return 0;
        else
            return listPortal.size();
    }

    public class PortalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView portalName;
        public TextView portalLink;
        public View view;

        PortalViewHolder(View itemView) {
            super(itemView);
            portalName = itemView.findViewById(R.id.textViewName);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            Log.e(Tag, "clickedPosition i = "+clickedPosition);
            mPortalClickListener.portalOnClick(clickedPosition);
        }
    }

}


