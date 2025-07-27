import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class BurgerTests {

    private Ingredient ingredient;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Bun bun;

    @Before
    public void setUp() {
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        ingredient1 = Mockito.mock(Ingredient.class);
        ingredient2 = Mockito.mock(Ingredient.class);
    }

    @Test
    public void shouldSetBunCorrectly() {

        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);

        assertTrue("Ingredient was not added to the list",burger.ingredients.contains(ingredient));

    }

    @Test
    public void shouldRemoveIngredient() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.indexOf(ingredient));

        assertFalse("Ingredient was not removed from the list",burger.ingredients.contains(ingredient));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientFromEmptyList() {

        Burger burger = new Burger();
        burger.removeIngredient(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientWithInvalidIndex() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
    }

    @Test
    public void shouldMoveIngredient() {

        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 2);

        assertEquals("Ingredient was not moved to a specified index", burger.ingredients.get(2), ingredient);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientToInvalidIndex() {

        Burger burger = new Burger();

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 3);
    }

    @Test
    public void shouldFormatReceiptCorrectly() { //мб надо замокать ингредиент тайп

        Burger burger = new Burger();

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("wholegrain bun");
        Mockito.when(bun.getPrice()).thenReturn(5f);

        Mockito.when(ingredient.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getName()).thenReturn("mayonnaise");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.valueOf("SAUCE"));

        Mockito.when(ingredient1.getPrice()).thenReturn(20f);
        Mockito.when(ingredient1.getName()).thenReturn("chicken");
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.valueOf("FILLING"));

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        String actualReceipt = burger.getReceipt();

        String expectedReceipt = "(==== wholegrain bun ====)\r\n" +
                "= sauce mayonnaise =\r\n" +
                "= filling chicken =\r\n" +
                "(==== wholegrain bun ====)\r\n\r\n" +
                "Price: 40.000000\r\n";

        assertEquals(expectedReceipt, actualReceipt);
        }
    }
