package com.example.app_fateclanches.servico

import com.example.app_fateclanches.models.Comida
import com.example.app_fateclanches.models.LoginRequest
import com.example.app_fateclanches.models.LoginResponse
import com.example.app_fateclanches.models.Usuario
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.GET


interface ServicoUsuario {



    @POST("usuarios/registrar")
    fun insereUsuarios(@Body usuario:Usuario): Call<Usuario>

    @GET("lanches")
    fun getLanche(): Call<List<Comida>>

    @POST("usuarios/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("api/produtos") // Ajuste conforme seu endpoint
    fun listarProdutos(): Call<List<Produto>>

    /*
     @GET("contatos")
    fun getContatos(): Call<List<Contato>>
        @PUT("contatos/{id}")
        fun editaContato(@Body contato:Contato, @Path("id") id:String): Call<Contato>

        @DELETE("contatos/{id}")
        fun excluiContato(@Path("id") id:String): Call<Void>

        @Multipart
        @POST("upload")
        fun uploadImagem(@Part imagem: MultipartBody.Part):
                Call<UploadResposta>

        data class UploadResposta(val nomeArquivo: String)

     */
}