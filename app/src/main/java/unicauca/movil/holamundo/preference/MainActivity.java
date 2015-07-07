package unicauca.movil.holamundo.preference;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    public static final String PREFERENCE = "preference";
    public static final String KEY_INFO ="info";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    TextView txt;
    EditText edit;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);
        edit = (EditText) findViewById(R.id.edit);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

        preferences = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        editor = preferences.edit();

    }

    //region OptionMenu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    @Override
    public void onClick(View v) {
        String info = edit.getText().toString();
        editor.putString(KEY_INFO, info);
        editor.commit();
    }
}
