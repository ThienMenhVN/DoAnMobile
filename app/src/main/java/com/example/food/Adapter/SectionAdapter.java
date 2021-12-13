package com.example.food.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food.Model.News;
import com.example.food.Model.Section;
import com.example.food.R;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.ViewHolder> {
    ArrayList<Section> sections;
    Context context;

    public SectionAdapter(ArrayList<Section> sections, Context context) {
        this.sections = sections;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section_recyclerview,parent,false);
        return new SectionAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(sections.get(position).getHeaderTitle());
        ArrayList list = sections.get(position).getListContent();
        if (list.get(0) instanceof News){
            NewsAdapter newsAdapter = new NewsAdapter(sections.get(position).getListContent(),context);
            holder.content.setHasFixedSize(true);
            holder.content.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            holder.content.setAdapter(newsAdapter);
        }

    }
    @Override
    public int getItemCount() {
        return sections.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private RecyclerView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleofsection);
            content = itemView.findViewById(R.id.contentofsection);
        }
    }
}
