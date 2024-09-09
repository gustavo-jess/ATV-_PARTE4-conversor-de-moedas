package conversormoedas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.conversormoedas.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtendo referências dos componentes do layout
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val edtTaxaConversao = findViewById<EditText>(R.id.edtTaxaConversao)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        // Configurando o evento de clique do botão
        btnConverter.setOnClickListener {
            // Obtendo os valores inseridos pelo usuário
            val valorTexto = edtValor.text.toString()
            val taxaTexto = edtTaxaConversao.text.toString()

            // Verificando se os campos não estão vazios
            if (valorTexto.isNotEmpty() && taxaTexto.isNotEmpty()) {
                // Convertendo os valores para Double
                val valor = valorTexto.toDoubleOrNull()
                val taxaConversao = taxaTexto.toDoubleOrNull()

                // Verificando se a conversão foi bem-sucedida
                if (valor != null && taxaConversao != null) {
                    // Calculando o valor convertido
                    val valorConvertido = valor * taxaConversao
                    // Exibindo o resultado
                    txtResultado.text = "Valor convertido: %.2f".format(valorConvertido)
                } else {
                    // Exibindo mensagem de erro se a conversão falhar
                    txtResultado.text = "Valores inválidos."
                }
            } else {
                // Exibindo mensagem de erro se algum campo estiver vazio
                txtResultado.text = "Por favor, preencha todos os campos."
            }
        }
    }
}