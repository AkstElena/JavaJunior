package seminars.seminar1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class CartV2<T extends Food> {
    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public CartV2(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры:%s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет", food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */
    public void cardBalancingV2() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        proteins = foodstuffs.stream().anyMatch(Food::getProteins);
        fats = foodstuffs.stream().anyMatch(Food::getFats);
        carbohydrates = foodstuffs.stream().anyMatch(Food::getCarbohydrates);

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }
        if (!proteins) {
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(Food::getProteins).findAny().get());
            proteins = true;
        }

        if (!fats) {
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(Food::getFats).findAny().get());
            fats = true;
        }

        if (!carbohydrates) {
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(Food::getCarbohydrates).findAny().get());
            carbohydrates = true;
        }

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else System.out.println("Невозможно сбалансировать корзину по БЖУ.");


    }
}
