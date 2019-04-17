package com.samfdl.imoocmusicdemo.views;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class WequalsHImageView extends AppCompatImageView {
    public WequalsHImageView(Context context) {
        super(context);
    }

    public WequalsHImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WequalsHImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

        // 获取View宽度
//        int width = MeasureSpec.getSize(widthMeasureSpec);
        // 获取View 模式 match_parent、wrap_content、具体dp
//        int mode = MeasureSpec.getMode(widthMeasureSpec);
    }
}