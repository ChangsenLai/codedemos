package com.csl.codedemos.rxjava;

import android.support.annotation.NonNull;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by ChangsenLai on 2017/4/23.
 */

public class RxJavaGroup {

    public void merge() {
        Subscription a = Observable.just("A")
                .compose(RxJavaUtil.<String>schedulerTransformer()).subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("RxJavaGroup -> merge() -> justA -> onNext()", getThreadName() + s);
                    }
                });
        Observable.just(1).compose(RxJavaUtil.<Integer>schedulerTransformer()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer s) {
                Log.i("RxJavaGroup -> merge() -> just1 onNext()", getThreadName() + s);
            }
        });
    }

    private String getThreadName() {
        return Thread.currentThread().getName() + " ";
    }
}
