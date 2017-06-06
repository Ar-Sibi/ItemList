package arsibi_has_no_website.itemlists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv ;
    TextView tv;
    ArrayAdapter<String> adapter;
    static List<String> input=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tv=(TextView)findViewById(R.id.editText);
        lv=(ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,input);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),SecondScreen.class);
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });
    }
    public void addItem(View view){
        input.add(tv.getText().toString());
        adapter.notifyDataSetChanged();
        tv.setText("");
    }
    public void deleteItem(View view){
        try {
            if (Integer.parseInt(tv.getText().toString()) > 0&&Integer.parseInt(tv.getText().toString())<=input.size())
                input.remove(Integer.parseInt(tv.getText().toString())-1);
            else
                Toast.makeText(getApplicationContext(),"Enter valid index",Toast.LENGTH_LONG).show();
            adapter.notifyDataSetChanged();
        }catch (NumberFormatException e){
            Toast.makeText(getApplicationContext(),"Illegal format please enter only numbers",Toast.LENGTH_LONG).show();
        }
        tv.setText("");
        }
}
