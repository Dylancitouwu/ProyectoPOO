#include "buscar.h"
#include "ui_buscar.h"

buscar::buscar(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::buscar)
{
    ui->setupUi(this);
    connect(ui->btn_buscar,SIGNAL(clicked()),this,SLOT(buscarcode()));
}

buscar::~buscar()
{
    delete ui;
}

bool buscar::buscarcode(){
    std::vector<Product> products = ptrLp->pdao.readProducts();
    QString codigop=ui->txt_buscarc->text();
    bool verificar=false; // Inicializa verificar en false
    for(auto p:products){
        if(codigop==QString::fromStdString(p.getCode())){
            verificar=true;
            break; // Salir del bucle si se encuentra el producto
        }
    }
    return verificar;
}
