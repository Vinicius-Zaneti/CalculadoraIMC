package com.example.calculadoraimc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.ui.AppBarConfiguration;
import com.example.calculadoraimc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Variaveis para guardar os valores dos elementos da calculadora.
    private TextView resultado;

    private TextView classificacao;

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //COMEÇA AQUI

        //Linkando as variaveis e os elementos com os respectivos campos no layout
        resultado = findViewById(R.id.txt_resultado);
        classificacao = findViewById(R.id.txt_classificacao);

        Button botaoCalcular = findViewById(R.id.btn_calcular);
        // Fazendo o botao utilizar a funcao de calcular quando for pressionado
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }


            // Funcao de calcular
            private void calcular() {
                //linkando as variaveis com os inputs do layout
                EditText altura = findViewById(R.id.input_altura);
                EditText peso = findViewById(R.id.input_peso);

                //transformando os valores que foram inputados para double

                double alturaDefinida = Double.parseDouble(altura.getText().toString());
                double pesoDefinido = Double.parseDouble(peso.getText().toString());

                //fazendo o calculo do imc
                double imc = pesoDefinido / (alturaDefinida * alturaDefinida);
                double imcCalculado = 0.0;

                String resultadoIMC;

                //classificando o peso de acordo com o valor do imc
                if (imc < 18.5) {
                imcCalculado = imc;
                resultadoIMC = "abaixo do peso";
                } else if (imc >= 18.5 && imc < 25) {
                imcCalculado = imc;
                resultadoIMC = "Peso normal";
                } else if (imc >= 25 && imc < 30) {
                imcCalculado = imc;
                resultadoIMC = "Sobrepeso";
                } else {
                imcCalculado = imc;
                resultadoIMC = "Obesidade";
                }

                resultado.setText((resultadoIMC));
                resultado.setVisibility(View.VISIBLE);
                classificacao.setText(String.valueOf(imcCalculado));
                classificacao.setVisibility(View.VISIBLE);


            }

        });


    }
}