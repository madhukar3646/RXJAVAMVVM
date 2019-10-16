package com.app.mymvvmsample.view.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.mymvvmsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Manish on 10/3/2017.
 * */

public class HashtagsAdapter extends RecyclerView.Adapter<HashtagsAdapter.ViewHolder>{

    private Activity context;
    public HashtagsAdapter(Activity context){
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hashtagmodel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_categoryname)
        TextView tv_categoryname;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
