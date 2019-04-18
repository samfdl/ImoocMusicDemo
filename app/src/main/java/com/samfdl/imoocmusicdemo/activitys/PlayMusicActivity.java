package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.samfdl.imoocmusicdemo.R;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {
    private ImageView mIvBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        //  隐藏statusBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();
    }

    private void initView() {
        mIvBg = fd(R.id.iv_bg);
        // glide-transformations
        Glide.with(this)
                .load("http://res.lgdsunday.club/poster-1.png")
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 10)))
                .into(mIvBg);
    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View v) {
        onBackPressed();
    }
}