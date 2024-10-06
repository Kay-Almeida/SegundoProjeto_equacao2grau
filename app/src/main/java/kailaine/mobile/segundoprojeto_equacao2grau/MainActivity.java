package kailaine.mobile.segundoprojeto_equacao2grau;

/*
 *@author:<Kailaine Almeida de Souza 1110482313026>
*/

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etPrimeiroNumero;
    private EditText etSegundoNumero;
    private EditText etTerceiroNumero;

   // private Button btnCalc;
    private TextView tvDelta;
    private TextView tvX2;
    private TextView tvX1;
    private TextView tvsemraiz;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.etDelta), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etPrimeiroNumero = findViewById(R.id.etPrimeiroNumero);
        etSegundoNumero = findViewById(R.id.etSegundoNumero);
        etTerceiroNumero = findViewById(R.id.etTerceiroNumero);

        tvDelta = findViewById(R.id.tvDelta);
        tvX1 = findViewById(R.id.tvX1);
        tvX2 = findViewById(R.id.tvX2);
        tvsemraiz = findViewById(R.id.tvsemraiz);

        etPrimeiroNumero.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etSegundoNumero.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etTerceiroNumero.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        tvDelta.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX1.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvX2.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvsemraiz.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        double etPrimeiro = Double.parseDouble(etPrimeiroNumero.getText().toString());
        double etSegundo = Double.parseDouble(etSegundoNumero.getText().toString());
        double etTerceiro = Double.parseDouble(etTerceiroNumero.getText().toString());

        double delta = etSegundo * etSegundo - 4 * etPrimeiro * etTerceiro;
        tvDelta.setText(String.valueOf(delta));

        if (delta > 0) {
            double x1 = (-etSegundo + Math.sqrt(delta)) / (2 * etPrimeiro);
            double x2 = (-etSegundo - Math.sqrt(delta)) / (2 * etPrimeiro);
            String fist = String.valueOf(x1);
            String second = String.valueOf(x2);
            tvX1.setText(fist);
            tvX2.setText(second);
        } else if (delta == 0) {
            double x = -etSegundo / (2 * etPrimeiro);
            String delta0 = String.valueOf(x);
            tvX1.setText(delta0);
        } else {
            System.out.println("A equação não possui soluções reais.");
            tvsemraiz.setText(getString(R.string.semRaizes));

        }
        etPrimeiroNumero.setText("");
        etSegundoNumero.setText("");
        etTerceiroNumero.setText("");

    }
}