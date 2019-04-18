package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.adapters.MusicListAdapter;

public class AlbumListActivity extends BaseActivity {
    private RecyclerView mRvList;
    private MusicListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(true, "专辑列表", false);

        mRvList = fd(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mListAdapter = new MusicListAdapter(this, null);
        mRvList.setAdapter(mListAdapter);
    }
}