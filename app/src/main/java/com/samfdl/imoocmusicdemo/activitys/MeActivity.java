package com.samfdl.imoocmusicdemo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.utils.UserUtils;

public class MeActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(true, "个人中心", false);
    }

    /**
     * 修改密码点击事件
     */
    public void onChangeClick(View v) {
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    /**
     * 退出登录
     */
    public void onLogoutClick(View v) {
        UserUtils.logout(this);
    }
}