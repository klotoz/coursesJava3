package homework1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] arr = {"qwe", "rty", "uio", "pas", "dfg", "hjk"};
        //Integer[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Массив: " + Arrays.toString(arr));
        swapElements(arr, 3, 2);
        System.out.println(Arrays.toString(arr));



        List<String> list = convertToList(arr);
        System.out.println("Преобразовали в ArrayList: " + list);



        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox = new Box();
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());
        orangeBox1.add(new Orange());



        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }


        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();



        System.out.println("Вес коробки 1 с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес коробки 2 с апельсинами: " + orangeBox2.getWeight());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());

        System.out.println("Сравниваем вес orangeBox1 и appleBox: " + orangeBox1.compare(appleBox));
        System.out.println("Сравниваем вес orangeBox2 и appleBox: " + orangeBox2.compare(appleBox));

        orangeBox1.transfer(orangeBox2);

        orangeBox1.info();
        orangeBox2.info();
        appleBox.info();



    }

    private static <T> void swapElements(T[] array, int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <R>List<R> convertToList(R[] array) {
        return Arrays.asList(array);
    }
}

