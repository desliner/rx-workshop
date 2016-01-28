package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import static com.griddynamics.workshop.rx.Utils.print;

/**
 * @author Max Myslyvtsev
 * @since 1/27/16
 */
public class _03_Modify_Advanced {

    public static void main(String[] args) {

        Observable<Integer> o1 = Observable.range(1, 10); // TODO: emit numbers from 1 to 5

        Observable<Integer> o2 = o1.map(x -> {
            if (x % 2 == 0) {
                return x / 2;
            } else {
                return x * 3;
            }
        }); // TODO: modify o1 that even numbers are divided by 2, odd numbers are multiplied by 3

        Observable<Integer> o3 = o2.flatMap(x -> {
            if (x % 2 == 0) {
                return Observable.just(x, 1);
            } else {
                return Observable.just(x);
            }
        }); // TODO: modify o2 to emit 1 after all even items in addition to existing items

        Observable<Integer> o4 = o3.lift(new Observable.Operator<Integer, Integer>() {
            @Override
            public Subscriber<? super Integer> call(Subscriber<? super Integer> subscriber) {
                return new Subscriber<Integer>(subscriber) {
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
                        if (integer.equals(15)) {
                            subscriber.onNext(integer);
                            subscriber.onCompleted();
                            unsubscribe();
                        } else {
                            subscriber.onNext(integer);
                        }
                    }
                };
            }
        }); // TODO: modify o3 that all items after item 15 are discarded

        Observable<Integer> o5 = o4.count(); // TODO: emit number of items in o4


        print("o1", o1);
        print("o2", o2);
        print("o3", o3);
        print("o4", o4);
        print("o5", o5);
    }
}
