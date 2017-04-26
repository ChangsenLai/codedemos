package com.csl.codedemos;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ChangsenLai on 2017/4/21.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    public void test() {
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

    public void showThreadName(String str) {
        log(str + " thread:" + Thread.currentThread().getName());
    }

    public void log(String str) {
        Log.i("MainActivity", str);
    }


}
































