package com.example.examen

class MoviesController {

    lateinit var pelis : List<Movie>

    fun addPeli(peli:Movie){
        pelis += peli
    }
    fun deletePeli(n:Int){
        pelis -= pelis[n]
    }

}