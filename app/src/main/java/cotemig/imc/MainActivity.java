package cotemig.imc;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.inputAltura) EditText inputAltura;
    @BindView(R.id.inputPeso) EditText inputPeso;
    @BindView(R.id.btnCalcular) Button btnCalcula;
    @BindView(R.id.textResultado) TextView textoResultado;

    @OnClick(R.id.btnCalcular)
    public void calcularIMC(){
        double altura = Double.parseDouble(inputAltura.getText().toString());
        double peso = Double.parseDouble(inputPeso.getText().toString());
        double resultado = peso / Math.pow((altura / 100), 2);
        String categoria;

        if(resultado <= 16){
            categoria = getResources().getText(R.string.magreza_grave).toString();
        }
        else if(resultado <= 17){
            categoria = getResources().getText(R.string.magreza_moderada).toString();
        }
        else if(resultado <= 18.5){
            categoria = getResources().getText(R.string.magreza_leve).toString();
        }

        else if(resultado <= 25){
            categoria = getResources().getText(R.string.saudavel).toString();
        }
        else if(resultado < 30){
            categoria = getResources().getText(R.string.sobrepeso).toString();
        }
        else if(resultado <= 35){
            categoria = getResources().getText(R.string.obesidade1).toString();
        }
        else if(resultado <= 40){
            categoria = getResources().getText(R.string.obesidade2).toString();
        }
        else{
            categoria = getResources().getText(R.string.obesidade3).toString();
        }

        textoResultado.setText("O seu Índice de Massa Corporal é de " + String.format("%.2f", resultado)
                + ", e você está " + categoria);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
