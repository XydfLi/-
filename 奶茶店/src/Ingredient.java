import java.util.Calendar;

public abstract class Ingredient
{
    protected String name;
    protected Calendar production_date;//生产日期
    protected int shelf_life;//保质期

    public abstract void setName(String name);
    public abstract void setProduction_date(Calendar c);
    public abstract String getName();
    public abstract Calendar getProduction_date();
    public abstract int getShelf_life();
    public abstract String toString();
}
