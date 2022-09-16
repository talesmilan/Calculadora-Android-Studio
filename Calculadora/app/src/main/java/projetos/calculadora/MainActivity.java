package projetos.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaração das variáveis
    private String numeroVisor;
    private float primeiroNumero;
    private float segundoNumero;
    private float resultado;
    private boolean virgulaDigitada;
    private int sinal;
    private int passo;
    private TextView visor;
    private Button ac, mais, menos, igual, vezes, dividir, back, virgula, botao1, botao2,
    botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciando variáveis
        numeroVisor = "";
        primeiroNumero = 0;
        segundoNumero = 0;
        sinal = 0;
        passo = 0;
        virgulaDigitada = false;

        visor = (TextView) findViewById(R.id.visor);
        ac = (Button) findViewById(R.id.botaoAC);
        mais = (Button) findViewById(R.id.botaoMais);
        menos = (Button) findViewById(R.id.botaoMenos);
        igual = (Button) findViewById(R.id.botaoIgual);
        vezes = (Button) findViewById(R.id.botaoVezes);
        dividir = (Button) findViewById(R.id.botaoDividir);
        back = (Button) findViewById(R.id.botaoBackspace);
        virgula = (Button) findViewById(R.id.botaoVirgula);
        botao1 = (Button) findViewById(R.id.botao1);
        botao2 = (Button) findViewById(R.id.botao2);
        botao3 = (Button) findViewById(R.id.botao3);
        botao4 = (Button) findViewById(R.id.botao4);
        botao5 = (Button) findViewById(R.id.botao5);
        botao6 = (Button) findViewById(R.id.botao6);
        botao7 = (Button) findViewById(R.id.botao7);
        botao8 = (Button) findViewById(R.id.botao8);
        botao9 = (Button) findViewById(R.id.botao9);
        botao0 = (Button) findViewById(R.id.botao0);


        //Programando o botão AC
        ac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                numeroVisor = "";
                visor.setText("0");
                virgulaDigitada = false;
                sinal = 0;
            }
        });
        //Programando o botão backspace
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0) {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = "";
                    visor.setText("0");
                }

            }
        });
        //Programando o botão de soma
        mais.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-")) {
                    primeiroNumero = Float.parseFloat(numeroVisor);
                    numeroVisor += "+";
                    visor.setText(numeroVisor);
                    numeroVisor = "";
                    sinal = 1;
                    virgulaDigitada = false;
                }
            }
        });
        //Programando o botão de subtração
        menos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-")) {
                    primeiroNumero = Float.parseFloat(numeroVisor);
                    numeroVisor += "-";
                    visor.setText(numeroVisor);
                    numeroVisor = "";
                    sinal = 2;
                    virgulaDigitada = false;
                } else if (numeroVisor.length() == 0) {
                    numeroVisor += "-";
                    visor.setText(numeroVisor);

                }
            }
        });
        //Programando o botão de multiplicação
        vezes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-")) {
                    primeiroNumero = Float.parseFloat(numeroVisor);
                    numeroVisor += "x";
                    visor.setText(numeroVisor);
                    numeroVisor = "";
                    sinal = 3;
                    virgulaDigitada = false;
                }
            }
        });
        //Programando o botão de divisão
        dividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-")) {
                    primeiroNumero = Float.parseFloat(numeroVisor);
                    numeroVisor += "/";
                    visor.setText(numeroVisor);
                    numeroVisor = "";
                    sinal = 4;
                    virgulaDigitada = false;
                }
            }
        });
        //Programando o botão de resultado
        igual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && sinal != 0) {
                    segundoNumero = Float.parseFloat(numeroVisor);
                    if (sinal == 1) {
                        resultado = somar(primeiroNumero, segundoNumero);
                    } else if (sinal == 2) {
                        resultado = subtrair(primeiroNumero, segundoNumero);
                    } else if (sinal == 3) {
                        resultado = multiplicar(primeiroNumero, segundoNumero);
                    } else if (sinal == 4) {
                        resultado = dividir(primeiroNumero, segundoNumero);
                    }
                    numeroVisor = String.valueOf(resultado);
                    numeroVisor = tirarZero(numeroVisor);
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão de virgula
        virgula.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-")) {
                    if (!virgulaDigitada) {
                        numeroVisor += ".";
                        virgulaDigitada = true;
                        visor.setText(numeroVisor);
                    }
                } else if (numeroVisor.length() == 0  && !numeroVisor.equals("-")) {
                    if (!virgulaDigitada) {
                        numeroVisor += "0.";
                        virgulaDigitada = true;
                        visor.setText(numeroVisor);
                    }
                }
            }
        });
        //Programando o botão do número 1
        botao1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "1";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "1";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 2
        botao2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "2";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "2";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 3
        botao3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "3";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "3";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 4
        botao4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "4";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "4";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 5
        botao5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "5";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "5";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 6
        botao6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "6";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "6";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 7
        botao7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "7";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "7";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 8
        botao8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "8";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "8";
                    visor.setText(numeroVisor);
                }
            }
        });
        //Programando o botão do número 9
        botao9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (!numeroVisor.equals("-0")) {
                    numeroVisor += "9";
                    visor.setText(numeroVisor);
                } else {
                    numeroVisor = numeroVisor.substring(0, numeroVisor.length() -1 );
                    numeroVisor += "9";
                    visor.setText(numeroVisor);
                }

            }
        });
        //Programando o botão do número 0
        botao0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Faça algo em resposta ao botão
                if (numeroVisor.length() > 0 && !numeroVisor.equals("-0")) {
                    numeroVisor += "0";
                    visor.setText(numeroVisor);
                } else if (numeroVisor.length() == 0 && !numeroVisor.equals("-0")) {
                    visor.setText("0");
                }
            }
        });


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

    //Função que tira o ".0" do final do número float
    public String tirarZero(String numero) {
        char ultimoDigito = numero.charAt(numero.length()-1);
        char verificaVirgula = numero.charAt(numero.length() - 2);
        if (ultimoDigito == '0' && verificaVirgula == '.') {
            float resultadoFloat = Float.parseFloat(numero);
            int resultadoInt = (int) resultadoFloat;
            numero = String.valueOf(resultadoInt);
        }
        return numero;
    }

}