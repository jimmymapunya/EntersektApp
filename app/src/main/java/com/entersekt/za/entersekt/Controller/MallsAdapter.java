package com.entersekt.za.entersekt.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.entersekt.entersekt_app_library.Model.Malls;
import com.entersekt.za.R;

import java.util.ArrayList;

public class MallsAdapter extends ArrayAdapter<Malls>{

    private ArrayList<Malls> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
    }

    public MallsAdapter(Context context, ArrayList<Malls> data) {
        super(context, R.layout.activity_main, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Malls dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.malls_item, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.tvCity);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(""+dataModel.getName());

        return convertView;
    }
}

