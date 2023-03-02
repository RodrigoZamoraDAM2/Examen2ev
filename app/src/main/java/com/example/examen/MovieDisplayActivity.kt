package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.isDigitsOnly
import com.example.examen.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var idPeli = 0

        binding.npelicula.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idPeli = s.toString().toInt()

                if(s.toString().isDigitsOnly() && s.toString().toInt() < MoviesController().pelis.size){

                    binding.peliculatext.text = MoviesController().pelis[s.toString().toInt()].pelicula
                    binding.duraciontext.text = MoviesController().pelis[s.toString().toInt()].duracion
                    binding.directortext.text = MoviesController().pelis[s.toString().toInt()].director
                    binding.yeartext.text = MoviesController().pelis[s.toString().toInt()].year
                }
            }
        })
        binding.add.setOnClickListener(){
            startActivity(Intent(this@MovieDisplayActivity,MovieTitleActivity::class.java))
        }
        binding.eliminar.setOnClickListener(){
            MoviesController().deletePeli(idPeli)
        }
        binding.darfav.setOnClickListener(){
            if(MoviesController().pelis[idPeli].fav) {
                MoviesController().pelis[idPeli].fav = false
            }else{
                MoviesController().pelis[idPeli].fav = true
            }
        }
        binding.favorito.setOnClickListener(){
            startActivity(Intent(this@MovieDisplayActivity,MovieDisplayActivity::class.java))
        }
    }
}