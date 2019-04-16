package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.view.View;

import com.samfdl.imoocmusicdemo.R;

// NavigationBar
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(false, "登录", false);
    }

    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick(View v) {

    }
}