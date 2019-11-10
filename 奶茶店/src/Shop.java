public interface Shop
{
    public abstract boolean addingredient(Ingredient ingredient);//进货方法,false为进货失败
    public void sellmilktea(String milkname,String ingname) throws SoldOutException;//出售奶茶方法
}