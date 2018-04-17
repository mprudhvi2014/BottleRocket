package personal.prudhvi.com.bottlerocket.Core;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import personal.prudhvi.com.bottlerocket.Model.RestInterface;
import personal.prudhvi.com.bottlerocket.Model.StoreList;
import personal.prudhvi.com.bottlerocket.Model.Stores;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prudhvimandapati on 3/23/18.
 */

public class Intractor implements GetDataContract.Interactor{
    private GetDataContract.onGetDataListener mOnGetDatalistener;
      List<Stores> storeNames = new ArrayList<>();
      List<String> storeNamesList = new ArrayList<>();

    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sandbox.bottlerocketapps.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RestInterface request = retrofit.create(RestInterface.class);
        retrofit2.Call<StoreList> call = request.getStores();
        call.enqueue(new retrofit2.Callback<StoreList>() {
            @Override
            public void onResponse(retrofit2.Call<StoreList> call, retrofit2.Response<StoreList> response) {
                StoreList jsonResponse = response.body();
                storeNames = jsonResponse.getStores();
                for(int i=0;i<storeNames.size();i++){
                    storeNamesList.add(storeNames.get(i).getName());
                }
                Log.d("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size: " + storeNamesList.size(), storeNames);
       }

            @Override
                public void onFailure(retrofit2.Call<StoreList> call, Throwable t) {
                Log.v("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}
