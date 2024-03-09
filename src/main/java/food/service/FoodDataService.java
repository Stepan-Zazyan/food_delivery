package food.service;

import food.error.FoodNotFoundException;
import food.model.Food;
import food.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodDataService {

    private final FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.saveAndFlush(food);
    }


    public void update(Food food) {
        Food foodToBeUpdated = foodRepository.findById(food.getId()).get();
        foodToBeUpdated.setTitle(food.getTitle());
        foodToBeUpdated.setPrice(food.getPrice());
        foodRepository.save(foodToBeUpdated);
    }

    public Food findById(Long id) {
        Optional<Food> foodOptional = foodRepository.findById(id);
        if (foodOptional.isPresent()) {
            return foodOptional.get();
        } else {
            throw new FoodNotFoundException("Food not found with id: " + id);
        }
    }

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public void delete(Food food) {
        foodRepository.delete(food);
    }

    public double getTotalPrice(Map<Long, Integer> foodIdsAndQuantity) {
        List<Long> listFoodIds = foodIdsAndQuantity.keySet().stream().toList();
        List<Food> listFood = foodRepository.findByIdIn(listFoodIds);
        return listFood.stream()
                .mapToDouble(food -> food.getPrice() * foodIdsAndQuantity.get(food.getId()))
                .sum();
    }
}
