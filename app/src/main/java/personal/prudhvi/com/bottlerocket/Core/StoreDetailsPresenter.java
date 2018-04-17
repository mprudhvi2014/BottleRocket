package personal.prudhvi.com.bottlerocket.Core;



/**
 * Created by prudhvimandapati on 3/25/18.
 */

public class StoreDetailsPresenter {
    private StoreDetailsContract mContract;

    public StoreDetailsPresenter(StoreDetailsContract mContract ){
        this.mContract = mContract;
        mContract.showDetails();
    }

}
