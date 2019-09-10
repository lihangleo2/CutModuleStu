package com.lihang.catmodulestu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lihang.basemodule.base.BaseModuleActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by leo
 * on 2019/9/9.
 */
public abstract class BaseActivity extends BaseModuleActivity {

    protected abstract void processLogic();

    private Unbinder mUnbinder;


    @Override
    protected void processModuleLogic() {
        mUnbinder = ButterKnife.bind(this);
        processLogic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
