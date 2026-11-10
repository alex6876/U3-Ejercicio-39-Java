public class Main {

    public static void main(String[] args) {

        CursoGrabado grabado = new CursoGrabado(
                "Java desde cero",
                40,
                50000,
                "Udemy",
                "31/12/2026",
                true
        );

        MentoriaEnVivo mentoria = new MentoriaEnVivo(
                "Programacion orientada a objetos",
                20,
                80000,
                "https://meet.google.com/ejemplo",
                2,
                true
        );

        TallerPresencial taller = new TallerPresencial(
                "Desarrollo de aplicaciones",
                15,
                60000,
                5,
                "Av. San Martin 1500, Mendoza",
                2
        );

        Curso[] cursos = {
                grabado,
                mentoria,
                taller
        };

        System.out.println("===== INSCRIPCIONES DE ALUMNOS =====");

        grabado.inscribirAlumno("Carlos");
        grabado.inscribirAlumno("Lucia");

        System.out.println();

        mentoria.inscribirAlumno("Pedro");
        mentoria.inscribirAlumno("Maria");
        mentoria.inscribirAlumno("Juan");

        System.out.println();

        taller.inscribirAlumno("Sofia");
        taller.inscribirAlumno("Diego");
        taller.inscribirAlumno("Ana");

        System.out.println("\n===== OFERTA ACADEMICA =====");

        for (Curso curso : cursos) {

            System.out.println("\n------------------------------");

            curso.mostrarInformacion();

            System.out.println("Costo final con 10% de descuento: $"
                    + curso.calcularCostoFinal(10));
        }
    }
}