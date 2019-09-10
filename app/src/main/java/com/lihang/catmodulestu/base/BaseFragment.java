package com.lihang.catmodulestu.base;

import android.os.Bundle;
import android.view.View;

import com.lihang.basemodule.base.BaseModuleFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by leo
 * on 2019/9/9.
 */
public abstract class BaseFragment extends BaseModuleFragment {
    //处理逻辑业务
    protected abstract void processLogic(Bundle savedInstanceState);

    private Unbinder mUnbinder;

    @Override
    protected void processModuleLogic(Bundle savedInstanceState) {
        mUnbinder = ButterKnife.bind(this, mContentView);
        processLogic(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
