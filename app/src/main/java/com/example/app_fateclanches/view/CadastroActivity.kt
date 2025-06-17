package com.example.app_fateclanches.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.app_fateclanches.MainActivity
import com.example.app_fateclanches.R
import com.example.app_fateclanches.api.UsuarioRetrofit
import com.example.app_fateclanches.models.Usuario
import com.example.app_fateclanches.servico.ServicoUsuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastroActivity : AppCompatActivity() {

    lateinit var txtNomeContatoForm: EditText
    lateinit var txtEmailContatoForm: EditText
    lateinit var txtSenhaContatoForm: EditText
    lateinit var btnSalvarContato: Button
    var usuario:Usuario ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        // Referências aos campos
        txtNomeContatoForm = findViewById(R.id.nomeEditText)
        txtEmailContatoForm = findViewById(R.id.emailEditText)
        txtSenhaContatoForm = findViewById(R.id.senhaEditText)

        btnSalvarContato = findViewById(R.id.btnCadastra)

        val textViewLogin = findViewById<TextView>(R.id.fazerLoginTextView)
        textViewLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Cadastrar ao clicar no botão
        btnSalvarContato.setOnClickListener {
            cadastrarUsuario()
        }
    }

    private fun cadastrarUsuario() {
        val nome = txtNomeContatoForm.text.toString()
        val email = txtEmailContatoForm.text.toString()
        val senha = txtSenhaContatoForm.text.toString()

        val usuario = Usuario(null,
            nome = nome,
            email = email,
            senha = senha,
        )

        val servico = UsuarioRetrofit.usuario.create(ServicoUsuario::class.java)
        servico.insereUsuarios(usuario).enqueue(object : Callback<Usuario> {
            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@CadastroActivity, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@CadastroActivity, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this@CadastroActivity, "Erro ao cadastrar: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                Toast.makeText(this@CadastroActivity, "Falha na requisição: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
