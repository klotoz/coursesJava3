package homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    private static final int CARS_COUNT = 4;
    static final int HALF_CARS_COUNT = CARS_COUNT / 2;


        public static void main (String[]args){
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT+1);
            CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier, countDownLatch);
            }
            for (Car car : cars) {
                new Thread(car).start();
            }
            try {
                cyclicBarrier.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                cyclicBarrier.await();
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
