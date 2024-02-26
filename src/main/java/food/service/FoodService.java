package food.service;

import food.model.Food;

import java.util.Collection;
import java.util.Optional;

public interface FoodService {

    Food save(Food food);

    Collection<Food> findAll();

    Optional<Food> findById(int id);

    boolean update(Food food);
}
