/********************************************************************************
** Form generated from reading UI file 'home.ui'
**
** Created by: Qt User Interface Compiler version 6.7.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_HOME_H
#define UI_HOME_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Home
{
public:
    QWidget *gridLayoutWidget;
    QGridLayout *gridLayout;
    QPushButton *btn_consultar;
    QPushButton *btn_registrar;
    QPushButton *btn_usuarios;

    void setupUi(QWidget *Home)
    {
        if (Home->objectName().isEmpty())
            Home->setObjectName("Home");
        Home->resize(400, 300);
        gridLayoutWidget = new QWidget(Home);
        gridLayoutWidget->setObjectName("gridLayoutWidget");
        gridLayoutWidget->setGeometry(QRect(0, 0, 401, 301));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout->setObjectName("gridLayout");
        gridLayout->setContentsMargins(0, 0, 0, 0);
        btn_consultar = new QPushButton(gridLayoutWidget);
        btn_consultar->setObjectName("btn_consultar");

        gridLayout->addWidget(btn_consultar, 0, 1, 1, 1);

        btn_registrar = new QPushButton(gridLayoutWidget);
        btn_registrar->setObjectName("btn_registrar");

        gridLayout->addWidget(btn_registrar, 0, 0, 1, 1);

        btn_usuarios = new QPushButton(gridLayoutWidget);
        btn_usuarios->setObjectName("btn_usuarios");

        gridLayout->addWidget(btn_usuarios, 1, 0, 1, 1);


        retranslateUi(Home);

        QMetaObject::connectSlotsByName(Home);
    } // setupUi

    void retranslateUi(QWidget *Home)
    {
        Home->setWindowTitle(QCoreApplication::translate("Home", "Home", nullptr));
        btn_consultar->setText(QCoreApplication::translate("Home", "CONSULTAR", nullptr));
        btn_registrar->setText(QCoreApplication::translate("Home", "REGISTRAR", nullptr));
        btn_usuarios->setText(QCoreApplication::translate("Home", "USUARIOS", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Home: public Ui_Home {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_HOME_H
