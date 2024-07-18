#ifndef VISTACINE_H
#define VISTACINE_H

#include "headers/Cine.h"

class VistaCine {
public:
    VistaCine();
    void mostrarCartelera(const Cine& cine) const;
    void mostrarSala(const Cine& cine, int peliculaId) const;
    void comprarBoletos(Cine& cine);
};

#endif // VISTACINE_H
