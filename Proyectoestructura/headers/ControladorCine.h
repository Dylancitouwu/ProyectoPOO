#ifndef CONTROLADORCINE_H
#define CONTROLADORCINE_H

#include "headers/Cine.h"
#include "VistaCine.h"

class ControladorCine {
private:
    Cine cine;
    VistaCine vista;

public:
    ControladorCine();
    void iniciar();
};

#endif // CONTROLADORCINE_H
