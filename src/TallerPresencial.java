public class TallerPresencial extends Curso {

    private int numeroAula;
    private String direccionFisica;
    private int capacidadAula;

    public TallerPresencial(String nombreCurso, int horasTotales,
                            double precioBase, int numeroAula,
                            String direccionFisica, int capacidadAula) {

        super(nombreCurso, horasTotales, precioBase);

        this.numeroAula = numeroAula;
        this.direccionFisica = direccionFisica;
        this.capacidadAula = capacidadAula;
    }

    @Override
    public boolean inscribirAlumno(String nombreAlumno) {

        if (alumnosInscritos >= capacidadAula) {

            System.out.println("Inscripcion rechazada: aula sin lugares disponibles.");

            return false;
        }

        alumnosInscritos++;

        System.out.println(nombreAlumno
                + " se inscribio al taller presencial.");

        return true;
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Numero de aula: " + numeroAula);
        System.out.println("Direccion: " + direccionFisica);
        System.out.println("Capacidad del aula: " + capacidadAula);
    }
}
