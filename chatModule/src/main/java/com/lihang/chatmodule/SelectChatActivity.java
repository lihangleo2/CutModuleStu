package com.lihang.chatmodule;


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
@Route(path = Constance.ACTIVITY_SELECT_CHAT_PATH)
public class SelectChatActivity extends BaseModuleActivity {
    RelativeLayout relative_tab_2;
    private FragmentManager fragmentManager;

    @Override
    public int getContentViewId() {
        return R.layout.activity_select_chat;
    }

    @Override
    protected void processModuleLogic() {
        relative_tab_2 = findViewById(R.id.relative_tab_2);
        relative_tab_2.setSelected(true);
        ChatFragemnt homeFragemnt = (ChatFragemnt) ARouter.getInstance().build(Constance.FRAGMENT_CHAT_PATH).withString("wo","2").navigation();
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
