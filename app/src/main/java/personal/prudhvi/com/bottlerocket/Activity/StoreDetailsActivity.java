package personal.prudhvi.com.bottlerocket.Activity;

/**
 * Created by prudhvimandapati on 3/25/18.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import personal.prudhvi.com.bottlerocket.Core.StoreDetailsContract;
import personal.prudhvi.com.bottlerocket.Core.StoreDetailsPresenter;
import personal.prudhvi.com.bottlerocket.Model.Utils;
import personal.prudhvi.com.bottlerocket.R;

public class StoreDetailsActivity extends AppCompatActivity implements StoreDetailsContract{
    private Bundle storeDetailBundle;
    private String address, city, state, zip, phone, storeid, storelogourl;
    private ImageView img_storelogo;
    private TextView txt_address;
    private TextView txt_city;
    private TextView txt_state;
    private TextView txt_zip;
    private TextView txt_phone;
    private TextView txt_storeid;
    private StoreDetailsPresenter storeDetailsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_details);
        img_storelogo = (ImageView) findViewById(R.id.img_storelogo);
        txt_address = (TextView) findViewById(R.id.txt_address);
        txt_city = (TextView) findViewById(R.id.txt_city);
        txt_state = (TextView) findViewById(R.id.txt_state);
        txt_zip = (TextView) findViewById(R.id.txt_zip);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        txt_storeid = (TextView) findViewById(R.id.txt_storeid);

        storeDetailsPresenter = new StoreDetailsPresenter(this);
    }

    @Override
    public void showDetails() {
        storeDetailBundle = getIntent().getBundleExtra(Utils.BUNDLE_KEY);
        if(storeDetailBundle != null){
            if(storeDetailBundle.getString(Utils.STORE_LOGO_URL) != null){
                storelogourl = storeDetailBundle.getString(Utils.STORE_LOGO_URL);
                img_storelogo.setImageResource(Integer.parseInt(storelogourl));
            }

            if(storeDetailBundle.getString(Utils.ADDRESS) != null){
                address = storeDetailBundle.getString(Utils.ADDRESS);
                txt_address.setText(address);
            }

            if(storeDetailBundle.getString(Utils.CITY) != null){
                city = storeDetailBundle.getString(Utils.CITY);
                txt_city.setText(city);
            }

            if(storeDetailBundle.getString(Utils.STATE) != null){
                state = storeDetailBundle.getString(Utils.STATE);
                txt_state.setText(state);
            }

            if(storeDetailBundle.getString(Utils.ZIPCODE) != null){
                zip = storeDetailBundle.getString(Utils.ZIPCODE);
                txt_zip.setText(zip);
            }

            if(storeDetailBundle.getString(Utils.PHONE_NUMBER) != null){
                phone = storeDetailBundle.getString(Utils.PHONE_NUMBER);
                txt_phone.setText(phone);
            }

            if(storeDetailBundle.getString(Utils.STOREID) != null){
                storeid = storeDetailBundle.getString(Utils.STOREID);
                txt_storeid.setText(storeid);
            }
        }
    }

}
