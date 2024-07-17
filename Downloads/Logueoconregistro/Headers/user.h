#ifndef USER_H
#define USER_H
#include <string>
using namespace std;
class User{
private:
    string nameUser, psw;
public:
    User();
    ~User();
    User(string u ,string p);
    string getUser()const;
    string getPSW()const;
    void setUser(string u);
    void setPSW(string p);
    void registrarUser(string u, string p, string confp);
};

#endif // USER_H
