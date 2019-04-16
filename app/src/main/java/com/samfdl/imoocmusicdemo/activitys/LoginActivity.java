package com.samfdl.imoocmusicdemo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.utils.UserUtils;
import com.samfdl.imoocmusicdemo.views.InputView;

// NavigationBar
public class LoginActivity extends BaseActivity {
    private InputView mInputPhone, mInputPassword;

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

        mInputPhone = fd(R.id.input_phone);
        mInputPassword = fd(R.id.input_password);
    }

    /**
     * 跳转注册页面点击事件
     */
    public void onRegisterClick(View v) {

    }

    /**
     * 登录
     */
    public void onCommitClick(View v) {
        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

        // 验证用户输入是否合法
        if (!UserUtils.validateLogin(this, phone, password)) {
            return;
        }

        // 跳转到应用主页
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}