package com.lihang.chatmodule;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lihang.basemodule.Common.Constance;
import com.lihang.basemodule.base.BaseModuleActivity;

/**
 * Created by leo
 * on 2019/9/9.
 */
@Route(path = Constance.ACTIVITY_CHATDETAIL_PATH)
public class ChatDetailActivity extends BaseModuleActivity {
    @Override
    public int getContentViewId() {
        return R.layout.activity_chat_detail;
    }

    @Override
    protected void processModuleLogic() {

    }

    @Override
    public void onClick(View v) {

    }
}
