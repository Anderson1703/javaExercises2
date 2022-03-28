package com.ADNcompany;
import com.ADNcompany.Contrato.UsersCRUD;
import com.ADNcompany.Usuarios.Empleados;
import com.ADNcompany.Usuarios.Usuario;
import com.ADNcompany.portafolio.DatabaseOfUsers;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
   private static UsersCRUD database = new DatabaseOfUsers();
    public static void main(String[] args) {
	// write your code here
        Bienvenida();

    }

    public static void Bienvenida(){
        System.out.println("!Bienvenido!");
        System.out.println( "Qien eres: ");
        System.out.println("1: Supervisor  2: Empleado");
        verificarTipoDeUsuario(scanner.nextInt());
    }

    public static void verificarTipoDeUsuario(Integer typeUsuario){
        if (typeUsuario==1){
            System.out.println("Tus opciones son: ");
            System.out.println("1: Crear Empleados  2:Ver Empleados");
            verificarOpcionDeSupervisor(scanner.nextInt());
        }
        else if (typeUsuario==2){
            System.out.println("Tus opciones son: ");
            System.out.println("1: Ver derecho a vaciones");
            verificarOpcionDeEmpleado(scanner.nextInt());
        }
        else{
            System.out.println("Elige una opcion Correcta");
        }
    }

    public static void verificarOpcionDeSupervisor(Integer OpcionDeSupervisor){
        if (OpcionDeSupervisor==1){
            crearUsuario();
        }
        else if (OpcionDeSupervisor==2){
            System.out.println("opcion en desarollo");
        }
        else{
            System.out.println("Elige una opcion Correcta");
        }
    }

    public static void verificarOpcionDeEmpleado(Integer OpcionDeEmpleado){
        if (OpcionDeEmpleado==1){
            verUsuarios();
        }
        else{
            System.out.println("Elige una opcion Correcta");
        }
    }

    public static void crearUsuario(){
        Usuario usuario;
        System.out.println("Cuantos Empleados deseas crear?");
       int cantidadUsuarios=scanner.nextInt();
        for (int i = 0; i < cantidadUsuarios ; i++) {
            System.out.println("Introduce el nombre del empleado " + (i+1));
            String nombre = scanner.next();
            System.out.println("Introduce el apellido del empleado " + (i+1));
            String apellido = scanner.next();
            System.out.println("Introduce la edad del empleado " + (i+1));
            int edad = scanner.nextInt();
            System.out.println("Introduce el email del empleado " + (i+1));
            String email = scanner.next();
            System.out.println("Introduce el telefono del empleado " + (i+1));
            String telefono = scanner.next();
            System.out.println("Introduce el sueldo del empleado " + (i+1));
            int sueldo = scanner.nextInt();
            System.out.println("Introduce el departamento al que pertenece el empleado " + (i+1));
            String departamento = scanner.next();
            System.out.println("Introduce en numero, la cantida de anos de antiguedad en la empresa de dicho empleado");
            int antiguedad = scanner.nextInt();
            usuario = new Empleados(nombre,apellido,edad, email,telefono,sueldo,departamento,antiguedad);
            database.saveUser(usuario);
            System.out.println("presiona 1: para ver ver los derecho a vaciones de " + usuario.nombre + " y 2: para continuar");
            int opcion = scanner.nextInt();
             if (opcion==1){
                verDerechoAVacaciones(usuario);
            }
        }
        System.out.println("Presiona 1: para finalizar y 2: para ver Empleados");
        int opcion = scanner.nextInt();
        if (opcion==2){
            verUsuarios();
        }
    }

    public static void verDerechoAVacaciones (Usuario usuario){
        System.out.println("El Empleado " + usuario.nombre + " tiene derecho a " + usuario.vacaciones + " de vacaciones");
    }

    public static void verUsuarios (){
        for (Usuario empleado : database.getusers()) {
            System.out.println(empleado.nombre);
        }
    }

}
