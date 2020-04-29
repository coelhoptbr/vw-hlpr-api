/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coelhoptbr.vw.util;

import lombok.experimental.UtilityClass;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rodrigo
 */
@UtilityClass
public class Util {
    
    public static URI obterURI(String endpoint, Map<String, String> variaveisValores) {
        return
          ServletUriComponentsBuilder.fromCurrentContextPath()
              .path(endpoint)
              .buildAndExpand(variaveisValores)
              .toUri();
    }
    
    public static URI obterURI(String endpoint, String variavel, String valor) {
        Map mapVars = new HashMap<String, String>();
        mapVars.put(variavel, valor);
        
        return obterURI(endpoint, mapVars);
    }
    
}
