package food.controller;

import food.model.Food;
import food.service.FoodDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodDataService foodService;

    @PostMapping("/save")
    public Food save(@RequestBody Food food) {
        return foodService.save(food);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Food food) {
        return foodService.update(food);
    }

    @GetMapping("/findById")
    public Food findById(@RequestParam Long id) {
        return foodService.findById(id).get();
    }

    @GetMapping("/getAll")
    public Collection<Food> getAll() {
        return foodService.findAll();
    }
}
