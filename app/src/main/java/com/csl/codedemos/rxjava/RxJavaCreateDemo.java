package com.csl.codedemos.rxjava;


import rx.Observable;
import rx.Subscriber;

/**
 * Created by ChangsenLai on 2017/4/21.
 * Observable create
 */

public class RxJavaCreateDemo {

    /**
     * 创建一个Observable
     */
    public void create() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                // do nothing
            }
        });
    }

    /**
     * 创建并依次发送事件
     */
    public void just() {
        Observable.just("a", "b", "c");
    }

    /**
     * 创建并依次发送数组元素
     */
    public void from() {
        String[] strs = new String[] {"a", "b", "c"};
        Observable.from(strs);
    }

}
