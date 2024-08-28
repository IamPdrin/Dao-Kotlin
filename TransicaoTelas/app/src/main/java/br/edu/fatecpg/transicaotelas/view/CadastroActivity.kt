package br.edu.fatecpg.transicaotelas.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.transicaotelas.R
import br.edu.fatecpg.transicaotelas.dao.UsuarioDao
import br.edu.fatecpg.transicaotelas.model.CalculoImc
import br.edu.fatecpg.transicaotelas.model.Usuario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CadastroActivity : AppCompatActivity() {

    val dao = UsuarioDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val calculaImc = CalculoImc()

        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtAltura = findViewById<EditText>(R.id.edt_altura)

        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val fabLista = findViewById<FloatingActionButton>(R.id.fab_lista)

        btnCalcular.setOnClickListener{
            val peso = edtPeso.text.toString().toDouble()
            val altura = edtAltura.text.toString().toDouble()

            if (edtPeso.text.toString().isEmpty() || edtAltura.text.toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os valores!", Toast.LENGTH_SHORT).show()
            }
            else {
                val resultadoImc = calculaImc.calcula(peso, altura)
                val usuario = Usuario(peso, altura, resultadoImc)

                dao.cadastroUsuario(usuario)
            }

            Toast.makeText(this, "Cálculo Realizado com Sucesso!", Toast.LENGTH_LONG).show()

            edtPeso.text.clear()
            edtAltura.text.clear()

        }

        fabLista.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }
}