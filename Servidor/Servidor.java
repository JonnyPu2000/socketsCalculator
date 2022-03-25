package Servidor;

import java.io.*;
import java.net.*;

import Comum.Conexao;
import Comum.MsgReq;

public class Servidor {

    static ServerSocket serversocket;
    static Socket client_socket;
    static Conexao c;
    static String msg;

    public Servidor() {

        try {
            serversocket = new ServerSocket(9600);
            System.out.println("Criando o Server Socket");
        } catch (Exception e) {
            System.out.println("Nao criei o server socket...");
        }
    }

    public static void main(String args[]) {
        
        
        
        MsgReq requisicao =  new MsgReq();
        new Servidor();
        if (connect()) {
            requisicao = (MsgReq) c.receive(client_socket);
            System.out.println("OP1: " + requisicao.getOp1());
            System.out.println("Operação: " + requisicao.getOperacao());
            System.out.println("OP1: " + requisicao.getOp2());
            try {
                client_socket.close();
                serversocket.close();
            } // desconexao
            catch (Exception e) {
                System.out.println("N�o encerrou a conex�o corretamente" + e.getMessage());
            }
        }
    }

    static boolean connect() {
        boolean ret;
        try {
            client_socket = serversocket.accept();              // fase de conexão
            ret = true;
        } catch (Exception e) {
            System.out.println("N�o fez conex�o" + e.getMessage());
            ret = false;
        }
        return ret;
    }
}
