package com.samfdl.imoocmusicdemo.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.samfdl.imoocmusicdemo.R;

public class PlayMusicView extends FrameLayout {
    private Context mContext;

    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon, mIvPlay, mIvNeedle;

    private Animation mPlayMusicAnim, mPlayNeedleAnim, mStopNeedleAnim;

    private boolean isPlaying;

    public PlayMusicView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PlayMusicView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext = context;

        mView = LayoutInflater.from(mContext).inflate(R.layout.play_music_view, this, false);

        mFlPlayMusic = mView.findViewById(R.id.fl_play_music);
        mFlPlayMusic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                trigger();
            }
        });
        mIvIcon = mView.findViewById(R.id.iv_icon);
        mIvPlay = mView.findViewById(R.id.iv_play);
        mIvNeedle = mView.findViewById(R.id.iv_needle);

        /**
         * 定义所需要执行的动画
         * 光盘转动的动画
         * 指针指向光盘的动画
         * 指针离开光盘的动画
         * startAnimation
         */
        mPlayMusicAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_music_anim);
        mPlayNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.play_needle_anim);
        mStopNeedleAnim = AnimationUtils.loadAnimation(mContext, R.anim.stop_needle_anim);

        addView(mView);
    }

    /**
     * 切换播放状态
     */
    private void trigger() {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic();
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic() {
        isPlaying = true;
        mIvPlay.setVisibility(GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvNeedle.startAnimation(mPlayNeedleAnim);
    }

    /**
     * 停止播放
     */
    public void stopMusic() {
        isPlaying = false;
        mIvPlay.setVisibility(VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);
    }

    /**
     * 设置光盘中显示的音乐封面图片
     */
    public void setMusicIcon(String icon) {
        Glide.with(mContext)
                .load(icon)
                .into(mIvIcon);
    }
}