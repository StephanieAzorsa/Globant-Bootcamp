## Java Introducción

### Q1. El método main puede estar o no en un proyecto Java funcional

- [ ] Verdadero
- [x] Falso

### Q2. ¿Qué hace el siguiente código?

```java
int aus = 0;
aux++;
```

- [ ] Agrega una nueva variable aux
- [x] Incrementa en 1 a la variable aux 
- [ ] Multiplica por 2 a la variable aux

### Q3. ¿Cuál es la salida del siguiente código?

```java
int num1 = 6;
int num2 = 8;

System.out.println(num1==num2);
```
- [ ] 6
- [x] False
- [ ] 8
- [ ] True

### Q4. Las variables siempre deben especificar de qué tipo son al ser declaradas.

- [x] Verdadero
- [ ] Falso

### Q5. Tipos de datos en Java:

- [x] byte, short, int, long, float, double, boolean, char, String
- [ ] Cadena, entero, real, lógico
- [ ] int, double, boolean, String, void, null

### Q6. ¿Cuál de los siguientes métodos NO es parte de la clase String?

- [ ] `.toUpperCase()`
- [ ] `.isEmpty()`
- [ ] `concat()`
- [x] `.stringLength()`


## POO

### Q1. ¿Qué son los atributos?

- [ ] Funciones que el objeto puede realizar
- [x] Variables que guardan información sobre el objeto
- [ ] Métodos de consulta o modificación de un objeto

### Q2. ¿Qué es un constructor?

- [ ] Un método que nos define qué atributos tiene la clase
- [ ] Un método void
- [x] Es un método que nos permite instanciar un objeto de la clase donde se encuentra


### Q3. ¿Cómo accedo a los atributos de un objeto?

- [ ] Con el símbolo `!` luego del nombre del objeto
- [ ] Con el símbolo `_` luego del nombre del objeto
- [x] Con el símbolo `.` luego del nombre del objeto


### Q4. ¿Qué significa POO?

- [ ] Programación, Observación y Orientación
- [x] Programación Orientada a Objetos
- [ ] Programación Objetiva Orientada

### Q5. ¿Qué hace el siguiente código?

```java
Persona p1 = new Persona();
```

- [x] Instancia un objeto de tipo Persona llamado p1
- [ ] Duplica un objeto persona
- [ ] Crea una nueva clase llamada Persona


### Q5. ¿Cuál es la diferencia entre clases y objetos?

- [x] Las clases son “moldes” y los objetos son modelados a partir de esos moldes, también llamados “instancias”
- [ ] Las clases y los objetos son los mismos
- [ ] Los objetos son abstracciones del mundo real, las clases son de lunes a jueves

### Q6. ¿De qué se encarga Clase servicio o control?

- [x] Se encarga de crear y modificar objetos, teniendo cada clase de entidad una clase control.
- [ ] Se encarga de controlar que el programa no consuma memoria al instanciar objetos.
- [ ] Se encarga de recibir los datos que ingresa el usuario por teclado

### Q7. ¿Cuál es la salida de este código?

```java
Persona p1 = new Persona();
Persona p2 = new Persona();

p1.setNombre("Albus Dumbledore");
p2.setNombre(p1.getNombre());

System.out.println(p1.equals(p2));
System.out.println(p1.getNombre().equals(p2.getNombre()));
```

- [x] False, True
- [ ] True, True
- [ ] False, False
- [ ] True, False

### Q8. ¿Cuál de estos servicios trabaja de la manera correcta?

```java
public void conocerNombre(Persona x){
    System.out.println("La persona se llama: " + x.getNombre());
}

public void conocerNombre(String nombre){
    System.out.println("La persona se llama: " + nombre);
}
```

- [x] El que obtiene el nombre a través de un objeto Persona
- [ ] El que obtiene el nombre desde un String

### Q9. ¿Cuáles son los modificadores de acceso?

- [ ] Public, notPublic
- [ ] Public, static, abstract
- [x] Public, private, protected


### Q10. ¿Qué es el encapsulamiento?

- [ ] Hace referencia a los métodos constructores con y sin parámetros
- [ ] Hace referencia a separar el código en “cápsulas” para mejor lectura del mismo.
- [x] Hace referencia a crear métodos para obtener y modificar información de un objeto, manteniendo oculto lo que hace un objeto por dentro.


## Colecciones


### Q1. Los conjuntos o Sets pueden contener elementos repetidos, simplemente se duplica el valor

- [x] Falso
- [ ] Verdadero

### Q2. El Java Collection Framework es:

- [ ] Una base de datos
- [x] Un conjunto de clases e interface
- [ ] Un conjunto de objetos

### Q3. Los mapas son colecciones de Llave/Valor. Las llaves son únicas pero los valores sí pueden repetirse.

- [x] Verdadero
- [ ] Falso

### Q4. Un framework es un marco de trabajo el cual contiene un conjunto estandarizado de conceptos, prácticas y criterios para hacer frente a un tipo de problemática particular y resolver nuevos problemas de índole similar.

- [x] Verdadero
- [ ] Falso

### Q5. ¿Qué puede almacenar una colección?

- [x] Objetos de la misma clase
- [ ] Objetos mezclados sin importar de qué clase son
- [ ] Datos primitivos, como char e int

### Q6. ¿Cuál de las siguientes herramientas nos facilita recorrer una lista?

- [ ] Bucle For
- [ ] Un Switch con condicionales en cada caso
- [x] Bucle ForEach


### Q7. ¿Cómo se define el tamaño de una colección?

- [ ] Con el método size()
- [ ] Se define al declarar la colección
- [x] Las colecciones son dinámicas, su tamaño depende de la cantidad de objetos que le agreguemos o quitemos


### Q8. Las listas son colecciones de objetos ordenados por posición donde los elementos pueden repetirse.

- [ ] Falso
- [x] Verdadero


## Relaciones entre Clases

### Q1. En una relación de agregación, un objeto depende del otro, no pueden existir individualmente.

- [ ] Verdadero
- [x] Falso


### Q2. Las relaciones entre clases realmente significan que una clase contiene una referencia a un objeto u objetos, de la otra clase en la forma de un atributo.

- [ ] Falso
- [x] Verdadero


### Q3. Las relaciones son siempre unidireccionales

- [x] Falso
- [ ] Verdadero

### Q4. La composición es un tipo de relación donde un objeto complejo es conformado por objetos más pequeños.

- [x] Verdadero
- [ ] Falso

### Q5. Las relaciones pueden ser

- [ ] Uno a Uno y Muchos a Muchos
- [x] Uno a Uno, Cero a Uno, Uno a Muchos y Cero a Muchos
- [ ] Uno a Uno solamente

### Q6. Las clases no actúan aisladas entre sí, al contrario, las clases están relacionadas unas con otras.

- [x] Verdadero
- [ ] Falso


## Herencia

### Q1. ¿Qué es la Super Clase?

- [ ] Una clase con muchos métodos
- [x] Como se llama a la clase superior(Padre o Madre)
- [ ] Una clase con superpoderes

### Q2. ¿Qué hace la anotación @Override?

- [ ] Permite que la clase hija elimine métodos que considere innecesarios
- [x] Permite que la clase hija haga funcionar un método de manera diferente a la clase padre
- [ ] Desbloquea nuevos métodos disponibles en Java

### Q3. Una clase hija puede heredar de muchas clases padres.

- [ ] Verdadero
- [x] Falso

### Q4. ¿En el siguiente código ¿cuál es la clase padre?

```java
public class Persona extends SerVivo {
    String nombre;
}
```

- [ ] public class
- [x] SerVivo
- [ ] Persona
- [ ] Java.util

### Q5. ¿Para qué sirve el modificador Protected?

- [x] Para que los atributos sean accesibles sólo por las clases que heredan sin usar getters ni setters
- [ ] Para proteger el código para que no sea borrado
- [ ] Para que suene a que sabemos más que los demás

### Q6. Una clase padre puede heredar a muchas clases hijas.

- [ ] Falso
- [x] Verdadero

### Q7. La Sub Clase hereda el constructor

- [ ] Verdadero
- [x] Falso

### Q8. La Sub Clase hereda atributos y métodos.

- [x] Verdadero
- [ ] Falso

### Q9. ¿Cuándo usamos la palabra reservada `super`?

- [ ] Cuando queremos referirnos a una clase que está muy bien hecha
- [x] Cuando queremos acceder a los métodos, atributos y constructores de la clase superior
- [ ] Cuando queremos acceder a los métodos, atributos y constructores de la clase inferior


## Manejo de Excepciones

### Q1. Un objeto Exception contiene información sobre un error ocurrido.

- [x] Verdadero
- [ ] Falso

### Q2. Una excepción es un evento que ocurre durante la ejecución de un programa que interrumpe el flujo normal de las instrucciones del programa.

- [ ] Falso
- [x] Verdadero


### Q3. Si una excepción se produce en el bloque catch, puede atraparse en el bloque try y manejarla.

- [ ] Verdadero
- [x] Falso


### Q4. ¿Cuál es el resultado del siguiente código? Siguiendo el ejemplo que venimos viendo

```java
Persona p1 = new Persona();
String nombre = null;

try {
    if(!nombre.equals(null)) {
        p1.setNombre(nombre);
    }
} catch (Exception e) {
    System.out.println("El nombre no puede ser nulo");
}
```

- [x] Se imprime por consola "El nombre no puede ser nulo"
- [ ] El nombre de p1 es null
- [ ] El nombre de p1 queda vacío

### Q5. Cuando se lanza una excepción no hay nada más que hacer, termina el programa.

- [ ] Verdadero
- [x] Falso


### Q6. Sólo se puede usar 1 bloque catch por bloque try.

- [ ] Verdadero
- [x] Falso


### Q7. Para aclarar que un método puede lanzar un error se coloca la palabra `extends`.

- [x] Falso
- [ ] Verdadero


## MySQL

Resultados del ejercicio de los candados

### Q1. Candado A

- [ ] Clave: 15935
- [ ] Clave: 16832
- [x] Clave: 14043
- [ ] Clave: 13539

### Q2. Candado D

- [x] Clave: 191
- [ ] Clave: 1063
- [ ] Clave: 153
- [ ] Clave: 101

### Q3. Candado A

Posición 1
- [x] Posición 2
- [ ] Posición 3
- [ ] Posición 4

### Q4. Candado C

- [x] Clave: 631
- [ ] Clave: 963
- [ ] Clave: 145
- [ ] Clave: 601

### Q5. Candado B

- [ ] Clave: 4830
- [ ] Clave: 4380
- [x] Clave: 3480
- [ ] Clave: 3830

### Q6. Candado D

- [ ] Posición 1
- [ ] Posición 2
- [ ] Posición 3
- [x] Posición 4

### Q7. Candado B

- [ ] Posición 1
- [ ] Posición 2
- [x] Posición 3
- [ ] Posición 4

### Q8. Candado C

- [x] Posición 1
- [ ] Posición 2
- [ ] Posición 3
- [ ] Posición 4





