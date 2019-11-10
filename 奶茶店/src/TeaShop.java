import java.util.ArrayList;
import java.util.Calendar;

public class TeaShop implements Shop
{
    public ArrayList<Bubble> bubbles=new ArrayList<Bubble>();
    public ArrayList<Coconut> coconuts=new ArrayList<Coconut>();

    private void adding(Bubble b)//进货
    {
        bubbles.add(b);
    }
    private void adding(Coconut c)//进货
    {
        coconuts.add(c);
    }

    @Override
    public boolean addingredient(Ingredient ingredient)//进货方法，true为进货成功
    {
        if(ingredient instanceof Bubble)
        {
            if(!isExpired((Bubble)ingredient))
            {
                adding((Bubble)ingredient);
                return true;
            }
            return false;
        }
        else if(ingredient instanceof Coconut)
        {
            if(!isExpired((Coconut)ingredient))
            {
                adding((Coconut)ingredient);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean isExpired(Bubble b)//判断是否过期，true为过期
    {
        Calendar now=Calendar.getInstance();
        Calendar b_data=b.getProduction_date();
        b_data.add((Calendar.DAY_OF_MONTH+1),b.getShelf_life());
        return now.after(b_data);
    }

    private boolean isExpired(Coconut b)//判断是否过期，true为过期
    {
        Calendar now=Calendar.getInstance();
        Calendar b_data=b.getProduction_date();
        b_data.add((Calendar.DAY_OF_MONTH+1),b.getShelf_life());
        return now.after(b_data);
    }

    @Override
    public void sellmilktea(String milkname,String ingname) throws SoldOutException
    {
        int len;
        if(ingname=="Bubble")
        {
            Bubble b;
            while(true)
            {
                len=bubbles.size();
                if(len==0)
                    throw new SoldOutException("Bubble没货了！//仅测试用");
                b=bubbles.get(0);
                bubbles.remove(0);
                if(!isExpired(b))
                    break;
            }
        }
        else if(ingname=="Coconut")
        {
            Coconut c;
            while(true)
            {
                len=coconuts.size();
                if(len==0)
                    throw new SoldOutException("Coconut没货了！//仅测试用");
                c=coconuts.get(0);
                coconuts.remove(0);
                if(!isExpired(c))
                    break;
            }
        }
    }
}