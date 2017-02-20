package com.fanyafeng.wechat.home.find;

import android.content.Context;

/**
 * Author： fanyafeng
 * Data： 17/2/20 上午11:56
 * Email: fanyafeng@live.cn
 */
public class FindPresenter implements FindContract.Presenter{
    private Context context;
    private FindContract.View findView;

    public FindPresenter(Context context, FindContract.View findView) {
        this.context = context;
        this.findView = findView;
        findView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
