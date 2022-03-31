package Comum;

import java.io.Serializable;

public class MsgResp implements Serializable{

    private Float resultado;
    private int status;

    public MsgResp(Float resultado, int status){

        resultado =  this.resultado;
        status = this.status;
        
    }

    public MsgResp (){
        
    }

    public Float getResultado() {
        return this.resultado;
    }

    public void setResultado(Float resultado) {
        this.resultado = resultado;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
