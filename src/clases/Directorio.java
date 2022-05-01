package clases;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Directorio {

    private final HashMap<Long, Cliente> Directorio;

    public Directorio() {
        Directorio = new HashMap<>();
    }



    public boolean agregarCliente(long p_numTelefono, Cliente p_cliente) {
           if (!Directorio.containsKey(p_numTelefono)) {
            Directorio.put(p_numTelefono, p_cliente);
            return true;           
        }        
        return false;
    }

    public Cliente buscarCliente(long p_telefono) {
        return Directorio.get(p_telefono);
    }

    public Set<Long> buscarTelefono(String p_apellido) {

        Set<Long> telefonos = new HashSet<>();

        for (Long telefono : Directorio.keySet()) {

            if (Directorio.get(telefono).getApellido().equals(p_apellido)) {
                telefonos.add(telefono);
            }
        }

        return telefonos;
    }


    public Set<Cliente> buscarClientes(String p_ciudad) {

        Set<Cliente> clientes = new HashSet<>();

        for (Cliente cliente : Directorio.values()) {
            if (cliente.getCiudad().equals(p_ciudad)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }


    public boolean borrarCliente(long p_numTelefono) {
        /* if existe el telefono en el directorio */
        if (Directorio.containsKey(p_numTelefono)) {
            Directorio.remove(p_numTelefono);
            return true;
        }
        return false;
    }
}
