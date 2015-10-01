
package RMIClientProj;

import com.br.lp3.acesso.Acesso;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Castelo
 */
public class RMIClient {
    private static String nome;
    private static int pswd;
    
    public static void main(String[] args) {
        
        try {
            Registry registro = LocateRegistry.getRegistry("", /*numPorta*/);
            Acesso servico = (Acesso) registro.lookup("Acesso");
            
            int control = -1;
            
            while (control != -1) {
                //aqui precisamos receber o comando que o usuario selecionar= login ou novo usuario e atualizar
                //a variavel control com esse valor para identificar no switch abaixo
                
                switch (control) {
                    case 1:
                        servico.connect(nome, pswd);
                        break;
                        
                    case 2:
                        servico.newUser(nome, pswd);
                        break;
                        
                    case 3:
                        servico.disconnect(nome);
                }
            }
            
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
