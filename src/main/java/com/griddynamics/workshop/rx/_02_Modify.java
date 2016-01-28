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

        Observable<Integer> numbers = Observable.range(1, 10); // TODO: emit numbers 1 to 10

        Observable<Integer> even = numbers.filter(x -> x % 2 == 0); // TODO: filter even numbers

        Observable<Integer> odd = numbers.filter(x -> x % 2 == 1); // TODO: filter odd numbers

        Observable<Integer> paired = Observable.zip(even, odd, (a,b) -> a+b); // TODO: pair even and odd numbers adding them together (1st even + 1st odd, 2nd even + 2nd odd, etc)

        Observable<Integer> skipped = paired.skip(2); // TODO: skip first 2 items from paired

        Observable<Integer> appended = skipped.concatWith(Observable.just(42)); // TODO: append 42 to the end of skipped

        Observable<Integer> multiplied = appended.map(x -> x * 10); // TODO: multiply each number from appended by 10

        Observable<Integer> digits = multiplied.flatMap(_02_Modify::toDigits); // TODO: transform multiplied observable of numbers to observable of their digits

        Observable<Integer> max = digits.reduce(Math::max); // TODO: find maximum digit

        Observable<Integer> sum = digits.reduce((x, acc) -> x + acc); // TODO: sum all digits

        print("numbers", numbers);
        print("even", even);
        print("odd", odd);
        print("paired", paired);
        print("skipped", skipped);
        print("appended", appended);
        print("multiplied", multiplied);
        print("digits", digits);
        print("max", max);
        print("sum", sum);
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
