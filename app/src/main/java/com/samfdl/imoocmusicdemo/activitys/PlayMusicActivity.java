package com.samfdl.imoocmusicdemo.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.views.PlayMusicView;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class PlayMusicActivity extends BaseActivity {
    private ImageView mIvBg;
    private PlayMusicView mPlayMusicView;

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

        mPlayMusicView = fd(R.id.play_music_view);
        mPlayMusicView.setMusicIcon("http://res.lgdsunday.club/poster-1.png");
        mPlayMusicView.playMusic("http://res.lgdsunday.club/Nostalgic%20Piano.mp3");
    }

    /**
     * 后退按钮点击事件
     */
    public void onBackClick(View v) {
        onBackPressed();
    }
}