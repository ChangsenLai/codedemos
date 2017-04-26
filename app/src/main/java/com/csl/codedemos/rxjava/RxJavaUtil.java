package com.csl.codedemos.rxjava;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ChangsenLai on 2017/4/23.
 */

public class RxJavaUtil {

    private RxJavaUtil() {}

    public static <T> Observable.Transformer<T, T> schedulerTransformer() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
