package seminars.seminar1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Маркет U-Market
 */
public class UMarket {

    //region Методы

    /***
     * Вернут товар из списка по индексу
     * @param <T>
     */

    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index) {
        /*
        int counter = 1;
        for (var thing : things) {
            if (clazz.isAssignableFrom(thing.getClass())) { //проверяем на тип и добавляем в коллекцию
                if (index == counter++) {
                    return (T) thing;
                }
            }
        }
        return null;
*/
        AtomicInteger counter = new AtomicInteger(1);
        return things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index == counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);

    }

    /***
     * Вернут список товаров по типу
     * @param <T>
     */

    public <T extends Thing> Collection<T> getThings(Class<T> clazz) {
        /*
        Collection<T> list = new ArrayList<>();
        for (var thing : things) {
            if (clazz.isAssignableFrom(thing.getClass())) { //проверяем на тип и добавляем в коллекцию
                list.add((T) thing);
            }
        }
        return list;*/
        return things.stream().filter(clazz::isInstance).map(clazz::cast).collect(Collectors.toList());

    }

    /***
     * Распечатать список товаров по типу
     * @param <T>
     */
    public <T extends Thing> void printThings(Class<T> clazz) {
        int[] counter = {1};
        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if (Food.class.isAssignableFrom(thing.getClass())) { // вернет истину, если класс слева совпадает с суперклассом/суперинтерфейсом в правой, т.е. является ли допустим курица Food?
                        System.out.printf("[%d] %s (Белки: %s Жиры:%s Углеводы: %s)\n", counter[0]++, thing.getName(),
                                ((Food) thing).getProteins() ? "Да" : "Нет", ((Food) thing).getFats() ? "Да" : "Нет",
                                ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
                    } else {
                        System.out.printf("[%d] %s \n", counter[0]++, thing.getName());
                    }
                });
/*
        int index = 1; // нумерования вещей
        for (var thing : things) {
            if (clazz.isInstance(thing)) {
                if (Food.class.isAssignableFrom(thing.getClass())) { // вернет истину, если класс слева совпадает с суперклассом/суперинтерфейсом в правой, т.е. является ли допустим курица Food?
                    System.out.printf("[%d] %s (Белки: %s Жиры:%s Углеводы: %s)\n", index++, thing.getName(),
                            ((Food) thing).getProteins() ? "Да" : "Нет", ((Food) thing).getFats() ? "Да" : "Нет",
                            ((Food) thing).getCarbohydrates() ? "Да" : "Нет");
                } else {
                    System.out.printf("[%d] %s \n", index++, thing.getName());
                }
            }
        }
*/
    }


    private void initializeThings() {
        things.add(new Pen());
        things.add(new Notebook());

        things.add(new Chiken());
        things.add(new Fruit());
        things.add(new OliveOil());

        things.add(new BalykCheese());
        things.add(new Crisps());
        things.add(new ChocolateBar());

        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
        things.add(new Cheburek());

    }

    //region Констурктор

    public UMarket() {
        things = new ArrayList<>();
        initializeThings();
    }

    //endregion

    //endregion

    //region Поля

    /**
     * Товары в магазине
     */

    private final Collection<Thing> things;


    //endregion

}
