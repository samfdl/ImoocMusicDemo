package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.adapters.MusicGridAdapter;
import com.samfdl.imoocmusicdemo.adapters.MusicListAdapter;
import com.samfdl.imoocmusicdemo.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {
    private RecyclerView mRvGrid;
    private MusicGridAdapter mGridAdapter;

    private RecyclerView mRvList;
    private MusicListAdapter mListAdapter;

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
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelSize(R.dimen.albumMarginSize), mRvGrid));
        mGridAdapter = new MusicGridAdapter(this);
        mRvGrid.setAdapter(mGridAdapter);

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mListAdapter = new MusicListAdapter(this);
        mRvList.setAdapter(mListAdapter);
    }
}