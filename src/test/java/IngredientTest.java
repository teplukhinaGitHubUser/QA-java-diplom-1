
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientTest {
    Ingredient ingredient;

    @Test
    public void getName() {
        ingredient = new Ingredient(IngredientType.FILLING, "test name", 12.12f);
        assertEquals("test name", ingredient.getName());
    }

    @Test
    public void getPrice() {
        ingredient = new Ingredient(IngredientType.FILLING, "test name", 12.12f);
        assertEquals(12.12f, ingredient.getPrice(), 0.0);
    }

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    public void getType(IngredientType ingredientType) {
        ingredient = new Ingredient(ingredientType, "test name", 12.12f);
        assertEquals(ingredientType, ingredient.getType());
    }
}
