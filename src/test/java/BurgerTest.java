import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {
    Bun bun = mock(Bun.class);
    Ingredient ingredient = mock(Ingredient.class);
    //List<Ingredient> ingredientList = mock(ArrayList.class);


    @Test
    public void setBun() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Ingredient myIngredient = mock(Ingredient.class, "myIngredient");
        Burger burger = new Burger();
        burger.ingredients.addAll(Arrays.asList(ingredient, myIngredient));
        burger.moveIngredient(1, 0);
        assertEquals("myIngredient", burger.ingredients.get(0).toString());
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(20.5f);
        when(ingredient.getPrice()).thenReturn(30f);
        assertEquals(71f, burger.getPrice());
    }

    @Test
    public void getReceipt() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredient);
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("my burger");
        when(bun.getPrice()).thenReturn(20.5f);
        when(ingredient.getPrice()).thenReturn(30f);
        when(ingredient.getName()).thenReturn("my ingredient");
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        String expected = ("(==== my burger ====)\r\n" +
                "= sauce my ingredient =\r\n" +
                "(==== my burger ====)\r\n" +
                "\r\nPrice: 71.000000\r\n");
        assertEquals(expected, burger.getReceipt());
    }
}
