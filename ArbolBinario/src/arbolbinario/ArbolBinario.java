/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 *///Katherine Ortega -6014550//
package arbolbinario;

// Clase principal
public class ArbolBinario {

    // Clase Nodo
    static class Nodo {
        int dato;
        Nodo izquierdo, derecho;

        public Nodo(int dato) {
            this.dato = dato;
            izquierdo = derecho = null;
        }
    }

    // Raíz del árbol
    Nodo raiz;

    // Insertar nodo
    public Nodo insertar(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        }

        if (dato < raiz.dato) {
            raiz.izquierdo = insertar(raiz.izquierdo, dato);
        } else if (dato > raiz.dato) {
            raiz.derecho = insertar(raiz.derecho, dato);
        }

        return raiz;
    }

    // Inorden (Izq - Raíz - Der)
    public void inorden(Nodo raiz) {
        if (raiz != null) {
            inorden(raiz.izquierdo);
            System.out.print(raiz.dato + " ");
            inorden(raiz.derecho);
        }
    }

    // Preorden (Raíz - Izq - Der)
    public void preorden(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.dato + " ");
            preorden(raiz.izquierdo);
            preorden(raiz.derecho);
        }
    }

    // Postorden (Izq - Der - Raíz)
    public void postorden(Nodo raiz) {
        if (raiz != null) {
            postorden(raiz.izquierdo);
            postorden(raiz.derecho);
            System.out.print(raiz.dato + " ");
        }
    }

    // Buscar un dato
    public boolean buscar(Nodo raiz, int dato) {
        if (raiz == null) {
            return false;
        }

        if (dato == raiz.dato) {
            return true;
        }

        if (dato < raiz.dato) {
            return buscar(raiz.izquierdo, dato);
        } else {
            return buscar(raiz.derecho, dato);
        }
    }

    // MAIN
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        // Insertar datos
        arbol.raiz = arbol.insertar(arbol.raiz, 50);
        arbol.insertar(arbol.raiz, 30);
        arbol.insertar(arbol.raiz, 70);
        arbol.insertar(arbol.raiz, 20);
        arbol.insertar(arbol.raiz, 40);
        arbol.insertar(arbol.raiz, 60);
        arbol.insertar(arbol.raiz, 80);

        // Recorridos
        System.out.print("Inorden: ");
        arbol.inorden(arbol.raiz);

        System.out.print("\nPreorden: ");
        arbol.preorden(arbol.raiz);

        System.out.print("\nPostorden: ");
        arbol.postorden(arbol.raiz);

        // Buscar
        int valor = 40;
        if (arbol.buscar(arbol.raiz, valor)) {
            System.out.println("\nEl valor " + valor + " SI está en el árbol");
        } else {
            System.out.println("\nEl valor " + valor + " NO está en el árbol");
        }
    }
}
