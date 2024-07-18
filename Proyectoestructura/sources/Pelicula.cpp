#include "../headers/Pelicula.h"

Pelicula::Pelicula(int id, string titulo, int duracion, bool estreno, string hora, string sinopsis, string genero)
    : id(id), titulo(titulo), duracion(duracion), estreno(estreno), hora(hora), sinopsis(sinopsis), genero(genero) {}

string Pelicula::toString() const {
    string result = to_string(id) + " - [" + hora + "] " + titulo + " (" + to_string(duracion) + ") ";
    if (estreno) {
        result += "* ESTRENO *";
    }
    return result;
}
int Pelicula::getId() const {
    return id;
}
string Pelicula::getHora() const {
    return hora;
}
string Pelicula::getTitulo() const {
    return titulo;
}
string Pelicula::getSinopsis()const{
    return sinopsis;
}
string Pelicula::getGenero()const{
    return genero;
}
