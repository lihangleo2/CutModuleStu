package com.lihang.basemodule.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by leo
 * on 2019/7/19.
 * 主要是针对自己封装OkHttp
 */
public class MyApplication extends Application {
    private static MyApplication context;
    //ARouter 调试开关
    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (isDebugARouter) {
            //下面2行必须卸载ARouter init 之间，否则无效
            //打印日志
            ARouter.openLog();
            //开启调试模式(如果在InstantRun的模式下必须开启，线上必须关闭)
            ARouter.openDebug();
        }

        // 官方建议在Application中初始化
        ARouter.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    public static Context getContext() {
        return context;
    }

}
