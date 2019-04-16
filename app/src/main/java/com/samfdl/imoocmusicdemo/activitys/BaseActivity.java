package com.samfdl.imoocmusicdemo.activitys;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.samfdl.imoocmusicdemo.R;

public class BaseActivity extends Activity {
    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;

    /**
     * findViewById
     *
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T fd(@IdRes int id) {
        return findViewById(id);
    }

    /**
     * 初始化NavigationBar
     *
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack, String title, boolean isShowMe) {
        mIvBack = fd(R.id.iv_back);
        mTvTitle = fd(R.id.tv_title);
        mIvMe = fd(R.id.iv_me);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.INVISIBLE);
        mTvTitle.setText(title);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.INVISIBLE);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}