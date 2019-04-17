package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.adapters.MusicGridAdapter;

public class MainActivity extends BaseActivity {
    private RecyclerView mRvGrid;
    private MusicGridAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(false, "慕课音乐", true);

        mRvGrid = fd(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(mAdapter);
    }
}