package com.example.practica_3_lista_tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lv_agregar;
    private Button btn_guardar;
    private ViewGroup tareas;
    private EditText txt_tarea;
    private FloatingActionButton fbtn_agregar;
    private Button btn_cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbtn_agregar = (FloatingActionButton) findViewById(R.id.fbtn_agregar);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        lv_agregar = (LinearLayout) findViewById(R.id.lv_agregar);
        txt_tarea = (EditText) findViewById(R.id.txt_tarea);
        tareas = (ViewGroup) findViewById(R.id.tareas);
        btn_cancelar = (Button) findViewById(R.id.btn_cancelar);

        lv_agregar.setVisibility(View.GONE);

        fbtn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv_agregar.setVisibility(View.VISIBLE);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_tarea.getText().length() == 0){
                    Toast.makeText(MainActivity.this, "Ingrese la Tarea en el Campo", Toast.LENGTH_SHORT).show();
                }else{
                    lv_agregar.setVisibility(View.GONE);
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    agregarTarea();
                    txt_tarea.setText("");
                }

            }
        });



        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv_agregar.setVisibility(View.GONE);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                txt_tarea.setText("");
            }
        });



    }


    public void agregarTarea(){
        LayoutInflater inflater = LayoutInflater.from(this);
        int id = R.layout.activity_tarea;
        RelativeLayout relativeLayout = (RelativeLayout) inflater.inflate(id, null, false);

        TextView tv_pendiente = (TextView) relativeLayout.findViewById(R.id.tv_pendiente);
        tv_pendiente.setText(txt_tarea.getText());

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayout.setPadding(5, 0, 5, 10);
        relativeLayout.setLayoutParams(params);
        tareas.addView(relativeLayout);
    }

}