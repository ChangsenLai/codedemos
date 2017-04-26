package com.csl.codedemos.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by ChangsenLai on 2017/4/21.
 * Observable convert
 */

public class RxJavaConvertDemo {

    /**
     * 将原来的Observable转化为新的Observable，发送事件时的数据得到了改变
     */
    public void map() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        }).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return 10;
            }
        });
    }

    /**
     * 将原来的Observable转换为新的Observable，发送的数据转换为新的Observable并执行事件发送
     */
    public void flatMap() {
        Observable.create(new Observable.OnSubscribe<String[]>() {
            @Override
            public void call(Subscriber<? super String[]> subscriber) {

            }
        }).flatMap(new Func1<String[], Observable<?>>() {
            @Override
            public Observable<?> call(String[] strings) {
                return Observable.from(strings);
            }
        });
    }

    /**
     * 将原来的Observable转换为新的Observable，自定的新的Observable特性
     */
    public void compose() {
        //  线程调度的经典引用

        //  创建一个线程控制的ObservableTransformer(可以将这个封装为工具类)
        Observable.Transformer<Object, Object> transformer = new Observable.Transformer<Object, Object>() {
            @Override
            public Observable<Object> call(Observable<Object> objectObservable) {
                return objectObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };

        //  通过compose进行转换
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {

            }
        }).compose(transformer);
    }

}
