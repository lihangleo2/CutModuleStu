package com.lihang.basemodule.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by leo
 * on 2019/9/9.
 */
public abstract class BaseModuleFragment extends Fragment implements View.OnClickListener {
    //获取当前fragment布局文件
    public abstract int getContentViewId();

    //处理逻辑业务
    protected abstract void processModuleLogic(Bundle savedInstanceState);

    protected View mContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            setContentView(inflater, getContentViewId());
            processModuleLogic(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }



    protected void setContentView(LayoutInflater inflater, @LayoutRes int layoutResID) {
        mContentView = inflater.inflate(layoutResID, null);
        ARouter.getInstance().inject(this);
    }


    //简单跳转
    public void transfer(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }


    //快速获取textView 或 EditText上文字内容
    public String getStringByUI(View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        } else if (view instanceof TextView) {
            return ((TextView) view).getText().toString().trim();
        }
        return "";
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
