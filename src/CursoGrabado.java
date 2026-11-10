public class CursoGrabado extends Curso {

    private String plataformaAlojamiento;
    private String fechaLimiteAcceso;
    private boolean plataformaDisponible;

    public CursoGrabado(String nombreCurso, int horasTotales,
                        double precioBase, String plataformaAlojamiento,
                        String fechaLimiteAcceso,
                        boolean plataformaDisponible) {

        super(nombreCurso, horasTotales, precioBase);

        this.plataformaAlojamiento = plataformaAlojamiento;
        this.fechaLimiteAcceso = fechaLimiteAcceso;
        this.plataformaDisponible = plataformaDisponible;
    }

    @Override
    public boolean inscribirAlumno(String nombreAlumno) {

        if (plataformaDisponible) {

            alumnosInscritos++;

            System.out.println(nombreAlumno
                    + " se inscribio al curso grabado.");

            return true;

        } else {

            System.out.println("No se puede inscribir: plataforma no disponible.");

            return false;
        }
    }

    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Plataforma: " + plataformaAlojamiento);
        System.out.println("Fecha limite de acceso: " + fechaLimiteAcceso);
        System.out.println("Plataforma disponible: " + plataformaDisponible);
    }
}
