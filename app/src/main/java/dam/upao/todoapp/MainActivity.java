package dam.upao.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import dam.upao.todoapp.daos.ApunteDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Hola Mundo", Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.btnNuevoApunte);

        button.setOnClickListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.nota_detail_layout,
                R.id.txtTitulo,
                ApunteDAO.all);

        ListView listView = (ListView) findViewById(R.id.listViewApuntes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), ApunteFormActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        //Toast.makeText(this, "Hola",
        //        Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ApunteFormActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = (ListView) findViewById(R.id.listViewApuntes);
        ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();
        adapter.notifyDataSetChanged();
    }

}
