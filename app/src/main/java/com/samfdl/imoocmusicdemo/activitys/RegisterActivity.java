package com.samfdl.imoocmusicdemo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samfdl.imoocmusicdemo.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(true, "注册", false);

//        mInputPhone = fd(R.id.input_phone);
//        mInputPassword = fd(R.id.input_password);
    }

    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
