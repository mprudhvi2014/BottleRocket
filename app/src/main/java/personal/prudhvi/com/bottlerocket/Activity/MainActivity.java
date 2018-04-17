package personal.prudhvi.com.bottlerocket.Activity;

/**
 * Created by prudhvimandapati on 3/22/18.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import personal.prudhvi.com.bottlerocket.Adapter.StoreAdapter;
import personal.prudhvi.com.bottlerocket.Core.GetDataContract;
import personal.prudhvi.com.bottlerocket.Core.Presenter;
import personal.prudhvi.com.bottlerocket.Model.Stores;
import personal.prudhvi.com.bottlerocket.Model.Utils;
import personal.prudhvi.com.bottlerocket.R;

public class MainActivity extends AppCompatActivity implements GetDataContract.View {
    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    StoreAdapter storeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<Stores> storeNamesList) {
        storeAdapter = new StoreAdapter(getApplicationContext(), storeNamesList, this);
        recyclerView.setAdapter(storeAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {
        Log.d("Status",message);
    }

    @Override
    public void onItemClickedListener(Bundle bundle) {
        if(bundle != null) {
            Intent intent = new Intent(this, StoreDetailsActivity.class);
            intent.putExtra(Utils.BUNDLE_KEY, bundle);
            startActivity(intent);
        }
    }
}
