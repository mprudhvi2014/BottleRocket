package personal.prudhvi.com.bottlerocket.Model;

import java.util.List;

/**
 * Created by prudhvimandapati on 3/23/18.
 */

public class StoreList
{
    private List<Stores> stores;

    public List<Stores> getStores ()
    {
        return stores;
    }

    public void setStores (List<Stores> stores)
    {
        this.stores = stores;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stores = "+stores+"]";
    }
}
