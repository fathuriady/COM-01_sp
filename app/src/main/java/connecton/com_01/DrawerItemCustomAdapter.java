package connecton.com_01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fathuriady on 11/12/16.
 */

public class DrawerItemCustomAdapter extends ArrayAdapter<DataModel> {
    Context mContext;
    int layoutResourceId;
    DataModel data[] = null;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, DataModel[] data){
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId,parent,false);
        TextView txtViewCat = (TextView) listItem.findViewById(R.id.txtViewCat);
        ImageView imgViewIcon = (ImageView) listItem.findViewById(R.id.imgViewIcon);

        DataModel folder = data[position];

        //imgViewIcon.setImageResource(folder.icon);
        txtViewCat.setText(folder.name);

        return listItem;
    }
}
