#ifndef USERDAO_H
#define USERDAO_H
#include "Headers/user.h"
#include <vector>
#include<fstream>
#include <iostream>
class UserDAO{
private:
    User usuario;
    fstream archivo;
public:
    UserDAO();
    UserDAO(const User& u);
    vector<string> loadUsers();
    void saveUser(User &u);
};

#endif // USERDAO_H
