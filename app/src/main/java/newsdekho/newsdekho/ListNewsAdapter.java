package newsdekho.newsdekho;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Smarakjeet on 6/1/2018.
 */

class ListNewsAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder = null;
        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holder.galleryImage = convertView.findViewById(R.id.galleryImage);
            holder.author = convertView.findViewById(R.id.author);
            holder.title = convertView.findViewById(R.id.title);
            holder.sdetails =  convertView.findViewById(R.id.sdetails);
            holder.time =  convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.author.setId(position);
        holder.title.setId(position);
        holder.sdetails.setId(position);
        holder.time.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try{
            holder.author.setText(song.get(HomeActivity.KEY_AUTHOR));
            holder.title.setText(song.get(HomeActivity.KEY_TITLE));
            holder.time.setText(song.get(HomeActivity.KEY_PUBLISHEDAT));
//            holder.sdetails.setText(song.get(HomeActivity.KEY_DESCRIPTION));

        if (song.get(HomeActivity.KEY_DESCRIPTION).toString().length()<5){
            holder.sdetails.setVisibility(View.GONE);
        }
        else {
            holder.sdetails.setText(song.get(HomeActivity.KEY_DESCRIPTION));
        }

            if(song.get(HomeActivity.KEY_URLTOIMAGE).toString().length() < 5)
            {
               // holder.galleryImage.setVisibility(View.GONE);
                holder.galleryImage.setImageResource(R.drawable.ic_error_black_24dp);
            }else{
                Picasso.get()
                        .load(song.get(HomeActivity.KEY_URLTOIMAGE).toString())
                        .resize(300, 200)
                        .into(holder.galleryImage);
            }
        }catch(Exception e) {}
        return convertView;
    }
}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView author, title, sdetails, time;
}