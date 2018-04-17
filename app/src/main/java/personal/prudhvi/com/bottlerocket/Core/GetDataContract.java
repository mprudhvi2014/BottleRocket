package personal.prudhvi.com.bottlerocket.Core;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import personal.prudhvi.com.bottlerocket.Model.Stores;

/**
 * Created by prudhvimandapati on 3/23/18.
 */

public interface GetDataContract {
    interface View {
        void onGetDataSuccess(String message, List<Stores> list);

        void onGetDataFailure(String message);

        void onItemClickedListener(Bundle bundle);
    }

    interface Presenter {
        void getDataFromURL(Context context, String url);
    }

    interface Interactor {
        void initRetrofitCall(Context context, String url);

    }

    interface onGetDataListener {
        void onSuccess(String message, List<Stores> list);

        void onFailure(String message);
    }

    interface onStoreItemListener{

        void onStoreItemClicked(Bundle bundle);
    }

}
