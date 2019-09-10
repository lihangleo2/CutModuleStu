package com.lihang.chatmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lihang.basemodule.Common.Constance;
import com.lihang.basemodule.base.BaseModuleFragment;


/**
 * Created by leo
 * on 2019/9/9.
 */
@Route(path = Constance.FRAGMENT_CHAT_PATH)
public class ChatFragemnt extends BaseModuleFragment {
    private Button btn_home;

    private TextView txt_home;

    @Autowired(name = "wo")
    String testindex;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void processModuleLogic(Bundle savedInstanceState) {
        btn_home = mContentView.findViewById(R.id.btn_home);
        txt_home = mContentView.findViewById(R.id.txt_home);
        txt_home.setText("聊天 -- " + testindex);
        btn_home.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        ARouter.getInstance().build(Constance.ACTIVITY_CHATDETAIL_PATH).navigation();
    }
}
