package com.lihang.homemodule;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lihang.basemodule.Common.Constance;
import com.lihang.basemodule.base.BaseModuleActivity;


/**
 * Created by leo
 * on 2019/9/9.
 */
@Route(path = Constance.ACTIVITY_SELECT_HOME_PATH)
public class SelectHomeActivity extends BaseModuleActivity {
    RelativeLayout relative_tab_1;
    private FragmentManager fragmentManager;

    @Override
    public int getContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected void processModuleLogic() {
        relative_tab_1 = findViewById(R.id.relative_tab_1);
        relative_tab_1.setSelected(true);
        HomeFragemnt homeFragemnt = (HomeFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_HOME_PATH).withString("wo", "1").navigation();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.framLayout, homeFragemnt);
        ft.show(homeFragemnt);
        ft.commit();
    }


    @Override
    public void onClick(View v) {

    }
}
