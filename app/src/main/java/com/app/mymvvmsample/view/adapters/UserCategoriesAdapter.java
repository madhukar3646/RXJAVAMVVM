package com.app.mymvvmsample.view.adapters;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.app.mymvvmsample.R;
import com.app.mymvvmsample.model.UserCategoryModel;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by Manish on 10/3/2017.
 * */

public class UserCategoriesAdapter extends RecyclerView.Adapter<UserCategoriesAdapter.ViewHolder>{

    private Activity context;
    private ArrayList<UserCategoryModel> userCategoryModelArrayList;

    public UserCategoriesAdapter(Activity context,ArrayList<UserCategoryModel> userCategoryModelArrayList){
        this.context = context;
        this.userCategoryModelArrayList=userCategoryModelArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.categoryitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        UserCategoryModel model=userCategoryModelArrayList.get(position);
        holder.tv_categoryname.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return userCategoryModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_categoryname)
        TextView tv_categoryname;
        @BindView(R.id.iv_delete)
        ImageView iv_delete;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
