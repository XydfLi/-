public class SoldOutException extends Exception
{
    //注意：以下内容仅测试用
    String error;
    public SoldOutException(String s)
    {
        error=s;
    }
    public String getError()
    {
        return error;
    }
    //注意：以上内容仅测试用
}
