package food.controller;

import food.dto.FoodDto;
import food.mapper.FoodMapper;
import food.model.Food;
import food.service.FoodDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public double getTotalPrice(List<Integer> listFoodIds) {
        return foodService.getTotalPrice(listFoodIds);
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
    public void delete(Food food) {
        foodService.delete(food);
    }


}
