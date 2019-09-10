package com.lihang.homemodule;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lihang.basemodule.Common.Constance;
import com.lihang.basemodule.base.BaseModuleActivity;

/**
 * Created by leo
 * on 2019/9/9.
 */
@Route(path = Constance.ACTIVITY_HOMEDETAIL_PATH)
public class HomeDetailActivity extends BaseModuleActivity {
    @Override
    public int getContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void processModuleLogic() {

    }


    @Override
    public void onClick(View v) {

    }
}
