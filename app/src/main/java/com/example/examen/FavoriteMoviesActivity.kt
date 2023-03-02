package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.text.isDigitsOnly
import com.example.examen.databinding.ActivityFavoriteMoviesBinding

class FavoriteMoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var idPeli = 0
        lateinit var pelisfav : List<Movie>

        for (element in MoviesController().pelis){
            if (element.fav){
                pelisfav += element
            }
        }


        binding.idfav.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idPeli = s.toString().toInt()

                if(s.toString().isDigitsOnly() && s.toString().toInt() < MoviesController().pelis.size){

                    binding.peliculatextfav.text = MoviesController().pelis[s.toString().toInt()].pelicula
                    binding.duraciontextfav.text = MoviesController().pelis[s.toString().toInt()].duracion
                    binding.directortextfav.text = MoviesController().pelis[s.toString().toInt()].director
                    binding.yeartextfav.text = MoviesController().pelis[s.toString().toInt()].year
                }
            }
        })

        binding.atrasfav.setOnClickListener(){
            startActivity(Intent(this@FavoriteMoviesActivity,MovieDisplayActivity::class.java))
        }
    }
}