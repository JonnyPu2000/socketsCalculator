package Comum;

import java.io.Serializable;

public class MsgReq implements Serializable {

    private String operacao;
    private float op1;
    private float op2;

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
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
