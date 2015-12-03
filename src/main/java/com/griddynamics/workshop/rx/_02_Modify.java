package com.griddynamics.workshop.rx;

import com.google.common.collect.Lists;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import java.util.Arrays;
import java.util.List;

import static com.griddynamics.workshop.rx.Utils.*;

/**
 * @author Max Myslyvtsev
 * @since 9/17/15
 */
public class _02_Modify {

    public static void main(String[] args) throws Exception {
        Observable<Integer> numbers = Observable.range(1, 10);

        Observable<Integer> even = numbers.filter(x -> x % 2 == 0);
        Observable<Integer> odd = numbers.filter(x -> x % 2 != 0);

        Observable<Integer> paired = Observable.zip(even, odd, (x, y) -> x + y);

        Observable<Integer> multiplied = paired.map(x -> x * 10);

        Observable<Integer> terminated = multiplied.lift(subscriber -> new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                subscriber.onError(e);
            }

            @Override
            public void onNext(Integer integer) {
                if (integer > 100) {
                    subscriber.onCompleted();
                    unsubscribe();
                } else {
                    subscriber.onNext(integer);
                }
            }
        });

        Observable<Integer> flatMapped = terminated.flatMap(x -> Observable.range(x, 3));

        print("numbers", numbers);
        print("even", even);
        print("odd", odd);
        print("paired", paired);
        print("multiplied", multiplied);
        print("terminated", terminated);
        print("flatMapped", flatMapped);
    }
}
