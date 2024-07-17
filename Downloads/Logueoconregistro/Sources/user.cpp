#include "Headers/user.h"

User::User(){
    this->nameUser="";
    this->psw="";
}
User::~User(){}
User::User(string u,string p):nameUser(u),psw(p){}
string User::getUser()const{
    return nameUser;
}
string User::getPSW()const{
    return psw;
}
void User::setUser(string u){
    nameUser=u;
}
void User::setPSW(string p){
    psw=p;
}
void User::registrarUser(string u, string p,string confp){
    if(p==confp){
        this->nameUser=u;
        this->psw=p;
    }

}
