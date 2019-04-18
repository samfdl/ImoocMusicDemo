package com.samfdl.imoocmusicdemo.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.samfdl.imoocmusicdemo.R;

public class PlayMusicView extends FrameLayout {
    private Context mContext;

    private View mView;
    private ImageView mIvIcon;

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

        mIvIcon = mView.findViewById(R.id.iv_icon);

        addView(mView);
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