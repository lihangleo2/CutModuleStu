package com.lihang.homemodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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
@Route(path = Constance.FRAGMENT_HOME_PATH)
public class HomeFragemnt extends BaseModuleFragment {
    private Button btn_home;
    private RelativeLayout relative_back;

    private TextView txt_home;

    @Autowired(name = "wo")
    String testindex;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void processModuleLogic(Bundle savedInstanceState) {
        btn_home = mContentView.findViewById(R.id.btn_home);
        txt_home = mContentView.findViewById(R.id.txt_home);
        relative_back = mContentView.findViewById(R.id.relative_back);

        btn_home.setOnClickListener(this);
        if (testindex.equals("1")){
            txt_home.setText("首页 -- " + testindex);
            relative_back.setBackgroundColor(getResources().getColor(R.color.white));
        }else if (testindex.equals("3")){
            txt_home.setText("搜索 -- " + testindex);
            relative_back.setBackgroundColor(getResources().getColor(R.color.blue));
        }else {
            txt_home.setText("我的 -- " + testindex);
            relative_back.setBackgroundColor(getResources().getColor(R.color.green));
        }
    }


    @Override
    public void onClick(View v) {
        ARouter.getInstance().build(Constance.ACTIVITY_HOMEDETAIL_PATH).navigation();
    }
}
