package com.samfdl.imoocmusicdemo.views;

import android.content.Context;
import android.media.MediaPlayer;
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
import com.samfdl.imoocmusicdemo.helps.MediaPlayerHelp;

public class PlayMusicView extends FrameLayout {
    private Context mContext;

    private View mView;
    private FrameLayout mFlPlayMusic;
    private ImageView mIvIcon, mIvPlay, mIvNeedle;

    private Animation mPlayMusicAnim, mPlayNeedleAnim, mStopNeedleAnim;

    private boolean isPlaying;

    private MediaPlayerHelp mMediaPlayerHelp;

    private String mPath;

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

        mMediaPlayerHelp = MediaPlayerHelp.getInstance(mContext);
    }

    /**
     * 切换播放状态
     */
    private void trigger() {
        if (isPlaying) {
            stopMusic();
        } else {
            playMusic(mPath);
        }
    }

    /**
     * 播放音乐
     */
    public void playMusic(String path) {
        mPath = path;
        isPlaying = true;
        mIvPlay.setVisibility(GONE);
        mFlPlayMusic.startAnimation(mPlayMusicAnim);
        mIvNeedle.startAnimation(mPlayNeedleAnim);

        /**
         * 判断当前音乐是否已经在播放
         * 如果当前音乐已经在播放，那么就直接执行start方法
         * 如果当前播放的音乐不是需要播放的音乐的话，那就调用setPath方法
         */
        if (mMediaPlayerHelp.getPath() != null
                && mMediaPlayerHelp.getPath().equals(path)) {
            mMediaPlayerHelp.start();
        } else {
            mMediaPlayerHelp.setPath(path);
            mMediaPlayerHelp.setOnMeidaPlayerHelperListener(new MediaPlayerHelp.OnMediaPlayerHelperListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayerHelp.start();
                }
            });
        }
    }

    /**
     * 停止播放
     */
    public void stopMusic() {
        isPlaying = false;
        mIvPlay.setVisibility(VISIBLE);
        mFlPlayMusic.clearAnimation();
        mIvNeedle.startAnimation(mStopNeedleAnim);

        mMediaPlayerHelp.pause();
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