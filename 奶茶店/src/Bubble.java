import java.util.Calendar;

public class Bubble extends Ingredient
{
    public Bubble()//保质期仅为7天
    {
        shelf_life=7;
    }

    @Override
    public void setName(String name)
    {
        this.name=name+"Bubble";
    }

    @Override
    public void setProduction_date(Calendar c) {
        this.production_date=c;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Calendar getProduction_date() {
        return this.production_date;
    }

    @Override
    public int getShelf_life() {
        return this.shelf_life;
    }

    @Override
    public String toString()
    {
        return "name:"+name+";production_date："+production_date.get(Calendar.YEAR)+"年"+(production_date.get(Calendar.MONTH))+"月"+production_date.get(Calendar.DAY_OF_MONTH)+"日;shelf_life:"+shelf_life+"天";
    }
}
