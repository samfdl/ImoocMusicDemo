package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;

import com.samfdl.imoocmusicdemo.R;

public class MainActivity extends BaseActivity {

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
    }
}