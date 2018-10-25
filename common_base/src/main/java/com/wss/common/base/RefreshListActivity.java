package com.wss.common.base;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;

import com.wss.common.base.adapter.BaseRcyAdapter;
import com.wss.common.base.adapter.listener.OnRcyItemClickListener;
import com.wss.common.base.mvp.BasePresenter;
import com.wss.common.widget.pulltorefresh.OnPullRefreshListener;
import com.wss.common.widget.pulltorefresh.PullToRefreshLayout;

import butterknife.BindView;

/**
 * Describe：带下拉刷新 上拉加载更多的Activity
 * 内部实现为刷新控件 PullToRefreshLayout + 列表控件 RecyclerView
 * Created by 吴天强 on 2018/10/23.
 */
public abstract class RefreshListActivity<P extends BasePresenter> extends ActionBarActivity<P> implements OnPullRefreshListener, OnRcyItemClickListener {

    @BindView(R2.id.ptrl_list)
    PullToRefreshLayout refreshLayout;

    @BindView(R2.id.recycle_view)
    RecyclerView recyclerView;


    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @CallSuper
    @Override
    protected void initView() {
        refreshLayout.setOnPullRefreshListener(this);
        recyclerView.setLayoutManager(getLayoutManager());
        recyclerView.setAdapter(createAdapter());
    }

    @CallSuper
    @Override
    public void dismissLoading() {
        super.dismissLoading();
        stopRefresh();
        hideEmptyView();
    }

    /**
     * 停止刷新
     */
    protected void stopRefresh() {
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();

    }

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract BaseRcyAdapter createAdapter();
}
