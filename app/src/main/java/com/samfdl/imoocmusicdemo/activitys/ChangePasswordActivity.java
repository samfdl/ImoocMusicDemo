package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;

import com.samfdl.imoocmusicdemo.R;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        initNavBar(true, "修改密码", false);

//        mInputPhone = fd(R.id.input_phone);
//        mInputPassword = fd(R.id.input_password);
    }
}