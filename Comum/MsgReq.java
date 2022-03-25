package Comum;

import java.io.Serializable;

public class MsgReq implements Serializable {

    private char operacao;
    private float op1;
    private float op2;

    public MsgReq(char operacao,Float op1, Float op2) {
        this.operacao = operacao;
        this.op1 = op1;
        this.op2 = op2;
    }

    
    public MsgReq() {
       
    }

    public char getOperacao() {
        return this.operacao;
    }

    public void setOperacao(char operacao) {
        this.operacao = operacao;
    }

    public float getOp1() {
        return this.op1;
    }

    public void setOp1(float op1) {
        this.op1 = op1;
    }

    public float getOp2() {
        return this.op2;
    }

    public void setOp2(float op2) {
        this.op2 = op2;
    }
    
}
