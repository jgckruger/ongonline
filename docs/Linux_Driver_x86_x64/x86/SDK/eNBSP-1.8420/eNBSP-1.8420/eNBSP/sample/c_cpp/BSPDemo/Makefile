#############################################################################
# Makefile for building: layout
# Generated by qmake (1.04a) (Qt 3.1.1) on: Wed Oct 20 05:16:32 2004
# Project:  NBioBSPDemo.pro
# Template: app
# Command: $(QMAKE) -o Makefile NBioBSPDemo.pro
#############################################################################

####### Compiler, tools and options

CC       = gcc
CXX      = g++
LEX      = flex
YACC     = yacc
CFLAGS   = -pipe -Wall -W -O2 -march=i386 -mcpu=i686 -g -DGLX_GLXEXT_LEGACY -fno-use-cxa-atexit -fno-exceptions  -DQT_NO_DEBUG
CXXFLAGS = -pipe -Wall -W -O2 -march=i386 -mcpu=i686 -g -DGLX_GLXEXT_LEGACY -fno-use-cxa-atexit -fno-exceptions  -DQT_NO_DEBUG
LEXFLAGS = 
YACCFLAGS= -d
INCPATH  = -I$(QTDIR)/mkspecs/default -I. -I$(QTDIR)/include
LINK     = g++
LFLAGS   = 
LIBS     = $(SUBLIBS) -L$(QTDIR)/lib -L/usr/X11R6/lib -lqt-mt -lXext -lX11 -lm -L/lib -lpthread /lib/libNBioBSP.so
AR       = ar cqs
RANLIB   = 
MOC      = $(QTDIR)/bin/moc
UIC      = $(QTDIR)/bin/uic
QMAKE    = qmake
TAR      = tar -cf
GZIP     = gzip -9f
COPY     = cp -f
COPY_FILE= $(COPY) -p
COPY_DIR = $(COPY) -pR
DEL_FILE = rm -f
SYMLINK  = ln -sf
DEL_DIR  = rmdir
MOVE     = mv -f
CHK_DIR_EXISTS= test -d
MKDIR    = mkdir -p

####### Output directory

OBJECTS_DIR = ./

####### Files

HEADERS = NBioBSPDemo.h
SOURCES = NBioBSPDemo.cpp
OBJECTS = NBioBSPDemo.o
FORMS = 
UICDECLS = 
UICIMPLS = 
SRCMOC   = moc_NBioBSPDemo.cpp
OBJMOC = moc_NBioBSPDemo.o
DIST	   = NBioBSPDemo.pro
QMAKE_TARGET = NBioBSPDemo
DESTDIR  = 
TARGET   = NBioBSPDemo

first: all
####### Implicit rules

.SUFFIXES: .c .cpp .cc .cxx .C

.cpp.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.cc.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.cxx.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.C.o:
	$(CXX) -c $(CXXFLAGS) $(INCPATH) -o $@ $<

.c.o:
	$(CC) -c $(CFLAGS) $(INCPATH) -o $@ $<

####### Build rules

all: Makefile $(TARGET)

$(TARGET): $(UICDECLS) $(OBJECTS) $(OBJMOC) 
	$(LINK) $(LFLAGS) -o $(TARGET) $(OBJECTS) $(OBJMOC) $(LIBS)

mocables: $(SRCMOC)

$(MOC): 
	( cd $(QTDIR)/src/moc ; $(MAKE) )

Makefile: NBioBSPDemo.pro  $(QTDIR)/mkspecs/default/qmake.conf 
	$(QMAKE) -o Makefile_first NBioBSPDemo.pro
qmake: 
	@$(QMAKE) -o Makefile NBioBSPDemo.pro

dist: 
	@mkdir -p .tmp/layout && $(COPY_FILE) --parents $(SOURCES) $(HEADERS) $(FORMS) $(DIST) .tmp/layout/ && ( cd `dirname .tmp/layout` && $(TAR) layout.tar layout && $(GZIP) layout.tar ) && $(MOVE) `dirname .tmp/layout`/layout.tar.gz . && $(DEL_FILE) -r .tmp/layout

mocclean:
	-$(DEL_FILE) $(OBJMOC)
	-$(DEL_FILE) $(SRCMOC)

uiclean:

yaccclean:
lexclean:
clean: mocclean
	-$(DEL_FILE) $(OBJECTS) 
	-$(DEL_FILE) *~ core *.core
	-$(DEL_FILE) $(TARGET) 


####### Sub-libraries

distclean: clean
	-$(DEL_FILE) $(TARGET) $(TARGET)


FORCE:

####### Compile

NBioBSPDemo.o: NBioBSPDemo.cpp \
		NBioBSPDemo.h \
		../../../include/NBioAPI_Extension.h \
		../../../include/NBioAPI.h \
		../../../include/NBioAPI_Basic.h \
		../../../include/NBioAPI_Type.h \
		../../../include/NBioAPI_Error.h

moc_NBioBSPDemo.o: moc_NBioBSPDemo.cpp \
		NBioBSPDemo.h \
		../../../include/NBioAPI_Extension.h \
		../../../include/NBioAPI.h \
		../../../include/NBioAPI_Basic.h \
		../../../include/NBioAPI_Type.h \
		../../../include/NBioAPI_Error.h

moc_NBioBSPDemo.cpp: $(MOC) NBioBSPDemo.h
	$(MOC) NBioBSPDemo.h -o moc_NBioBSPDemo.cpp

####### Install

install: all 

uninstall: 

