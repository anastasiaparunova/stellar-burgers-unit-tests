import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    @Test
    public void shouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "chicken", 1f);
        assertEquals("chicken", ingredient.getName());
    }

    @Test
    public void shouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "mayonnaise", 1f);
        assertEquals(1f, ingredient.getPrice(), 0.001f);
    }

    @Test
    public void shouldReturnCorrectType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "mayonnaise", 1f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
