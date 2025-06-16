package com.example.app_fateclanches.view

//import com.example.app_fateclanches.databinding.ActivityComidasBinding
/*
class ComidasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComidasBinding
    private lateinit var comidasAdapter: ComidaAdapter
    private val listaComidas: MutableList<Comida> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComidasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val categoria = intent.getStringExtra("categoria")

        // Configura RecyclerView
        binding.recyclerViewComidas.layoutManager = LinearLayoutManager(this)
        comidasAdapter = ComidaAdapter(this, listaComidas)
        binding.recyclerViewComidas.adapter = comidasAdapter

        // Carrega lista conforme categoria
        carregarComidasPorCategoria(categoria)
    }

    private fun carregarComidasPorCategoria(categoria: String?) {
        listaComidas.clear()

        when (categoria) {
            "Lanches" -> {
                listaComidas.add(Comida("X-Burguer", R.drawable.x_burguer))
                listaComidas.add(Comida("Hot Dog", R.drawable.hot_dog))
            }
            "Bebidas" -> {
                listaComidas.add(Comida("Refrigerante", R.drawable.refrigerante))
                listaComidas.add(Comida("Suco Natural", R.drawable.suco))
            }
            "Doces" -> {
                listaComidas.add(Comida("Brigadeiro", R.drawable.brigadeiro))
                listaComidas.add(Comida("Pudim", R.drawable.pudim))
            }
            "Perfil" -> {
                // Exemplo: nada a mostrar ou outra coisa
            }
            else -> {
                // Categoria não reconhecida
            }
        }

        comidasAdapter.notifyDataSetChanged()
    }
}
*/