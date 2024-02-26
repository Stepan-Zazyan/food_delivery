package food.service;

import food.model.Food;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@FeignClient(name = "food", url = "${source-api-url}")
public interface FoodProxy {

    @PostMapping
    Food create(@RequestBody Food food);

    @GetMapping("/getAll")
    Collection<Food> getAll();

    @GetMapping("/findById")
    Optional<Food> findById(int id);

    @GetMapping("/getByName")
    List<Food> getByName(@RequestParam String name);

    @DeleteMapping
    void delete(@RequestParam int id);

    @PutMapping
    ResponseEntity<HttpStatus> update(@RequestParam int id, @RequestBody Food food);
}
