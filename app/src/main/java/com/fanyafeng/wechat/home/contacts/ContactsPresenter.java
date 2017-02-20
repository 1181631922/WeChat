package com.fanyafeng.wechat.home.contacts;

import android.content.Context;

import com.fanyafeng.wechat.home.main.MainContract;

/**
 * Author： fanyafeng
 * Data： 17/2/20 上午11:56
 * Email: fanyafeng@live.cn
 */
public class ContactsPresenter implements ContactsContract.Presenter {
    private Context context;
    private ContactsContract.View contactsView;

    public ContactsPresenter(Context context, ContactsContract.View contactsView) {
        this.context = context;
        this.contactsView = contactsView;
        contactsView.setPresenter(this);
    }


    @Override
    public void start() {

    }
}
