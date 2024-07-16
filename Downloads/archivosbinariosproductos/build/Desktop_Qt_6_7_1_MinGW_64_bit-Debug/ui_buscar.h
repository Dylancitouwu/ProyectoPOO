/********************************************************************************
** Form generated from reading UI file 'buscar.ui'
**
** Created by: Qt User Interface Compiler version 6.7.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_BUSCAR_H
#define UI_BUSCAR_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_buscar
{
public:
    QWidget *gridLayoutWidget;
    QGridLayout *gridLayout;
    QLineEdit *txt_buscarc;
    QLabel *label;
    QHBoxLayout *horizontalLayout;
    QPushButton *btn_buscar;
    QPushButton *btn_cancelar;

    void setupUi(QWidget *buscar)
    {
        if (buscar->objectName().isEmpty())
            buscar->setObjectName("buscar");
        buscar->resize(197, 116);
        gridLayoutWidget = new QWidget(buscar);
        gridLayoutWidget->setObjectName("gridLayoutWidget");
        gridLayoutWidget->setGeometry(QRect(10, 10, 178, 95));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout->setObjectName("gridLayout");
        gridLayout->setContentsMargins(0, 0, 0, 0);
        txt_buscarc = new QLineEdit(gridLayoutWidget);
        txt_buscarc->setObjectName("txt_buscarc");

        gridLayout->addWidget(txt_buscarc, 1, 0, 1, 1);

        label = new QLabel(gridLayoutWidget);
        label->setObjectName("label");

        gridLayout->addWidget(label, 0, 0, 1, 1);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName("horizontalLayout");
        btn_buscar = new QPushButton(gridLayoutWidget);
        btn_buscar->setObjectName("btn_buscar");

        horizontalLayout->addWidget(btn_buscar);

        btn_cancelar = new QPushButton(gridLayoutWidget);
        btn_cancelar->setObjectName("btn_cancelar");

        horizontalLayout->addWidget(btn_cancelar);


        gridLayout->addLayout(horizontalLayout, 2, 0, 1, 1);


        retranslateUi(buscar);

        QMetaObject::connectSlotsByName(buscar);
    } // setupUi

    void retranslateUi(QWidget *buscar)
    {
        buscar->setWindowTitle(QCoreApplication::translate("buscar", "Form", nullptr));
        label->setText(QCoreApplication::translate("buscar", "Ingrese el c\303\263digo", nullptr));
        btn_buscar->setText(QCoreApplication::translate("buscar", "Buscar", nullptr));
        btn_cancelar->setText(QCoreApplication::translate("buscar", "Cancelar", nullptr));
    } // retranslateUi

};

namespace Ui {
    class buscar: public Ui_buscar {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_BUSCAR_H
