package newsdekho.newsdekho;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class JokesActivity extends AppCompatActivity {

    private String API_URL="http://api.icndb.com/jokes/random";
    TextView joketxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        joketxt=findViewById(R.id.joke);
        Button jokebtn=findViewById(R.id.jokebutton);
        jokebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask<String,Void,String> asyncTask= new AsyncTask<String, Void, String>() {

                    ProgressDialog progressDialog=new ProgressDialog(JokesActivity.this);

                    @Override
                    protected void onPreExecute() {
                        progressDialog.setTitle("Wait....");
                        progressDialog.show();
                    }

                    @Override
                    protected String doInBackground(String... strings) {

                        Helper helper=new Helper();
                        return helper.getHTTPData(API_URL);

                    }

                    @Override
                    protected void onPostExecute(String s) {
                        ChuckNorris chuckNorris=new Gson().fromJson(s,ChuckNorris.class);
                        joketxt.setText(chuckNorris.value.joke);

                    }
                };

                asyncTask.execute();
            }
        });


    }
}
