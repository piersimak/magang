package diginetmedia.com.sikedes.adapter;

/**
 * Created by PIER on 7/25/2016.
 */
import android.app.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.*;
import android.support.annotation.DrawableRes;
import android.widget.*;
import java.util.*;
import android.graphics.*;
import android.view.*;
import android.content.*;

import diginetmedia.com.sikedes.R;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Integer> bitmapList;

    public ImageAdapter(Context context, ArrayList<Integer> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    public int getCount() {
        return this.bitmapList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(this.context);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT ));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else {
            imageView = (ImageView) convertView;
        }
        Drawable myImage = context.getResources().getDrawable( this.bitmapList.get(position) );
        imageView.setImageDrawable(resize(myImage));//setImageBitmap(this.bitmapList.get(position));
        return imageView;
    }
    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, true);
        return new BitmapDrawable(bitmapResized);
    }

}