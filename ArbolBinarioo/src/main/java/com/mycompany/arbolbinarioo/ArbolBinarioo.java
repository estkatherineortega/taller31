/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolbinarioo;

class Contacto {
    String nombre;
    String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}

class Nodo {
    Contacto contacto;
    Nodo izquierda, derecha;

    public Nodo(Contacto contacto) {
        this.contacto = contacto;
        izquierda = derecha = null;
    }
}

class ArbolContactos {
    Nodo raiz;

    // Insertar contacto
    public Nodo insertar(Nodo raiz, Contacto contacto) {
        if (raiz == null) {
            return new Nodo(contacto);
        }

        if (contacto.nombre.compareToIgnoreCase(raiz.contacto.nombre) < 0) {
            raiz.izquierda = insertar(raiz.izquierda, contacto);
        } else {
            raiz.derecha = insertar(raiz.derecha, contacto);
        }

        return raiz;
    }

    // Buscar contacto
    public Contacto buscar(Nodo raiz, String nombre) {
        if (raiz == null) return null;

        if (nombre.equalsIgnoreCase(raiz.contacto.nombre)) {
            return raiz.contacto;
        }

        if (nombre.compareToIgnoreCase(raiz.contacto.nombre) < 0) {
            return buscar(raiz.izquierda, nombre);
        } else {
            return buscar(raiz.derecha, nombre);
        }
    }

    // Mostrar contactos en orden alfabético
    public void mostrarEnOrden(Nodo raiz) {
        if (raiz != null) {
            mostrarEnOrden(raiz.izquierda);
            System.out.println(raiz.contacto.nombre + " - " + raiz.contacto.telefono);
            mostrarEnOrden(raiz.derecha);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArbolContactos agenda = new ArbolContactos();

        // Insertar contactos
        agenda.raiz = agenda.insertar(agenda.raiz, new Contacto("Carlos", "123"));
        agenda.raiz = agenda.insertar(agenda.raiz, new Contacto("Ana", "456"));
        agenda.raiz = agenda.insertar(agenda.raiz, new Contacto("Luis", "789"));
        agenda.raiz = agenda.insertar(agenda.raiz, new Contacto("Beatriz", "321"));

        // Mostrar contactos
        System.out.println("Contactos ordenados:");
        agenda.mostrarEnOrden(agenda.raiz);

        // Buscar un contacto
        System.out.println("\nBuscando contacto...");
        Contacto encontrado = agenda.buscar(agenda.raiz, "Luis");

        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.nombre + " - " + encontrado.telefono);
        } else {
            System.out.println("Contacto no encontrado");
        }
    }
}
