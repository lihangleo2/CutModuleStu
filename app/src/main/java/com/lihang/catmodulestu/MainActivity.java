package com.lihang.catmodulestu;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lihang.basemodule.Common.Constance;
import com.lihang.basemodule.base.BaseModuleActivity;
import com.lihang.catmodulestu.base.BaseActivity;
import com.lihang.chatmodule.ChatFragemnt;
import com.lihang.homemodule.HomeFragemnt;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


//组件化其他都配置好了后
//1、我们先new 一个BaseModule，把共用类，联网，等一切丢进去，后面其他module还有app都需要引入这个module。记得要用config.gradle统一版本管理
//2、
@Route(path = Constance.ACTIVITY_MAIN_PATH)
public class MainActivity extends BaseActivity {

    private static final int HOME_ONE = 0;
    private static final int HOME_TWO = 1;
    private static final int HOME_THREE = 2;
    private static final int HOME_FOUR = 3;
    private int index;
    private int currentTabIndex = 0;

    @BindView(R.id.relative_tab_1)
    RelativeLayout relative_tab_1;
    @BindView(R.id.relative_tab_2)
    RelativeLayout relative_tab_2;
    @BindView(R.id.relative_tab_3)
    RelativeLayout relative_tab_3;
    @BindView(R.id.relative_tab_4)
    RelativeLayout relative_tab_4;
    private RelativeLayout[] mTabs;

    private FragmentManager manager;
    private ArrayList<Fragment> list_fragment = new ArrayList<Fragment>();

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic() {
        manager = getSupportFragmentManager();
        mTabs = new RelativeLayout[4];
        mTabs[0] = relative_tab_1;
        mTabs[1] = relative_tab_2;
        mTabs[2] = relative_tab_3;
        mTabs[3] = relative_tab_4;


//        初始化数据
        try {
            HomeFragemnt fragment_one = (HomeFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_HOME_PATH).withString("wo", "1").navigation();
            ChatFragemnt fragment_two = (ChatFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_CHAT_PATH).withString("wo", "2").navigation();
            HomeFragemnt fragment_three = (HomeFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_HOME_PATH).withString("wo", "3").navigation();
            HomeFragemnt fragment_four = (HomeFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_HOME_PATH).withString("wo", "4").navigation();

            list_fragment.add(fragment_one);
            list_fragment.add(fragment_two);
            list_fragment.add(fragment_three);
            list_fragment.add(fragment_four);
        } catch (Exception e) {
            e.printStackTrace();
        }
        switchFragment(R.id.relative_tab_1);
    }


    @Override
    public void onClick(View v) {

    }

    public void switchFragment(int id) {
        FragmentTransaction ft = manager.beginTransaction();
        //fragment切换带动画
//        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
//                android.R.anim.fade_in, android.R.anim.fade_out);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(id);
        String tag = (String) relativeLayout.getTag();
        Fragment f = manager.findFragmentByTag(tag);
        if (f == null) {
            int num = Integer.parseInt(tag);
            ft.add(R.id.framLayout, list_fragment.get(num), tag);
        }

        for (int i = 0; i < list_fragment.size(); i++) {
            Fragment fragment = list_fragment.get(i);
            if (fragment.getTag() != null) {
                if (fragment.getTag().equals(tag)) {
                    ft.show(fragment);
                } else {
                    ft.hide(fragment);
                }
            }
        }
        ft.commitAllowingStateLoss();
        switch (id) {
            case R.id.relative_tab_1://首页
                index = HOME_ONE;
                break;
            case R.id.relative_tab_2:
                index = HOME_TWO;
                break;
            case R.id.relative_tab_3:
                index = HOME_THREE;
                break;
            case R.id.relative_tab_4:
                index = HOME_FOUR;
                break;
        }
        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }


    @OnClick({R.id.relative_tab_1, R.id.relative_tab_2, R.id.relative_tab_3, R.id.relative_tab_4})
    public void onTabClick(View v) {
        switch (v.getId()) {
            case R.id.relative_tab_1:
                switchFragment(R.id.relative_tab_1);
                break;
            case R.id.relative_tab_2:
                switchFragment(R.id.relative_tab_2);
                break;
            case R.id.relative_tab_3:
                switchFragment(R.id.relative_tab_3);
                break;
            case R.id.relative_tab_4:
                switchFragment(R.id.relative_tab_4);
                break;
        }
    }
}
