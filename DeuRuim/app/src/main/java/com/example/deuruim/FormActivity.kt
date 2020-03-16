package com.example.deuruim

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var btnImageForm: Button
    private lateinit var ivFoto: ImageView
    val FOTO = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbNota = findViewById(R.id.sbFormNota)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)
        this.btnImageForm = findViewById(R.id.btnImageForm)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.btSalvar.setOnClickListener({ salvar() })
        this.btCancelar.setOnClickListener({
            finish()
        })

        this.btnImageForm.setOnClickListener{ camera() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FOTO){
                val foto = data?.extras?.get("data") as Bitmap
                this.ivFoto.setImageBitmap(foto)
            }
        }

    }

    private fun camera (){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, FOTO)
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress
        val foto = this.ivFoto as Bitmap

        val evento = Evento(
            descricao,
            nota,
            foto,
        )

        val intent = Intent()
        intent.putExtra("EVENTO", evento)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }
}
