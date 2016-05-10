package com.example.pinal.myjsoncontact;

/**
 * Created by Pinal on 3/10/2016.
 */
        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.HashMap;

/**
 * Created by Pinal on 2/22/2016.
 */
public class Adapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<HashMap<String,String>> data;

    HashMap<String,String> result = new HashMap<String,String>();

    public Adapter(Context context, ArrayList<HashMap<String,String>> list) {

        this.context = context;
        this.data = list;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView id;
        TextView name;
        TextView email;
        TextView address;
        TextView gen;
        TextView mob;
        TextView home;
        TextView office;


        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder")
        View view = layoutInflater.inflate(R.layout.simple_list_disp,parent,false);


        id=(TextView) view.findViewById(R.id.id);
        name=(TextView) view.findViewById(R.id.name);
        email=(TextView)view.findViewById(R.id.email);
        address=(TextView)view.findViewById(R.id.address);
        gen=(TextView)view.findViewById(R.id.gen);
        mob=(TextView)view.findViewById(R.id.mob);
        home=(TextView)view.findViewById(R.id.home);
        office=(TextView)view.findViewById(R.id.office);


        result = data.get(position);

        id.setText(result.get("strid"));
        name.setText(result.get("strfname"));
        email.setText(result.get("stremail"));
        address.setText(result.get("straddress"));

        gen.setText(result.get("gender"));
        mob.setText(result.get("smobile"));
        home.setText(result.get("shome"));
        office.setText(result.get("soffice"));

        return view;
    }
}
