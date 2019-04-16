package com.samfdl.imoocmusicdemo.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.samfdl.imoocmusicdemo.R;

import java.util.Timer;
import java.util.TimerTask;

// 延迟3秒后跳转页面
public class WelcomeActivity extends BaseActivity {
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                toMain();
                // Log.e("WelcomeActivity", "当前线程为：" + Thread.currentThread());
            }
        }, 3000);
    }

    /**
     * 跳转到MainActivity
     */
    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}