package Servidor;

import java.io.*;
import java.net.*;

import Comum.Conexao;
import Comum.MsgReq;
import Comum.MsgResp;

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
        int status;
        float resultado;
        MsgResp resposta =  new MsgResp();
        
        
        MsgReq requisicao =  new MsgReq();
        new Servidor();
        if (connect()) {

            

            requisicao = (MsgReq) c.receive(client_socket);
            System.out.println("OP1: " + requisicao.getOp1());
            System.out.println("Operação: " + requisicao.getOperacao());
            System.out.println("OP1: " + requisicao.getOp2());

            char operacao =  requisicao.getOperacao();
            Float num1 = requisicao.getOp1();
            Float num2 = requisicao.getOp2();
            
            if (operacao == '+' || operacao == '-' || operacao == '*' || operacao == '/'){

                if(operacao == '+'){

                    resultado = num1 + num2;
                    status =  0;
                    resposta.setResultado(resultado);
                    resposta.setStatus(status);
                    }
    
                if(operacao == '-'){
    
                    resultado = num1 - num2;
                    status =  0;
                    resposta.setResultado(resultado);
                    resposta.setStatus(status);
                    
                }
                if(operacao == '/'){
    
                    if (num2 != 0){
                    
                    resultado = num1 / num2;
                    
                    status =  0;
                    resposta.setResultado(resultado);
                    resposta.setStatus(status);
                    
                    
                    }
    
                    else{
    
                        status = 2;
                        resultado = 0;
                        resposta.setResultado(resultado);
                        resposta.setStatus(status);
                        
    
                    }
                }
                if(operacao == '*'){

                    resultado = num1 * num2;
                    status =  0;
                    resposta.setResultado(resultado);
                    resposta.setStatus(status);
                    
                }
             
            }
            else{
                status =  1;
                resultado = 0;
                resposta.setResultado(resultado);
                resposta.setStatus(status);
            }
            
            

            
            c.send(client_socket, resposta);

            





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
