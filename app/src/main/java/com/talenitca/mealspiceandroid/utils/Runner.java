package com.talenitca.mealspiceandroid.utils;

import com.talenitca.mealspiceandroid.data.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Runner {

    public static void main(String[] args) {

        Observable<Integer> data = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);

        Disposable d = data.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(System.out::println,
                        System.out::println);

        System.out.println("-------------------------------------------");
        System.out.println("Dependency Injection");
        System.out.println("-------------------------------------------");

        MyUtils myUtils = new MyUtils();
        System.out.println("test MyUtils: " + myUtils.welcomeCustomer("Kaushal"));
        System.out.println(TestUtils.getMockedRestaurantListBIG().get(0).getName());

        System.out.println("-------------------------------------------");
        System.out.println("Restaurant list demo");
        System.out.println("-------------------------------------------");

        List<Restaurant> mockRestaurants = TestUtils.getMockedRestaurantListBIG();
        Observable<Restaurant> restaurantObservable = Observable.fromIterable(mockRestaurants);

        Disposable d2 = restaurantObservable.subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .filter(restaurant -> restaurant.getRating() <= 4)
                .map(restaurant -> restaurant.getName() + "[Serving since " + restaurant.getEstablished() + "]")
                .subscribe(System.out::println,
                        throwable -> System.out.println(throwable.getMessage())
                );

        Scanner keyboardInput = new Scanner(System.in);
        System.out.println();
        System.out.println("Hit enter to exit the program...");
        String input = keyboardInput.next();
        System.out.println("Program terminated: input = " + input);
    }

    class PizzaMaker {

        private List<Condiment> condiments = getCondimentsLocally();
        private List<Cheese> cheeseList = getCheeseListLocally();

        private PizzaBase pizzaBase;

        public PizzaMaker(PizzaBase pizzaBase) {
            this.pizzaBase = pizzaBase;
        }

        void bakePizza(){
            System.out.println("Baking Pizza using: "
                    + pizzaBase
                    + condiments.toString()
                    + cheeseList.toString());
        }
    }


    private static List<Condiment> getCondimentsLocally(){
        return new ArrayList<>();
    }

    private static List<Cheese> getCheeseListLocally(){
        return new ArrayList<>();
    }

    class PizzaBase {}

    class Condiment{}

    class Cheese{}
}
