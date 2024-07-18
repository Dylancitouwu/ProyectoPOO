#include "../Headers/VistaCine.h"
#include <QDebug>

VistaCine::VistaCine() {}

void VistaCine::mostrarCartelera(const Cine& cine) const {
    cine.mostrarCartelera();
}

void VistaCine::mostrarSala(const Cine& cine, int peliculaId) const {
    cine.mostrarSala(peliculaId);
}

void VistaCine::comprarBoletos(Cine& cine) {
    cine.comprarBoletos();
}
