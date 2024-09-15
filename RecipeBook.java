import java.util.ArrayList;
import java.util.Scanner;

class Recipe {
    
    private String name;
    private String ingredients;
    private String instructions;

    public Recipe(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "Recipe Name: " + name + "\nIngredients: " + ingredients + "\nInstructions: " + instructions;
    }
}

public class RecipeBook {
    private ArrayList<Recipe> recipes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addRecipe() {
        System.out.println("Enter recipe name:");
        String name = scanner.nextLine();
        System.out.println("Enter ingredients:");
        String ingredients = scanner.nextLine();
        System.out.println("Enter instructions:");
        String instructions = scanner.nextLine();

        Recipe recipe = new Recipe(name, ingredients, instructions);
        recipes.add(recipe);
        System.out.println("Recipe added successfully!");
    }

    public void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (Recipe recipe : recipes) {
                System.out.println(recipe);
                System.out.println("-------------------");
            }
        }
    }

    public void deleteRecipe() {
        System.out.println("Enter the name of the recipe to delete:");
        String name = scanner.nextLine();

        Recipe toRemove = null;
        for (Recipe recipe : recipes) {
            if (recipe.getName().equalsIgnoreCase(name)) {
                toRemove = recipe;
                break;
            }
        }

        if (toRemove != null) {
            recipes.remove(toRemove);
            System.out.println("Recipe deleted successfully!");
        } else {
            System.out.println("Recipe not found.");
        }
    }

    public static void main(String[] args) {
        RecipeBook recipeBook = new RecipeBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nRecipe Book Application");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Delete Recipe");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    recipeBook.addRecipe();
                    break;
                case 2:
                    recipeBook.viewRecipes();
                    break;
                case 3:
                    recipeBook.deleteRecipe();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}