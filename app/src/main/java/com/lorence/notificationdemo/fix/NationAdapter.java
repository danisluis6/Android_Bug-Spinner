package com.lorence.notificationdemo.fix;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by enclaveit on 15/06/2017.
 */

public class NationAdapter extends BaseAdapter{
    private ArrayList<String> allNation;
    private Context context;

    public NationAdapter(Context context, ArrayList<String> allNation) {
        this.context = context;
        this.allNation = allNation;
    }

    @Override
    public int getCount() {
        return allNation.size();
    }

    @Override
    public Object getItem(int position) {
        return allNation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_country_item, null);
            holder = new ViewHolder();
            holder.tvCountry = (TextView) convertView.findViewById(R.id.tvCountryName);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String country = allNation.get(position);
        holder.tvCountry.setText(country);
        return convertView;
    }

    class ViewHolder {
        TextView tvCountry;
    }
}
