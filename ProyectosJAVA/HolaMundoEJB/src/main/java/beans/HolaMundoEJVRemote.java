/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 *
 * @author tony
 */

@Remote //Para cliente haga llamada de forma remota
public interface HolaMundoEJVRemote {
    
    public int sumar(int a, int b);
    
}
