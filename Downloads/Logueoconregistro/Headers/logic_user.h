#ifndef LOGIC_USER_H
#define LOGIC_USER_H
#include "Headers/userDAO.h"
class Logic_user{
private:
    UserDAO udao;
    User u;
public:
    bool validar(string u,string p);
    string registrar(string u, string p, string cp);
};

#endif // LOGIC_USER_H
