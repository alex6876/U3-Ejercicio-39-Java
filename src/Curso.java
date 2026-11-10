public class Curso {

    protected String nombreCurso;
    protected int horasTotales;
    protected double precioBase;
    protected int alumnosInscritos;

    public Curso(String nombreCurso, int horasTotales, double precioBase) {

        this.nombreCurso = nombreCurso;
        this.horasTotales = horasTotales;
        this.precioBase = precioBase;
        this.alumnosInscritos = 0;
    }

    public double calcularCostoFinal(double descuento) {

        if (descuento < 0 || descuento > 100) {
            return precioBase;
        }

        return precioBase - (precioBase * descuento / 100);
    }

    public boolean inscribirAlumno(String nombreAlumno) {

        alumnosInscritos++;

        System.out.println(nombreAlumno + " se inscribio correctamente.");

        return true;
    }

    public void mostrarInformacion() {

        System.out.println("Curso: " + nombreCurso);
        System.out.println("Horas totales: " + horasTotales);
        System.out.println("Precio base: $" + precioBase);
        System.out.println("Alumnos inscritos: " + alumnosInscritos);
    }
}