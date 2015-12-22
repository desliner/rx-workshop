package com.griddynamics.workshop.rx;

import rx.Observable;
import rx.Subscriber;

import java.util.LinkedList;

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

        Observable<Integer> flatMapped = terminated.flatMap(_02_Modify::toDigits);

        print("numbers", numbers);
        print("even", even);
        print("odd", odd);
        print("paired", paired);
        print("multiplied", multiplied);
        print("terminated", terminated);
        print("flatMapped", flatMapped);
    }


    private static Observable<Integer> toDigits(int x) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (x > 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        return Observable.from(stack);
    }
}
