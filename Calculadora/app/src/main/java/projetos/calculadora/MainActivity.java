package projetos.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Função que soma dois números
    public float somar(float a, float b) {
        return a + b;
    }

    //Função que subtrai dois números
    public float subtrair(float a, float b) {
        return a - b;
    }

    //Função que divide dois números
    public float dividir(float a, float b) {
        return a / b;
    }

    //Função que multiplica dois números
    public float multiplicar(float a, float b) {
        return a * b;
    }

}