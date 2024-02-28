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

    @PutMapping("/update")
    public boolean update(@RequestBody Food food) {
        return foodService.update(food);
    }

    @GetMapping("/findById")
    public Food findById(@RequestParam Long id) {
        return foodService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Food> getAll() {
        return foodService.findAll();
    }
}
