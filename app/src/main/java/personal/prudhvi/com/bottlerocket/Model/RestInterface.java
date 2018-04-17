package personal.prudhvi.com.bottlerocket.Model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by prudhvimandapati on 3/23/18.
 */

public interface RestInterface {

        @GET("/BR_Android_CodingExam_2015_Server/stores.json")
        Call<StoreList> getStores();

    }
