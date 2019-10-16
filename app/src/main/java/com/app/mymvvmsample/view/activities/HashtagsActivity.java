package com.app.mymvvmsample.view.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.app.mymvvmsample.R;
import com.app.mymvvmsample.view.adapters.HashtagsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HashtagsActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.iv_backbtn)
    ImageView iv_backbtn;
    @BindView(R.id.rv_tagslist)
    RecyclerView rv_tagslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hashtags);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        init();
    }

    private void init()
    {
      iv_backbtn.setOnClickListener(this);
      rv_tagslist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
      rv_tagslist.setAdapter(new HashtagsAdapter(this));
    }

    @Override
    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.iv_backbtn:
                finish();
                break;
        }
    }
}
