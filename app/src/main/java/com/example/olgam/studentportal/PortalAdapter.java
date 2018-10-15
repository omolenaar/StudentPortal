package com.example.olgam.studentportal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter <PortalAdapter.PortalViewHolder> {
    //fields
    private  List<Portal> listPortal;
    private Context context;
    final private PortalClickListener mPortalClickListener;
    private static final String Tag = "TAG";

    public interface PortalClickListener {
        void portalOnClick(int i);
    }
    //constructor

    public PortalAdapter(Context context, List<Portal> listPortal, PortalClickListener mPortalClickListener) {
        this.context = context;
        this.listPortal = listPortal;
        this.mPortalClickListener = mPortalClickListener;
    }

    @Override
    public PortalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new PortalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PortalViewHolder holder, int position) {
        final Portal portal = listPortal.get(position);
        holder.portalName.setText(portal.getmPortalName());
        //holder.portalLink.setText(portal.getmLink());
    }

    @Override
    public int getItemCount() {
        if (listPortal == null)
            return 0;
        else
            return listPortal.size();
    }

    public class PortalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView portalName;
        public TextView portalLink;
        public View view;

        public PortalViewHolder(View itemView) {
            super(itemView);
            portalName = itemView.findViewById(R.id.textViewName);
            //portalLink = itemView.findViewById(R.id.textViewLink);
            //view = itemView;
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


