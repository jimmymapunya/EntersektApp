package com.entersekt.za.entersekt.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.entersekt.entersekt_app_library.Model.Cities;
import com.entersekt.entersekt_app_library.Utils;
import com.entersekt.za.R;
import java.util.ArrayList;

public class CitiesAdapter extends ArrayAdapter<Cities> {

    private ArrayList<Cities> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        Button btnShops;
    }

    public CitiesAdapter(Context context, ArrayList<Cities> data) {
        super(context, R.layout.city_items, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Cities dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.city_items, null, false);
            viewHolder.txtName = convertView.findViewById(R.id.tvCity);

            viewHolder.btnShops = convertView.findViewById(R.id.btnShops);
            viewHolder.btnShops.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Utils.alertDialogShow(mContext, dataModel.getMalls().get(position).getName(),
//                            dataModel.getMalls().get(position).getShops().get(position).getName());
                }
            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.txtName.setText(""+dataModel.getName());

        return convertView;
    }
}

