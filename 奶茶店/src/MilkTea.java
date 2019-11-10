public class MilkTea
{
    public String name;
    Ingredient ingredient;

    public void setName(String name)
    {
        this.name=name;
    }

    public void setIngredient(Ingredient ingredient)
    {
        this.ingredient=ingredient;
    }

    public String getName()
    {
        return this.name;
    }

    public Ingredient getIngredient()
    {
        return this.ingredient;
    }

    public String toString()
    {
        return "name="+name+";ingredient:("+ingredient.toString()+")";
    }
}
