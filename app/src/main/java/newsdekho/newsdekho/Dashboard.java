package newsdekho.newsdekho;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Dashboard extends AppCompatActivity {

    GridView androidGridView;
    private FirebaseAuth auth;

    String[] gridViewString = {
            "Business", "Entertainment", "Technology", "Science", "Sports", "Health","Jokes","Weather",
            "Horoscope","Apps"

    } ;
    int[] gridViewImageId = {
            R.drawable.ic_business, R.drawable.ic_entertainment, R.drawable.ic_technology, R.drawable.ic_science, R.drawable.ic_sports, R.drawable.ic_health,
            R.drawable.ic_jokes, R.drawable.ic_weather, R.drawable.ic_horoscope, R.drawable.ic_apps

    };



    EditText searchView;
    private ListView lv;
    ArrayAdapter<String> adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

//        String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
//                "iPhone 4S", "Samsung Galaxy Note 800",
//                "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro","Dell Inspiron_new"};


//        lv = (ListView) findViewById(R.id.list_view);
//        searchView =findViewById(R.id.search);
//
//        // Adding items to listview
//        adapter = new ArrayAdapter<String>(this, R.layout.country_list_item, R.id.country_name, products);
//        lv.setAdapter(adapter);

        /**
         * Enabling Search Filter
         * */


//        searchView.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                // When user changed the Text
//                Dashboard.this.adapter.getFilter().filter(cs);
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                          int arg3) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable arg0) {
//                // TODO Auto-generated method stub
//            }
//        });


        TextView tv=findViewById(R.id.username);
        assert user != null;
        tv.setText("Hi, "+user.getDisplayName());

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(Dashboard.this, gridViewString, gridViewImageId);
        androidGridView=findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
               // Toast.makeText(Dashboard.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();

               switch (i){
                   case 0:
                       startActivity(new Intent(Dashboard.this,BusinessActivity.class));
                       break;
                   case 1:
                       startActivity(new Intent(Dashboard.this,EntertainmentActivity.class));
                       break;
                   case 2:
                       startActivity(new Intent(Dashboard.this,TechnologyActivity.class));
                       break;

                   case 3:
                       startActivity(new Intent(Dashboard.this,ScienceActivity.class));
                       break;

                   case 4:
                       startActivity(new Intent(Dashboard.this,SportsActivity.class));
                       break;

                   case 5:
                       startActivity(new Intent(Dashboard.this,Healthactivity.class));
                       break;

                   case 6:
                       startActivity(new Intent(Dashboard.this,JokesActivity.class));
                       break;

                   case 7:
                       startActivity(new Intent(Dashboard.this,WeatherActivity.class));
                       break;

                   case 8:
                       startActivity(new Intent(Dashboard.this,HoroscopeActivity.class));
                       break;

                   case 9:
                       startActivity(new Intent(Dashboard.this,AppsActivity.class));
                       break;

               }


            }
        });

    }
}