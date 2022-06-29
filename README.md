<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO ACADÉMICO DE INGENIERÍA DE SISTEMAS E INFORMÁTICA</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Informe de Práctica de Laboratorio</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLD-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME  DE LABORATORIO</span><br />
</div>

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Árboles</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>05</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA INICIO::</td><td>20-Jun-2022</td><td>FECHA FIN:</td><td>24-Jun-2022</td><td>DURACIÓN:</td><td>02 horas</td>
</tr>
<tr><td colspan="6">RECURSOS:
    <ul>
        <li>https://www.w3schools.com/java/</li>
        <li>https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-enterprise-java-and-web-developers</li>
        <li>https://algorithmtutor.com/Data-Structures/Tree/AVL-Trees/</li>
        <li>https://docs.oracle.com/javase/tutorial/java/generics/types.html</li>
</td>
</<tr>
<tr><td colspan="6">Alumnos:
<ul>
<li>Vladimir Arturo Sulla Quispe - vsullaq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
<tr><td colspan="6">DOCENTES:
<ul>
<li>Richart Smith Escobedo Quispe - rescobedoq@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tdbody>
</table>

# SOLUCION Y RESULTADOS
## I. SOLUCION DE EJERCICIOS/PROBLEMAS
### ORGANIZACION

```

├───Main.java
├───README.md
│
├───datastructures
│   ├───AVLTree.java
│   ├───AVLTreeInterface.java
│   └───Node.java
│       
├───exercises
│   └───Exercises.java
│       
└───imagenes
    
``` 
Donde:

- Main.java donde se hacen los test del ejercicio 1 y 3
- excecises donde se almacena la clase que contiene el ejercicio 1
- datastructure contiene los archivos correspondientes a la implementacion del arbol AVL
- imagenes donde se almacenan las imagenes que contiene README.md
    
### RESOLUCION
#### EJERCICIO 1

```java
    String begin = "([{";
    String end = ")]}";
    boolean balance;
    int i = 0;
    while(i < a.length()/2) {
        balance = begin.indexOf(a.charAt(i)) != end.indexOf(a.charAt(a.length()- 1 - i));
        if (balance) {
            return "NO";
        }
            i++;
    }
    return "YES";
```
    
#### EJERCICIO 2
    
Simular las siguientes operaciones de un árbol AVL
-Inserción: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190.
-Para este ejercicio tienes que escribir el paso a paso del desarrollo de cada operación donde se muestra gráficamente el estado del árbol así como el factor de equilibrio para cada nodo y el tipo de operación que se está realizando, es decir, inserción, eliminación, rotación.

- Primero se inserta el primer nodo<br>
![arbol](imagenes/1.png)

- Luego al insertar 200 no cambia<br>
![arbol](imagenes/2.png)

- Al insertar 300 se hace una rotacion simple izquierda<br>
![arbol](imagenes/3.png)

- El 400 se inserta normalmente<br>
![arbol](imagenes/4.png)
                           
- El numero 500 requiere una rotacion simple izquierda<br>
![arbol](imagenes/5.png)

- El 50 se inserta normalmente<br>
![arbol](imagenes/6.png)                    
                           
- Al insertar 25 se requiere una rotacion simple derecha<br>
![arbol](imagenes/7.png)
                           
- Insertar 350 no genera problemas<br>
![arbol](imagenes/8.png)

- Insertar 375 requiere una rotacion simple izquierda<br>
![arbol](imagenes/9.png)
                   
- Insertar 360 requiere una rotacion derecha y luego una izquierda<br>
![arbol](imagenes/15.png)

- Insertar 355 requiere una rotacion derecha e izquierda en 350<br>
![arbol](imagenes/10.png)

- Insertar 150 tambien requiere rotacion derecha izquierda pero en 100<br>
![arbol](imagenes/11.png)
                           
- Insertar 175 no requiere rotaciones<br>
![arbol](imagenes/12.png)
                           
- La inserccion de 120 tampoco require de rotaciones<br>
![arbol](imagenes/13.png)
                    
- Y finalmente, 190 require rotar a la izquierda y luego derecha en 175<br>
![arbol](imagenes/14.png)

-Después de crear un árbol AVL, realice la eliminación: 100 - 200 - 300 - 400 - 500 - 50 - 25 - 350 - 375 - 360 - 355 - 150 - 175 - 120 - 190.

- Elimiacion de 100 implica una rotacion izquierda
![arbol](imagenes/16.png)

- 200<br>
![arbol](imagenes/17.png)

- 300<br>
![arbol](imagenes/18.png)

- 400<br>
![arbol](imagenes/19.png)
  
- 500<br>
![arbol](imagenes/20.png)

- 50<br>
![arbol](imagenes/21.png)

- 25<br>
![arbol](imagenes/22.png)
  
- 350<br>
![arbol](imagenes/23.png)

- 375<br>
![arbol](imagenes/24.png)

- 360<br>
![arbol](imagenes/25.png)

- 355<br>
![arbol](imagenes/26.png)

- 150<br>
![arbol](imagenes/27.png)

- 175<br>
![arbol](imagenes/28.png)

- 120<br>
![arbol](imagenes/29.png)

-190<br>
    
#### EJERCICIO 3
    
## II. CONCLUSIONES
    
# CONCLUSIONES

    
# RETROALIMENTACION GENERAL
    
    
# REFERENCIAS Y BIBLIOGRAFIA

```
https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
```
