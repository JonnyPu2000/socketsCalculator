package Cliente;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import Comum.Conexao;
import Comum.MsgReq;

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
        char  op;
        Float num1;
        Float num2;


        System.out.println("Insira a operação a ser realizada(+,-,/,*):");
        op = entrada.next().charAt(0);
        

        System.out.println("Insira o primeiro número:");
        num1 = entrada.nextFloat();
        

        System.out.println("Insira o segundo número:");
        num2 = entrada.nextFloat();
        
        MsgReq msgReq = new MsgReq(op,num1,num2);
        c.send(socket, msgReq);

        String texto;
        entrada.close();
        new Cliente();
        
        
                         // fase de dados
        System.out.println("Enviando " + num1 + op + num2);
        
        try {
            socket.close();                               // fase de desconex�o
        } catch (IOException e) {
            System.out.println("N�o encerrou a conex�o corretamente" + e.getMessage());
        }
    }
}
