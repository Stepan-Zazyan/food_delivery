package food.service;

import food.error.FoodNotFoundException;
import food.model.Food;
import food.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodDataService {

    private final FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.saveAndFlush(food);
    }

    public boolean update(Food food) {
        Food foodToBeUpdated = foodRepository.findById(food.getId()).get();
        foodToBeUpdated.setTitle(food.getTitle());
        foodToBeUpdated.setPrice(food.getPrice());
        return !foodToBeUpdated.equals(food);
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

    public double getTotalPrice(List<Integer> listFoodIds) {
        List<Food> listFood = foodRepository.findAllById(listFoodIds);
        return listFood.stream()
                .mapToDouble(Food::getPrice)
                .sum();
    }
}
