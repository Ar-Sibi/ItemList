package arsibi_has_no_website.itemlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        int position=intent.getIntExtra("pos",0);
        ((TextView)findViewById(R.id.intenttext)).setText(MainActivity.input.get(position));
    }
    public void goBack(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
