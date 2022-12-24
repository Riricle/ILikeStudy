package com.example.classmannger.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classmannger.R;

import java.util.List;
import java.util.Map;

public class TodoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull

    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private LayoutInflater mLayoutInflater;

    public TodoListAdapter(Context mContext, List<Map<String,Object>> mDataList){
        this.mContext=mContext;
        this.mDataList=mDataList;
        mLayoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=mLayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Map<String,Object> entity=mDataList.get(position);
        if(null==entity){
            return;
        }
        ViewHolder viewHolder=(ViewHolder) holder;
        viewHolder.news_title.setText(entity.get("news_title").toString());
        viewHolder.news_thumb.setImageResource(Integer.parseInt(entity.get("news_thumb").toString()));
        viewHolder.news_info.setText(entity.get("news_info").toString());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView news_title;
        ImageView news_thumb;
        TextView news_info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_title=(TextView) itemView.findViewById(R.id.news_title);
            news_info=(TextView) itemView.findViewById(R.id.news_info);
            news_thumb=(ImageView) itemView.findViewById(R.id.news_thumb);
            itemView.findViewById(R.id.news_container).setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

}

