/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIServer;

//precisa importar a implementação do AcessoImpl
import com.br.lp3.acesso.AcessoImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Castelo
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.createRegistry(/*numPorta*/); //nao sei o numero da porta que devemos usar
            registro.rebind("Acesso", new AcessoImpl());
            System.out.println("Serviço registrado!");
        } catch (RemoteException e) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
