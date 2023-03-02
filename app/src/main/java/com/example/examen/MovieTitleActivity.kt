package com.example.examen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.examen.databinding.ActivityMovieTitleBinding

class MovieTitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pelicula = ""
        var duracion = ""

        binding.pelicula.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                pelicula = s.toString()
            }
        })
        binding.duracion.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                duracion = s.toString()
            }
        })
        binding.button.setOnClickListener(){
            val intent = Intent(this@MovieTitleActivity,MovieDetailsActivity::class.java)
            intent.putExtra("pelicula",pelicula)
            intent.putExtra("duracion",duracion)
            startActivity(intent)
        }
    }
}