package com.csl.codedemos.rxjava;

import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ChangsenLai on 2017/4/21.
 */

public class RxJavaSchedulers {

    /**
     * ObserveOn可以指定接下来变换的线程和observer的线程，subscribeOn来指定subscribe的线程（第一个起作用）
     */
    public void controlScheduler() {
        Observable.just("a")
                .subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        showThreadName("map call-");
                        return "map a";
                    }
                }).observeOn(Schedulers.io()).map(new Func1<String, Object>() {
            @Override
            public Object call(String s) {
                showThreadName("map2 call-");
                return s;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object s) {
                        showThreadName("subscribe call-");
                    }
                });
    }

    private void showThreadName(String str) {
        log(str + " thread:" + Thread.currentThread().getName());
    }

    private void log(String str) {
        Log.i("RxJavaSchedulers", str);
    }
}
