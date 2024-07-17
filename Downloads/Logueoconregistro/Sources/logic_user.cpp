#include"Headers/logic_user.h"
bool Logic_user::validar(string u,string p){
    bool access=false;
    vector<string> users=udao.loadUsers();//carga todos los usuarios
    for(const string & usuario:users){
        if(usuario==(u+";"+p)){
            access=true;
        }
    }

    return access;
}
string Logic_user::registrar(string u, string p, string cp){
    User nuevoUsuario;
    nuevoUsuario.registrarUser(u,p,cp);
    if(nuevoUsuario.getUser()!=""){
        udao.saveUser(nuevoUsuario);
        return "Registro Exitoso";
    }else{
        return "Credenciales no coinciden, intente de nuevo.";
    }

}
