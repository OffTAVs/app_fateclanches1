    package com.example.app_fateclanches

    import android.content.Intent
    import android.os.Bundle
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity
    import com.example.app_fateclanches.api.UsuarioRetrofit
    import com.example.app_fateclanches.models.LoginRequest
    import com.example.app_fateclanches.models.LoginResponse
    import com.example.app_fateclanches.servico.ServicoUsuario
    import com.example.app_fateclanches.view.CadastroActivity
    import com.example.app_fateclanches.view.Home
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response

    class MainActivity : AppCompatActivity() {

        lateinit var emailField: EditText
        lateinit var senhaField: EditText
        lateinit var loginButton: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val textViewCadastro = findViewById<TextView>(R.id.fazerCadastroTextView)
            textViewCadastro.setOnClickListener {
                startActivity(Intent(this, CadastroActivity::class.java))
                finish()
            }

            emailField = findViewById(R.id.emailEditText)
            senhaField = findViewById(R.id.senhaEditText)
            loginButton = findViewById(R.id.entrarButton)

            loginButton.setOnClickListener {
                val email = emailField.text.toString()
                val senha = senhaField.text.toString()

                val request = LoginRequest(email, senha)

                val servico = UsuarioRetrofit.usuario.create(ServicoUsuario::class.java)
                servico.login(request).enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val token = response.body()?.token ?: ""
                            Toast.makeText(this@MainActivity, "Login OK!", Toast.LENGTH_SHORT).show()

                            // Aqui você pode salvar o token com SharedPreferences, se quiser

                            startActivity(Intent(this@MainActivity, Home::class.java))
                            finish()
                        } else {
                            Toast.makeText(this@MainActivity, "Email ou senha inválidos", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Erro na conexão: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
