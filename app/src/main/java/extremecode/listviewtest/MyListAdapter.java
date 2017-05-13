package extremecode.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Junaid Hassan on 07-May-17.
 */

public class MyListAdapter extends ArrayAdapter<ListModel> {

    //members
    private int count = 0;

    //default constructor
    public MyListAdapter(Context context, ArrayList<ListModel> model) {
        super(context, R.layout.items, model);
    }

    //getview here
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //ViewHolder
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.items, parent, false);
            viewHolder.itemNameTxt = (TextView) convertView.findViewById(R.id.item);
            viewHolder.quantityTxt = (TextView) convertView.findViewById(R.id.quantity);
            viewHolder.tickImage = (ImageView) convertView.findViewById(R.id.arrow);
            viewHolder.plusImage = (ImageView) convertView.findViewById(R.id.plus);
            viewHolder.containerLayout = (RelativeLayout) convertView.findViewById(R.id.containerLayout);
            //set the tag
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //get the position from model
        ListModel model = getItem(position);

        if (model != null) {
            viewHolder.itemNameTxt.setText(model.itemName);
            viewHolder.quantityTxt.setText(model.quantity);
        }

        //plus click
        viewHolder.plusImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the quantity
                int quantityNo = Integer.parseInt(viewHolder.quantityTxt.getText().toString());
                quantityNo += 1;
                viewHolder.quantityTxt.setText(Integer.toString(quantityNo));
            }
        });

        //layout click
       /* viewHolder.containerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*count += 1;
                if (count == 1) {
                    viewHolder.tickImage.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.tickImage.setVisibility(View.INVISIBLE);
                    count = 0;
                }*//*

            }
        });*/

        //convertview Click
        /*convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                if (count == 1) {
                    viewHolder.tickImage.setVisibility(View.GONE);
                } else {
                    viewHolder.tickImage.setVisibility(View.VISIBLE);
                    count = 0;
                }
            }
        });*/

        //return the convertView here
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    //the view holder class
    private static class ViewHolder {
        public TextView itemNameTxt;
        public TextView quantityTxt;
        public ImageView tickImage;
        public ImageView plusImage;
        public RelativeLayout containerLayout;
    }
}
