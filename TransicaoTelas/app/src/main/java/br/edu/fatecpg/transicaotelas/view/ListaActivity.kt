package br.edu.fatecpg.transicaotelas.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.transicaotelas.R
import br.edu.fatecpg.transicaotelas.dao.UsuarioDao
import br.edu.fatecpg.transicaotelas.model.Usuario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaActivity : AppCompatActivity() {

    val dao = UsuarioDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val txvClassi = findViewById<TextView>(R.id.txv_classImc)
        val txvImc = findViewById<TextView>(R.id.txv_resultadoImc)
        val fabVoltar = findViewById<FloatingActionButton>(R.id.fab_voltar)

        val usuario: Usuario = dao.exibirUsuario()

        val resImc = usuario.imc

        txvImc.text = resImc.toString()

        if(resImc <= 18.8){
            txvClassi.text = "Abaixo do Normal!"
        } else if (resImc in 18.5..24.9){
            txvClassi.text = "Peso Normal!"
        } else if (resImc in 25.0..29.9){
            txvClassi.text = "Excesso de Peso!"
        } else if (resImc in 30.0..34.9){
            txvClassi.text = "Obesidade Classe I!"
        } else if (resImc in 35.0..39.9){
            txvClassi.text = "Obesidade Classe II!"
        } else if (resImc >= 40) {
            txvClassi.text = "Obesidade Classe III!"
        }

        fabVoltar.setOnClickListener{
            finish()
        }
    }
}