package com.example.examen

class Movie {
    var pelicula = ""
    var duracion = ""
    var director = ""
    var year = ""
    var fav = false

    constructor(pelicula:String,duracion:String,director:String,year:String){
        this.pelicula = pelicula
        this.duracion = duracion
        this.director = director
        this.year = year
    }
    fun fav(b:Boolean){
        this.fav = b
    }
}