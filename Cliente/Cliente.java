package Cliente;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import Comum.Conexao;
import Comum.MsgReq;
import Comum.MsgResp;

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

        MsgResp resposta = new MsgResp();

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
        

        String texto;
        entrada.close();
        new Cliente();
        c.send(socket, msgReq);
        
                         // fase de dados
        System.out.println("Enviando " + num1 + op + num2);
        
        

        resposta = (MsgResp) c.receive(socket);

        if (resposta.getStatus() == 0) {
            System.out.println("Status:"+ resposta.getStatus() + "\nResposta da Operação: " + resposta.getResultado());
        }
        if (resposta.getStatus() == 1) {

            System.out.println("Operação Inválida! \nTente Novamente");
            
        }
        if(resposta.getStatus() == 2){

            System.out.println("Divisão Por 0! \nTente Novamente");
        }
        
        
        try {
            socket.close();                               // fase de desconex�o
        } catch (IOException e) {
            System.out.println("N�o encerrou a conex�o corretamente" + e.getMessage());
        }
    }
}
