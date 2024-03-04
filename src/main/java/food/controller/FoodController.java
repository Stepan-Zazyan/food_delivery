package food.controller;

import food.dto.FoodDto;
import food.mapper.FoodMapper;
import food.model.Food;
import food.service.FoodDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodDataService foodService;

    @PostMapping("/save")
    public Food save(@RequestBody FoodDto foodDto) {
        Food food = new FoodMapper().getFood(foodDto);
        return foodService.save(food);
    }

    @GetMapping("/findById")
    public Food findById(@RequestParam Long id) {
        return foodService.findById(id);
    }

    @GetMapping("/totalPrice")
    public double getTotalPrice(Map<Long, Integer> foodIdsAndQuantity) {
        return foodService.getTotalPrice(foodIdsAndQuantity);
    }

    @GetMapping("/getAll")
    public List<Food> getAll() {
        return foodService.findAll();
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Food food) {
        return foodService.update(food);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Food food) {
        foodService.delete(food);
    }


}
