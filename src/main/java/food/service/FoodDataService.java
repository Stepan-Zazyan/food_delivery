package food.service;

import food.model.Food;
import food.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodDataService {

    private final FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public boolean update(Food food) {
        Food foodToBeUpdated = foodRepository.findById(Math.toIntExact(food.getId())).get();
        foodToBeUpdated.setTitle(food.getTitle());
        foodToBeUpdated.setPrice(food.getPrice());
        return !foodToBeUpdated.equals(food);
    }

    public Optional<Food> findById(Long id) {
        return foodRepository.findById(Math.toIntExact(id));
    }

    public Collection<Food> findAll() {
        return (List<Food>) foodRepository.findAll();
    }
}
