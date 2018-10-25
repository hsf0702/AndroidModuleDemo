package com.wss.module.main.ui.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wss.common.base.adapter.BaseRcyAdapter;
import com.wss.common.base.adapter.holder.BaseRcyHolder;
import com.wss.common.base.adapter.listener.OnRcyItemClickListener;
import com.wss.module.main.R;
import com.wss.module.main.R2;
import com.wss.module.main.bean.MainBlock;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Describe：中间适配器
 * Created by 吴天强 on 2018/10/18.
 */

public class CenterRcyAdapter extends BaseRcyAdapter<MainBlock, CenterRcyAdapter.HomeVH> {


    public CenterRcyAdapter(Context mContext, List<MainBlock> mData, OnRcyItemClickListener listener) {
        super(mContext, mData, listener);
    }

    @Override
    protected HomeVH createVH(ViewGroup parent, int viewType) {
        return new HomeVH(View.inflate(mContext, R.layout.main_item_of_center_list, null));
    }


    //注意 在ViewHolder中使用ButterKnife时候 类不能是private
    public class HomeVH extends BaseRcyHolder<MainBlock> {

        @BindView(R2.id.tv_title)
        TextView tvTitle;

        @BindView(R2.id.tv_describe)
        TextView tvDescribe;

        @BindView(R2.id.iv_icon)
        ImageView ivIcon;

        HomeVH(View itemView) {
            super(itemView, listener);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindingData(MainBlock data, int position) {
            tvTitle.setText(data.getTitle());
            tvDescribe.setText(data.getDescribe());
            ivIcon.setBackgroundResource(data.getRes());
        }
    }
}
