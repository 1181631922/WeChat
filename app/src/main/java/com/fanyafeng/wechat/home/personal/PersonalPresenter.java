package com.fanyafeng.wechat.home.personal;

import android.content.Context;

/**
 * Author： fanyafeng
 * Data： 17/2/20 上午11:56
 * Email: fanyafeng@live.cn
 */
public class PersonalPresenter implements PersonalContract.Presenter {
    private Context context;
    private PersonalContract.View personalView;

    public PersonalPresenter(Context context, PersonalContract.View personalView) {
        this.context = context;
        this.personalView = personalView;
        personalView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
