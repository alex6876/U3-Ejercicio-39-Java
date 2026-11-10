public class MentoriaEnVivo extends Curso {

    private String enlaceVideollamada;
    private int cupoMaximo;
    private boolean conectividadDisponible;

    public MentoriaEnVivo(String nombreCurso, int horasTotales,
                          double precioBase, String enlaceVideollamada,
                          int cupoMaximo, boolean conectividadDisponible) {

        super(nombreCurso, horasTotales, precioBase);

        this.enlaceVideollamada = enlaceVideollamada;
        this.cupoMaximo = cupoMaximo;
        this.conectividadDisponible = conectividadDisponible;
    }

    @Override
    public boolean inscribirAlumno(String nombreAlumno) {

        if (!conectividadDisponible) {

            System.out.println("Inscripcion rechazada: no hay conectividad.");

            return false;
        }

        if (alumnosInscritos >= cupoMaximo) {

            System.out.println("Inscripcion rechazada: cupo completo.");

            return false;
        }

        alumnosInscritos++;

        System.out.println(nombreAlumno
                + " se inscribio a la mentoria en vivo.");

        return true;
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Enlace de videollamada: " + enlaceVideollamada);
        System.out.println("Cupo maximo: " + cupoMaximo);
        System.out.println("Conectividad disponible: " + conectividadDisponible);
    }
}
