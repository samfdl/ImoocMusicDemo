package com.samfdl.imoocmusicdemo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.samfdl.imoocmusicdemo.R;
import com.samfdl.imoocmusicdemo.activitys.PlayMusicActivity;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {
    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;

    public MusicListAdapter(Context context, RecyclerView recyclerView) {
        mContext = context;
        mRv = recyclerView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(mContext)
                .load("http://res.lgdsunday.club/poster-1.png")
                .into(viewHolder.ivIcon);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    /**
     * 1、获取ItemView的高度
     * 2、itemView的数量
     * 3、使用 itemViewHeight * itemViewNum = RecyclerView的高度
     */
    private void setRecyclerViewHeight() {
        if (isCalcaulationRvHeight || mRv == null) return;

        isCalcaulationRvHeight = true;

//        获取ItemView的高度
        RecyclerView.LayoutParams itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
//        itemView的数量
        int itemCount = getItemCount();
//        使用 itemViewHeight * itemViewNum = RecyclerView的高度
        int recyclerViewHeight = itemViewLp.height * itemCount;
//        设置RecyclerView高度
        LinearLayout.LayoutParams rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
}