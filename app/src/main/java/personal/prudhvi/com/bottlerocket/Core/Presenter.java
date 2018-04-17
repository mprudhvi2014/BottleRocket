package personal.prudhvi.com.bottlerocket.Core;

import android.content.Context;

import java.util.List;

import personal.prudhvi.com.bottlerocket.Model.Stores;

/**
 * Created by prudhvimandapati on 3/23/18.
 */

public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {
    private GetDataContract.View mGetDataView;
    private Intractor mIntractor;
    public Presenter(GetDataContract.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
        }
    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context,url);
        }


    @Override
    public void onSuccess(String message, List<Stores> storeNamesList) {
        mGetDataView.onGetDataSuccess(message, storeNamesList);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
        }
        }
