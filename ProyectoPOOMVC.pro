QT = core

CONFIG += c++17 cmdline

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
        Sources/Cine.cpp \
        sources/Boleto.cpp \
        sources/Pelicula.cpp \
        sources/Sala.cpp \
        Sources/ControladorCine.cpp \
        Sources/VistaCine.cpp \
        main.cpp

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

HEADERS += \
    Controller/Headers/Cine.h \
    Model/headers/Boleto.h \
    Model/headers/Pelicula.h \
    Model/headers/Sala.h \
    View/Headers/ControladorCine.h \
    View/Headers/VistaCine.h
