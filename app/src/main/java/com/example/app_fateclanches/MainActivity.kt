    package com.example.app_fateclanches

    import android.annotation.SuppressLint
    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.ImageButton
    import android.widget.TextView
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.app_fateclanches.view.CadastroActivity
    import com.example.app_fateclanches.view.Home

    class MainActivity : AppCompatActivity() {
        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)

            val textViewCadastro = findViewById<TextView>(R.id.fazerCadastroTextView)

            textViewCadastro.setOnClickListener {
                val intent = Intent(this, CadastroActivity::class.java)
                startActivity(intent)
                finish()
            }


            val emailField = findViewById<EditText>(R.id.emailEditText)
            val senhaField = findViewById<EditText>(R.id.senhaEditText)
            val loginButton = findViewById<Button>(R.id.entrarButton)

            loginButton.setOnClickListener {
                val email = emailField.text.toString()
                val senha = senhaField.text.toString()

                if (email == "admin@exemplo.com" && senha == "123456") {
                    // Login correto: ir para próxima tela
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
