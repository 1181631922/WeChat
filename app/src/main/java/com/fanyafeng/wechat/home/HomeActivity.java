package com.fanyafeng.wechat.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fanyafeng.wechat.R;
import com.fanyafeng.wechat.BaseActivity;
import com.fanyafeng.wechat.home.contacts.ContactsFragment;
import com.fanyafeng.wechat.home.contacts.ContactsPresenter;
import com.fanyafeng.wechat.home.find.FindFragment;
import com.fanyafeng.wechat.home.find.FindPresenter;
import com.fanyafeng.wechat.home.main.MainFragment;
import com.fanyafeng.wechat.home.main.MainPresenter;
import com.fanyafeng.wechat.home.personal.PersonalFragment;
import com.fanyafeng.wechat.home.personal.PersonalPresenter;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class HomeActivity extends BaseActivity {
    private static String[] FRAGMENT_TAGS = new String[]{"1", "2", "3", "4"};
    private View[] tabs = new View[4];

    private MainFragment mainFragment;
    private ContactsFragment contactsFragment;
    private FindFragment findFragment;
    private PersonalFragment personalFragment;

    private FragmentManager fragmentManager;

    private ImageView tab_img1;
    private TextView tab_text1;

    private ImageView tab_img2;
    private TextView tab_text2;

    private ImageView tab_img3;
    private TextView tab_text3;

    private ImageView tab_img4;
    private TextView tab_text4;

    private int current = 0;
    private int currentTab = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (savedInstanceState != null) {
            current = savedInstanceState.getInt("tab");
        } else {
            current = 0;
        }
        fragmentManager = getSupportFragmentManager();

        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_home);
        isSetNavigationIcon = false;

        initView();
        initData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (current != -1) {
            outState.putInt("tab", current);
        }
        super.onSaveInstanceState(outState);
    }

    //初始化UI控件
    private void initView() {
        tabs[0] = findViewById(R.id.tab_one);
        tab_img1 = (ImageView) findViewById(R.id.tab_img1);
        tab_text1 = (TextView) findViewById(R.id.tab_text1);

        tabs[1] = findViewById(R.id.tab_two);
        tab_img2 = (ImageView) findViewById(R.id.tab_img2);
        tab_text2 = (TextView) findViewById(R.id.tab_text2);

        tabs[2] = findViewById(R.id.tab_three);
        tab_img3 = (ImageView) findViewById(R.id.tab_img3);
        tab_text3 = (TextView) findViewById(R.id.tab_text3);

        tabs[3] = findViewById(R.id.tab_four);
        tab_img4 = (ImageView) findViewById(R.id.tab_img4);
        tab_text4 = (TextView) findViewById(R.id.tab_text4);

        for (int i = 0; i < tabs.length; i++) {
            final int j = i;
            tabs[i].setTag(i);
            tabs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectTab(j);
                }
            });
        }
        selectTab(current);
    }

    private void selectTab(int tab) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tab) {
            case 0:
                if (currentTab != 0) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text1.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    tab_img4.setImageResource(R.drawable.simle_logo_00);
                    if (mainFragment == null) {
                        mainFragment = new MainFragment();
                        new MainPresenter(this, mainFragment);
                        fragmentTransaction.add(R.id.container, mainFragment, FRAGMENT_TAGS[0]);
                    } else {
                        fragmentTransaction.show(mainFragment);
                    }
                    current = 0;
                    currentTab = 0;
                }
                break;
            case 1:
                if (currentTab != 1) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text2.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    tab_img4.setImageResource(R.drawable.simle_logo_00);
                    if (contactsFragment == null) {
                        contactsFragment = new ContactsFragment();
                        new ContactsPresenter(this, contactsFragment);
                        fragmentTransaction.add(R.id.container, contactsFragment, FRAGMENT_TAGS[1]);
                    } else {
                        fragmentTransaction.show(contactsFragment);
                    }
                    current = 1;
                    currentTab = 1;
                }
                break;
            case 2:
                if (currentTab != 2) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text3.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    tab_img4.setImageResource(R.drawable.simle_logo_00);
                    if (findFragment == null) {
                        findFragment = new FindFragment();
                        new FindPresenter(this, findFragment);
                        fragmentTransaction.add(R.id.container, findFragment, FRAGMENT_TAGS[2]);
                    } else {
                        fragmentTransaction.show(findFragment);
                    }
                    current = 2;
                    currentTab = 2;
                }
                break;
            case 3:
                if (currentTab != 3) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text4.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    tab_img4.setImageResource(R.drawable.simle_logo_00);
                    if (personalFragment == null) {
                        personalFragment = new PersonalFragment();
                        new PersonalPresenter(this, personalFragment);
                        fragmentTransaction.add(R.id.container, personalFragment, FRAGMENT_TAGS[3]);
                    } else {
                        fragmentTransaction.show(personalFragment);
                    }
                    current = 3;
                    currentTab = 3;
                }
                break;
        }
        fragmentTransaction.commit();
    }

    //初始化数据
    private void initData() {

    }

    /**
     * 设置为默认颜色
     */
    private void clearTabSelection() {
        tab_text1.setTextColor(Color.RED);
        tab_text2.setTextColor(Color.RED);
        tab_text3.setTextColor(Color.RED);
        tab_text4.setTextColor(Color.RED);
    }

    private void hideFragement(FragmentTransaction fragmentTransaction) {
        if (mainFragment != null) {
            fragmentTransaction.hide(mainFragment);
        }
        if (contactsFragment != null) {
            fragmentTransaction.hide(contactsFragment);
        }
        if (findFragment != null) {
            fragmentTransaction.hide(findFragment);
        }
        if (personalFragment != null) {
            fragmentTransaction.hide(personalFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base, menu);
        //        默认隐藏setting按钮
        if (toolbar != null) {
            MenuItem menuItem0 = toolbar.getMenu().getItem(0);
            if (menuItem0 != null) {
                menuItem0.setTitle("查找");
                menuItem0.setIcon(R.drawable.icon_find_32);
                menuItem0.setVisible(true);
            }
            MenuItem menuItem1 = toolbar.getMenu().getItem(1);
            if (menuItem1 != null) {
                menuItem1.setTitle("添加");
                menuItem1.setIcon(R.drawable.icon_add_32);
                menuItem1.setVisible(true);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.menu_one:
                break;
            case R.id.menu_two:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
