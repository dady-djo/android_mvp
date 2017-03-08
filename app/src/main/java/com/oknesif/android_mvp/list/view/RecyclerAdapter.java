package com.oknesif.android_mvp.list.view;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.list.model.ModelAdapter;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TitleHolder> {

    private ModelAdapter model;
    private OnItemClickListener listener;

    public RecyclerAdapter(OnItemClickListener listener) {
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
        holder.button.setText(model.getButtonText(position));
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
        TextView button;

        public TitleHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.tvLabel);
            button = (TextView) itemView.findViewById(R.id.button);
            itemView.setOnClickListener(this);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position == RecyclerView.NO_POSITION || listener == null) return;

            if (v.getId() == R.id.button)
                listener.onButtonClick(model.getId(position));
            else
                listener.onItemClick(model.getId(position));
        }
    }
}
