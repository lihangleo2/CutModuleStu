package com.lihang.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by leo
 * on 2019/9/9.
 */
public abstract class BaseModuleActivity extends AppCompatActivity implements View.OnClickListener {
    public abstract int getContentViewId();
    protected abstract void processModuleLogic();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ARouter.getInstance().inject(this);
        processModuleLogic();
    }


}
