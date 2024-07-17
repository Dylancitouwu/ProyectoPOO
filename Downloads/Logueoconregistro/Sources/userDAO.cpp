#include "Headers/userDAO.h"
#include <iostream>
UserDAO::UserDAO(){

}
UserDAO::UserDAO(const User& u){
    this->usuario=u;
}
vector<string> UserDAO::loadUsers(){
    vector<string> users;
    archivo.open("C://ejerciciosFS//users.txt",ios::in);
    if(archivo.is_open()){
        string linea="";
        while(getline(archivo,linea)){
            cout<<linea<<endl;
            users.push_back(linea);
        }
        archivo.close();
    }
    return users;
}
void UserDAO::saveUser(User &u){
    archivo.open("C://ejerciciosFS//users.txt",ios::app);
    if (archivo.is_open()){
        archivo<<u.getUser()<<";"<<u.getPSW()<<endl;
        archivo.close();
    }
}
