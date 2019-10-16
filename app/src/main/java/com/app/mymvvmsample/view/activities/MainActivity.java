package com.app.mymvvmsample.view.activities;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.app.mymvvmsample.R;
import com.app.mymvvmsample.model.UserCategoryModel;
import com.app.mymvvmsample.view.adapters.UserCategoriesAdapter;
import com.app.mymvvmsample.viewmodel.CategoriesViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.iv_backbtn)
    ImageView iv_backbtn;
    @BindView(R.id.rv_usercategorieslist)
    RecyclerView rv_usercategorieslist;
    @BindView(R.id.iv_add)
    ImageView iv_add;
    private CategoriesViewModel categoriesViewModel;
    private ArrayList<UserCategoryModel> userCategoryModelArrayList=new ArrayList<>();
    private UserCategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        init();
    }

    private void init()
    {
        iv_backbtn.setOnClickListener(this);
        iv_add.setOnClickListener(this);
        rv_usercategorieslist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        categoriesAdapter=new UserCategoriesAdapter(this,userCategoryModelArrayList);
        rv_usercategorieslist.setAdapter(categoriesAdapter);

        categoriesViewModel= ViewModelProviders.of(this).get(CategoriesViewModel.class);
        categoriesViewModel.getUsercategoryList().observe(this, new Observer<List<UserCategoryModel>>() {
            @Override
            public void onChanged(@Nullable List<UserCategoryModel> userCategoryModels) {
               Log.e("Onchanged","onchanged");
              userCategoryModelArrayList.addAll(userCategoryModels);
              categoriesAdapter.notifyDataSetChanged();
            }
        });

        if(isInternetConnected())
            categoriesViewModel.getUserCategories();
        else
            showInternetToast();
    }

    @Override
    public void onClick(View view) {
     switch (view.getId())
     {
         case R.id.iv_backbtn:
             finish();
             break;
         case R.id.iv_add:
             Intent intent=new Intent(MainActivity.this,HashtagsActivity.class);
             startActivity(intent);
             break;
     }
    }
}
