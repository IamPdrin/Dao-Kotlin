package br.edu.fatecpg.transicaotelas.dao

import br.edu.fatecpg.transicaotelas.model.Usuario

class UsuarioDao {
    companion object {
        private var usuario: Usuario? = null
    }

    fun cadastroUsuario(usuario:Usuario){
        Companion.usuario = usuario
    }

    fun exibirUsuario():Usuario{
        return Companion.usuario?:Usuario()
    }
}