package com.oknesif.android_mvp.view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.ModelAdapter;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TitleHolder> {

    private ModelAdapter model;
    private OnEntityClickListener listener;

    public RecyclerAdapter(OnEntityClickListener listener) {
        setHasStableIds(true);
        this.listener = listener;
    }

    public void setData(ModelAdapter model) {
        this.model = model;
        notifyDataSetChanged();
    }

    @Override
    public TitleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TitleHolder(inflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(TitleHolder holder, int position) {
        holder.label.setText(model.getLabel(position));
        holder.label.setTextColor(model.isSelected(position) ? Color.GREEN : Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return model == null ? 0 : model.getSize();
    }

    @Override
    public long getItemId(int position) {
        return model.getId(position);
    }

    class TitleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView label;

        public TitleHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.tvLabel);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onClick(model.getId(position));
            }
        }
    }

}
