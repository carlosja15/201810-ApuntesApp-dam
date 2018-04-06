package dam.upao.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import dam.upao.todoapp.daos.ApunteDAO;
import dam.upao.todoapp.models.Apunte;

public class ApunteFormActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apunte_form);
        Button btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(this);

        Intent intent = getIntent();
        int index = intent.getIntExtra("index", -1);
        if(index >= 0) {
            Apunte apunte = ApunteDAO.all.get(index);
            TextView txtTitulo = (TextView) findViewById(R.id.txtTitulo);
            TextView txtEtiquetas = (TextView) findViewById(R.id.txtEtiquetas);
            TextView txtContenido = (TextView) findViewById(R.id.txtContenido);

            txtTitulo.setText(apunte.getTitulo());
            txtEtiquetas.setText(apunte.getEtiquetas());
            txtContenido.setText(apunte.getContenido());
        }
    }

    @Override
    public void onClick(View view) {
        TextView txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        TextView txtEtiquetas = (TextView) findViewById(R.id.txtEtiquetas);
        TextView txtContenido = (TextView) findViewById(R.id.txtContenido);
        Apunte apunte = new Apunte();
        apunte.setTitulo(txtTitulo.getText().toString());
        apunte.setEtiquetas(txtEtiquetas.getText().toString());
        apunte.setContenido(txtContenido.getText().toString());
        ApunteDAO.save(apunte);
        finish();
    }
}
