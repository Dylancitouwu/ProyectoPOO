#include "widget.h"
#include "ui_widget.h"
#include <QMessageBox>
Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
    , uiHome(new Home)
{
    ui->setupUi(this);
    ptrLU=&lu;
    connect(ui->btn_login,SIGNAL(clicked()),this,SLOT(validar()));
    connect(ui->btn_registrarse,SIGNAL(clicked()),this,SLOT(registro()));
    connect(ui->rb_registro,SIGNAL(toggled(bool)),this,SLOT(radioRegistro(bool)));

    ui->txt_confp->setVisible(false);
    ui->lb_confp->setVisible(false);
}

Widget::~Widget()
{
    delete ui;
}
void Widget::validar(){
    string usuario=ui->txt_user->text().toStdString();
    string psw=ui->txt_psw->text().toStdString();
    if(ptrLU->validar(usuario,psw)){
        QMessageBox::information(this,"GESTOR DE INVENTARIO","Bienvenido "+ QString::fromStdString(usuario));
        uiHome->show();
        this->hide();
    }else{
        QMessageBox::information(this,"GESTOR DE INVENTARIO","Credenciales incorrectas "+ QString::fromStdString(usuario));
    }
}
void Widget::registro(){

    string usuario=ui->txt_user->text().toStdString();
    string psw=ui->txt_psw->text().toStdString();
    string confp=ui->txt_confp->text().toStdString();

    string result=ptrLU->registrar(usuario,psw,confp);
    if (result == "Registro exitoso") {
        QMessageBox::information(this,"GESTOR DE INVENTARIO","Usuario registrado correctamente");
    } else {
        QMessageBox::information(this,"GESTOR DE INVENTARIO",QString::fromStdString(result));
    }
}
void Widget::radioRegistro(bool checked){
    ui->txt_confp->setVisible(checked);
    ui->lb_confp->setVisible(checked);
}
