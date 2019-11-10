import java.util.Calendar;

public class Main{
    public static void main(String[] args)
    {
        Calendar data1=Calendar.getInstance();
        Calendar data2=Calendar.getInstance();
        Calendar data3;
        data1.set(2000,1,1);
        data2.set(2100,5,5);

        //测试Ingredient子类Bubble
        Ingredient b0=new Bubble();//抽象类多态
        Bubble b1=new Bubble();

        b0.setName("零号");//测试set函数
        b0.setProduction_date(data2);//2100.5.5
        b1.setName("一号");
        b1.setProduction_date(data1);//2000,1,1

        System.out.println("名字:"+b0.getName());//测试get函数
        data3=b0.getProduction_date();
        System.out.println("生产日期："+data3.get(Calendar.YEAR)+"年"+(data3.get(Calendar.MONTH))+"月"+data3.get(Calendar.DAY_OF_MONTH)+"日");
        System.out.println("保质期:"+b0.getShelf_life()+"天");
        System.out.println();

        System.out.println(b1.toString());//测试toString函数
        System.out.println();

        //测试Ingredient子类Coconut
        Ingredient c0=new Coconut();//抽象类多态
        Coconut c1=new Coconut();

        c0.setName("零号");//测试set函数
        c0.setProduction_date(data2);
        c1.setName("一号");
        c1.setProduction_date(data1);

        System.out.println("名字:"+c0.getName());//测试get函数
        data3=c0.getProduction_date();
        System.out.println("生产日期："+data3.get(Calendar.YEAR)+"年"+(data3.get(Calendar.MONTH))+"月"+data3.get(Calendar.DAY_OF_MONTH)+"日");
        System.out.println("保质期:"+c0.getShelf_life()+"天");
        System.out.println();

        System.out.println(c1.toString());//测试toString函数
        System.out.println();

        //测试奶茶类MilkTea
        MilkTea m0=new MilkTea();
        MilkTea m1=new MilkTea();

        m0.setName("奶茶零号");//测试set函数及多态
        m0.setIngredient(b0);
        m1.setName("奶茶一号");
        m1.setIngredient(c0);

        System.out.println("名字："+m0.getName());//测试get函数
        System.out.println("配料："+m0.getIngredient());
        System.out.println();

        System.out.println(m1.toString());//测试toString函数
        System.out.println();

        //测试Shop接口及其实现类TeaShop
        TeaShop t0=new TeaShop();
        if(t0.addingredient(b0))//测试进货函数
            System.out.println(b0.getName()+"进货成功！");//2100.5.5
        else
            System.out.println(b0.getName()+"进货失败！");

        if(t0.addingredient(b1))//2000,1,1
            System.out.println(b1.getName()+"进货成功！");
        else
            System.out.println(b1.getName()+"进货失败！");

        if(t0.addingredient(c0))//2100.5.5
            System.out.println(c0.getName()+"进货成功！");
        else
            System.out.println(c0.getName()+"进货失败！");

        if(t0.addingredient(c1))//2000,1,1
            System.out.println(c1.getName()+"进货成功！");
        else
            System.out.println(c1.getName()+"进货失败！");
        System.out.println();

        //测试异常类的抛出与捕获
        try
        {
            t0.sellmilktea("一号奶茶","Bubble");
            System.out.println("一号奶茶卖出成功！");
            t0.sellmilktea("二号奶茶","Bubble");
            System.out.println("二号奶茶卖出成功！");
        }
        catch (SoldOutException s)
        {
            System.out.println("捕获到异常！//仅测试用");
            System.out.println(s.getError());
        }
        finally
        {
            System.out.println();
        }

        try
        {
            t0.sellmilktea("三号奶茶","Coconut");
            System.out.println("三号奶茶卖出成功！");
            t0.sellmilktea("四号奶茶","Coconut");
            System.out.println("四号奶茶卖出成功！");
        }
        catch (SoldOutException s)
        {
            System.out.println("捕获到异常！//仅测试用");
            System.out.println(s.getError());
        }
    }
}