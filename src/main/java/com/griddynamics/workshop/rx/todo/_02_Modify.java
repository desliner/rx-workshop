package com.griddynamics.workshop.rx.todo;

import rx.Observable;
import rx.Subscriber;

import java.util.LinkedList;

import static com.griddynamics.workshop.rx.Utils.print;

/**
 * @author Max Myslyvtsev
 * @since 9/17/15
 */
public class _02_Modify {

    public static void main(String[] args) throws Exception {
        Observable<Integer> numbers = Observable.range(1, 10);

        Observable<Integer> even = null; // TODO: filter even numbers

        Observable<Integer> odd = null; // TODO: filter odd numbers

        Observable<Integer> sum = null; // TODO: sum pairs of even and odd numbers (1st even + 1st odd, 2nd even + 2nd odd, etc)


        Observable<Integer> multiplied = null; // TODO: multiply each number from sum by 10

        Observable<Integer> terminated = null; // TODO: terminate the multiplied sequence if item is > 100

        Observable<Integer> digits = null; // TODO: transform terminated observable of numbers to observable of their digits

        print("numbers", numbers);
        print("even", even);
        print("odd", odd);
        print("sum", sum);
        print("multiplied", multiplied);
        print("terminated", terminated);
        print("digits", digits);
    }
}
