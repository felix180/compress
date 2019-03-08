package test.compress.service;

import org.springframework.stereotype.Service;
import test.compress.controller.CompressResponse;

@Service
public class CompressService {
    private static final String CANDIDATO ="Felix Angulo";

    public String getCandito() {
        return CANDIDATO;
    }

    public String  compress(String value){
        int contador = 1 ;
        String old = "";
        StringBuilder result = new StringBuilder();
        if(value!= null || value.isEmpty()){
            value = value.trim().toUpperCase().replace(" ","");
        }else {
            return "";
        }
        for(String letra : value.split("")){
            if(old.equals(letra)){
                contador++;
            }else {
                if(!old.isEmpty()){
                    result.append(contador).append(old);
                    contador = 1;
                }
            }
            old = letra;
        }
        result.append(contador).append(old);
        return result.toString();
    }
}
