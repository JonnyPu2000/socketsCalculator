import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    static Conexao c;
    static Socket socket;

    public Cliente() {
        try {
            socket = new Socket("localhost", 9600);
        } // fase de conex�o
        catch (Exception e) {
            System.out.println("Nao consegui resolver o host...");
        }
    }

  

    public static void main(String args[]){

        Scanner entrada =  new Scanner(System.in);
        String  op;
        Float num1;
        Float num2;


        System.out.println("Insira a operação a ser realizada(+,-,/,*):");
        op = entrada.nextLine();
        System.out.println("Insira o primeiro número:");
        num1 = entrada.nextFloat();
        System.out.println("Insira o segundo número:");
        num2 = entrada.nextFloat();

        String texto;
        new Cliente();
        
        c.send(socket,op,num1,num2);
        texto = c.receive(socket);                    // fase de dados
        System.out.println(num1,op,num2);
        
        try {
            socket.close();                               // fase de desconex�o
        } catch (IOException e) {
            System.out.println("N�o encerrou a conex�o corretamente" + e.getMessage());
        }
    }
}
