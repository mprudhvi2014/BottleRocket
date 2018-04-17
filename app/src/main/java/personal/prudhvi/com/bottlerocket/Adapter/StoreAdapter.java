package personal.prudhvi.com.bottlerocket.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import personal.prudhvi.com.bottlerocket.Core.GetDataContract;
import personal.prudhvi.com.bottlerocket.Model.Stores;
import personal.prudhvi.com.bottlerocket.Model.Utils;
import personal.prudhvi.com.bottlerocket.R;

/**
 * Created by prudhvimandapati on 3/22/18.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private Context context;
    private List<Stores> list = new ArrayList<>();
    private GetDataContract.View mGetDataView;

    public StoreAdapter(Context context, List<Stores> list, GetDataContract.View mGetDataView){
        this.context = context;
        this.list = list;
        this.mGetDataView = mGetDataView;
    }
    @Override
    public StoreAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.storeName.setText(list.get(position).getName());
        holder.store_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(Utils.ADDRESS, list.get(position).getAddress());
                bundle.putString(Utils.CITY, list.get(position).getCity());
                bundle.putString(Utils.STATE, list.get(position).getState());
                bundle.putString(Utils.ZIPCODE, list.get(position).getZipcode());
                bundle.putString(Utils.PHONE_NUMBER, list.get(position).getPhone());
                bundle.putString(Utils.STOREID, list.get(position).getStoreID());
                mGetDataView.onItemClickedListener(bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView storeName;
        LinearLayout store_layout;
        public MyViewHolder(View itemView) {
            super(itemView);
            storeName = (TextView)itemView.findViewById(R.id.tv_store_name);
            store_layout = (LinearLayout)itemView.findViewById(R.id.store_layout);
        }
    }
}

