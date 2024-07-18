#include "../headers/Pelicula.h"

Pelicula::Pelicula(int id, string titulo, int duracion, bool estreno, string hora)
    : id(id), titulo(titulo), duracion(duracion), estreno(estreno), hora(hora) {}

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
