package food.mapper;

import food.dto.FoodDto;
import food.model.Food;

public class FoodMapper {

    public FoodDto getDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setFoodTitle(food.getTitle());
        return foodDto;
    }

}
