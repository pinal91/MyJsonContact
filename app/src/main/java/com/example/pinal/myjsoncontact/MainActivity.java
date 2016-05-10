package com.example.pinal.myjsoncontact;



        import android.app.ProgressDialog;

        import android.os.AsyncTask;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.ListView;
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Json js;
    ArrayList<HashMap<String,String>>  data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.lv);

        data=new ArrayList<HashMap<String, String>>();

        get g=new get();
        g.execute();
    }


    class get extends AsyncTask<Void,Void,Void>{

        String strfname,straddress,stremail,strid,gender,mobile,str1,str2;
        String idno,firstname,lastname,eid;
        ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd=new ProgressDialog(MainActivity.this);
            pd.setMessage("getting data");
            pd.setIndeterminate(false);
            pd.setCancelable(false);
            pd.show();

        }

        @Override
        protected Void doInBackground(Void... params) {


           String s = "http://hmkcode.appspot.com/rest/controller/get.json";
          //  String s = "http://raw.githubusercontent.com/mobilesiri/Android-Custom-Listview-Using-Volley/master/richman.json";

             Log.d("dataaaaaaa",s.toString());

            Json js=new Json();

           // Log.d("Async completed", "Done");
            // Log.d("database", "product comes" + s);

            String resp=js.display1(s);
            System.out.println("String response" + resp);

            if(resp!= null){
                try {



                  //Change test 
                    JSONObject  jobj=new JSONObject(resp);
                    JSONArray jarray=jobj.getJSONArray("articleList");

                   // Log.d("object json:",jobj.toString());

                  //  Log.d("array length", String.valueOf(jarray.length()));


                    for (int i=0;i<jarray.length();i++){

                        JSONObject jo=jarray.getJSONObject(i);
                        strid = jo.getString("title");
                        strfname = jo.getString("url");

                        JSONArray cat =jo.getJSONArray("categories");

                        for(int n = 0 ; n < cat.length(); n++){
                           // JSONObject flagarrayobject =cat.getJSONObject(n);
                            stremail=cat.getString(n);


                        }

                        JSONArray t =jo.getJSONArray("tags");

                        for(int k = 0 ; k < t.length(); k++){
                            //JSONObject flagarrayobject =cat.getString(n);
                            straddress=t.getString(k);
                          /*  str1=t.getString(1);

                            str2=t.getString(2);
*/


                        }
                            Log.d("tags test",straddress);
                     /*   Log.d("tags test",str2);

                        Log.d("tags test",str1);*/

                        // straddress = jo.getString("tags");


                        Log.d("object json:", jo.toString());
                        HashMap<String,String> map=new HashMap<String, String>();

                        map.put("strid",strid);
                        map.put("strfname",strfname);
                        map.put("stremail",stremail);
                        map.put("straddress",straddress);

                        data.add(map);

                        Log.d("map value ", String.valueOf(map));


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            if(pd.isShowing()){
                pd.dismiss();


            }
            Adapter an = new Adapter(MainActivity.this,data);
            Log.d("d", "d");
            lv.setAdapter(an);



        }


    }

}
