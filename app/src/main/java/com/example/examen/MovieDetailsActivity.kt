package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.isDigitsOnly
import com.example.examen.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var pelicula = intent.getStringExtra("pelicula")
        var duracion = intent.getStringExtra("duracion")
        var director = ""
        var year = ""

        binding.director.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                director = s.toString()
            }
        })
        binding.year.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                year = s.toString()
            }
        })

        binding.siguiente2.setOnClickListener(){
            if(duracion.toString().isDigitsOnly() && year.isDigitsOnly() && duracion.toString().toInt() > 0 && year.toInt() > 0) {
                MoviesController().addPeli(
                    Movie(
                        pelicula.toString(),
                        duracion.toString(),
                        director,
                        year
                    )
                )
            }
            val intent = Intent(this@MovieDetailsActivity,MovieDisplayActivity::class.java)
            intent.putExtra("pelicula",pelicula)
            intent.putExtra("director",director)
            intent.putExtra("duracion",duracion)
            intent.putExtra("año",year)
            startActivity(intent)
        }
        binding.atras.setOnClickListener(){
            startActivity(Intent(this@MovieDetailsActivity,MovieTitleActivity::class.java))
        }
    }
}