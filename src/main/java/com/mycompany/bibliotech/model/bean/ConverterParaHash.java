package com.mycompany.bibliotech.model.bean;

import java.security.NoSuchAlgorithmException;

public class ConverterParaHash {

    // ESSE É UM ARQUIVO DE TESTES QUE SERÁ REMOVIDO DEPOIS (PROVAVELMENTE).
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        String textoParaConverter = "senha123";
        
        Hash hash = new Hash();
        
        System.out.println("O resultado do hash: " + hash.geradorDeHash(textoParaConverter));
    }
    
}
