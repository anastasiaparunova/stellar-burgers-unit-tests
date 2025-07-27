import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class ParameterizedBurgerTest {

    private final float bunPrice;
    private final List<Float> ingredientPrices;
    private final float totalPrice;

    public ParameterizedBurgerTest(float bunPrice, List<Float> ingredientPrices, float totalPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrices = ingredientPrices;
        this.totalPrice = totalPrice;
    }

    @Parameterized.Parameters(name = "Bun: {0}, Ingredients: {1}, Total price: {2}")
    public static Object[][] testData() {
        return new Object[][]{
                {3.0f, Arrays.asList(), 6.0f}, //Bun and no ingredients
                {2.5f, Arrays.asList(1.0f), 6.0f}, //Bun and one ingredient
                {2.0f, Arrays.asList(1.0f, 1.5f), 6.5f}, //Bun and two ingredients
                {0.0f, Arrays.asList(1.0f, 1.0f), 2.0f}, //No bun and two ingredients
                {0.0f, Arrays.asList(0.0f, 0.0f), 0.0f} // No bun and no ingredients
        };
    }

        @Test
        public void shouldCalculateCorrectTotalPrice () throws Exception {

            Bun bun = Mockito.mock(Bun.class);
            Mockito.when(bun.getPrice()).thenReturn(bunPrice);

            Burger burger = new Burger();
            burger.setBuns(bun);

            for (Float price : ingredientPrices) {
                Ingredient ingredient = Mockito.mock(Ingredient.class);
                Mockito.when(ingredient.getPrice()).thenReturn(price);
                burger.addIngredient(ingredient);
            }

            float actualPrice = burger.getPrice();
            assertEquals(totalPrice, actualPrice, 0.001f);
        }
    }
