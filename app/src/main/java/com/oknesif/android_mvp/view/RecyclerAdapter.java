package com.oknesif.android_mvp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.AdapterDataModel;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TitleHolder> {

    private AdapterDataModel model;
    private OnEntityClickListener listener;

    public RecyclerAdapter(AdapterDataModel model, OnEntityClickListener listener) {
        this.model = model;
        this.listener = listener;
    }

    @Override
    public TitleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TitleHolder(inflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(TitleHolder holder, int position) {
        holder.titleView.setText(model.getTitleOnPosition(position));
    }

    @Override
    public int getItemCount() {
        return model.getSize();
    }

    class TitleHolder extends RecyclerView.ViewHolder {
        TextView titleView;

        public TitleHolder(View itemView) {
            super(itemView);
            titleView = (TextView) itemView.findViewById(R.id.tvTitle);
            titleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onClick(position);
                    }
                }
            });
        }
    }

}
