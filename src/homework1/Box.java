package homework1;

import java.util.ArrayList;
import java.util.Arrays;


class Box<T extends Fruit> {

   private ArrayList<T> list;

   public Box(T ... list) {
       this.list = new ArrayList<T>(Arrays.asList(list));
   }

   public void add(T ... list){
       this.list.addAll(Arrays.asList(list));
   }



   /*public ArrayList<T> getList() {
       return new ArrayList<T>(list);
   }*/

   public void clear() {
       list.clear();
   }

    void info() {
        if (list.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            System.out.println("В коробке находятся " + list.get(0).toString() + " в количестве: " + list.size());
        }
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeight();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.list.addAll(this.list);
        clear();
    }

}
