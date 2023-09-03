/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el m�todo que agrega al principio
        if (!existePaciente(pac.darCodigo())) {
            // Agregar un paciente al principio de la lista
            pacientes.add(0, pac);
        } else {
            // Lanzar una excepci�n o mostrar un mensaje de error, ya que no se pueden tener pacientes con el mismo c�digo
            throw new IllegalArgumentException("Ya existe un paciente con el mismo c�digo.");
        }
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        if (!existePaciente(pac.darCodigo())) {
            // Agregar un paciente al final de la lista
            pacientes.add(pac);
        } else {
            // Lanzar una excepci�n o mostrar un mensaje de error, ya que no se pueden tener pacientes con el mismo c�digo
            throw new IllegalArgumentException("Ya existe un paciente con el mismo c�digo.");
        }
    }
    private boolean existePaciente(int codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new NoExisteException("No existe un paciente con c�digo " + cod);
        } else {
            pacientes.add(indice, pac);
        }
    }


    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        int indice = -1;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            throw new NoExisteException("No existe un paciente con c�digo " + cod);
        } else {
            pacientes.add(indice + 1, pac);
        }
    }

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el m�todo
        for (Paciente paciente : pacientes) {
            if (paciente.darCodigo() == codigo) {
                return paciente;
            }
        }
        return null;
    }


    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
        boolean encontrado = false;
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                pacientes.remove(i);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new NoExisteException("No existe un paciente con c�digo " + cod);
        }
    }


/**
 * Devuelve una lista con los pacientes de la central
 */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int contadorHombres = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.HOMBRE) {
                contadorHombres++;
            }
        }

        return contadorHombres;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int contadorMujeres = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.darSexo() == Paciente.MUJER) {
                contadorMujeres++;
            }
        }

        return contadorMujeres;
    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        // TODO: Completar
        // Inicializar variables para llevar el seguimiento de la cl�nica m�s ocupada
        String clinicaMasOcupada = "";
        int maxPacientes = 0;

        // Iterar a trav�s de las cl�nicas
        for (String clinica : listaClinicas) {
            int pacientesEnClinica = contarPacientesEnClinica(clinica);
            if (pacientesEnClinica > maxPacientes) {
                // Si encontramos una cl�nica con m�s pacientes, actualizamos los valores m�ximos
                maxPacientes = pacientesEnClinica;
                clinicaMasOcupada = clinica;
            }
        }

        return clinicaMasOcupada;
    }
    private int contarPacientesEnClinica(String clinica) {
        int contador = 0;

        for (Paciente paciente : pacientes) {
            if (paciente.darClinica().equals(clinica)) {
                contador++;
            }
        }

        return contador;
    }


}
