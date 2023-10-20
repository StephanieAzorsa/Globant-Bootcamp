## Java Excepciones

Al finalizar la guía, **es el momento de validar lo que has aprendido hasta ahora**. Por eso, es importante responder el Check de conocimiento. ¡Aprovecha este espacio para chequear qué tal vienes hasta aquí!

Antes de resolver este cuestionario te recomendamos haber visto con atención
el/los videos, la guía de este tema y haber resuelto los ejercicios. Si
ya lo hiciste, ¡adelante!

_Tendrás un único intento_

¡Buena suerte!

### 1) La clase Error maneja errores:

- [ ] a) Del código
- [X] b) De la Maquina Virtual de Java
- [ ] c) De Netbeans
- [ ] d) Ninguna de las anteriores

### 2) La clase Exception maneja errores:

- [X] a) Del código
- [ ] b) De la Maquina Virtual de Java
- [ ] c) De Netbeans
- [ ] d) Ninguna de las anteriores

### 3) La clase padre de todas las excepciones y errores es la clase

- [ ] a) `Error`
- [ ] b) `Exception`
- [X] c) `Throwable`
- [ ] d) Ninguna de las anteriores

### 4) Las excepciones se manejan con el bloque:

- [ ] a) `Finally`
- [ ] b) `Throws`
- [X] c) `Try Catch`
- [ ] d) `Throw`

### 5) Para cerrar recursos después de una operación usamos el bloque:

- [X] a) `Finally`
- [ ] b) `Throws`
- [ ] c) `Try Catch`
- [ ] d) `Throw`

### 6) Cuando queremos informar que un método puede tirar una excepción usamos la palabra reservada:

- [ ] a) `Finally`
- [X] b) `Throws`
- [ ] c) `Try Catch`
- [ ] d) `Throw`

### 7) Cuando queremos lanzar una excepción de manera explicita usamos el bloque:

- [ ] a) `Finally`
- [ ] b) `Throws`
- [ ] c) `Try Catch`
- [X] d) `Throw`


### 8) En Java la diferencia entre throws y throw es:

- [ ] a) throws arroja una excepción y throw indica el tipo de excepción que no maneja el método
- [ ] b) throws se usa en los métodos y throw en los constructores
- [X] c) throws indica el tipo de excepción que maneja el método y throw arroja una excepción
- [ ] d) Ninguna de las anteriores

### 9) Teniendo el siguiente código, indicar que excepción se debería manejar

```java
public class Main {
    public static void main(String[] args) {
        int division = 10/ 0 ;
    }
}
```

- [ ] a) `NullPointerException`
- [X] b) `ArithmeticException`
- [ ] c) `RuntimeException`
- [ ] d) `ArrayIndexOutOfBoundsException`

### 10) Teniendo el siguiente código, indicar que excepción se debería manejar

```java
public class Main {
    public static void main(String[] args) {
        int[] vector = new int [5];
        
        for (int i = 0; i < 10; i++) {
            vector[i] = 1;
        }
    }
}
```

- [ ] a) `NullPointerException`
- [ ] b) `ArithmeticException`
- [ ] c) `RuntimeException`
- [X] d) `ArrayIndexOutOfBoundsException`