package it.alessandra.listviewdoppia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaPiena;
    private ListView listaVuota;
    private Button Bsposta;
    private TextView itemP;
    private TextView itemV;
    private String [] arrayP;
    private String [] arrayV;
    private ArrayAdapter <String> arrayAdapterV;
    private ArrayAdapter <String> arrayAdapterP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaPiena = (ListView) findViewById(R.id.listapiena);
        listaVuota = (ListView) findViewById(R.id.listavuota);
        Bsposta = findViewById(R.id.bSposta);
        itemP = findViewById(R.id.itemP);
        itemV = findViewById(R.id.itemV);

        arrayP = new String[]{"Roberta","Federica","Marco","Barbara","Serena","Alessio","Giuseppe"};
        arrayV = new String[]{"","","","","","",""};

        arrayAdapterP = new ArrayAdapter<String>(this, R.layout.itemlistapiena,R.id.itemP,arrayP);
        arrayAdapterV = new ArrayAdapter<String>(this, R.layout.itemlistavuota,R.id.itemV,arrayV);

        listaPiena.setAdapter(arrayAdapterP);
        //listaVuota.setAdapter(arrayAdapterV);


        Bsposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayV = popola(arrayP,arrayV);
                listaVuota.setAdapter(arrayAdapterV);
                arrayAdapterP.notifyDataSetChanged();
            }
        });

    }

    /*public String [] popola(String[] arrayP, String[] arrayV){
            String tmp = arrayP [0];
            arrayV[0] = tmp;
            eliminaElemento(arrayP);
            return  arrayV;
    }*/

    public String [] popola(String[] arrayP, String[] arrayV){
        String tmp = arrayP [0];
        int index = 0;
        for(int i = 0; i< arrayV.length; i++){
            if(arrayV[i].equals("")){
                arrayV[i] = tmp;
                break;
            }
        }
        eliminaElemento(arrayP);
        return  arrayV;
    }



    public void eliminaElemento(String [] array){
        String tmp = "";
        for (int i = 0; i< array.length-1; i++){
            tmp = array[i+1];
            array[i] = tmp;
        }
        array[array.length-1] = "";
    }

}
