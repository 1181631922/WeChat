package com.fanyafeng.wechat.home.main;

import android.content.Context;

/**
 * Author： fanyafeng
 * Data： 17/2/20 上午11:20
 * Email: fanyafeng@live.cn
 */
public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View mainView;

    public MainPresenter(Context context, MainContract.View mainView) {
        this.context = context;
        this.mainView = mainView;
        mainView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
