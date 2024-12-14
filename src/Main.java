import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------[Bienvenido a Booking Hotel!]---------- \n");
        Scanner scanner = new Scanner(System.in);

        String city, lodgingType, startDay, finalDay;
        int totalAdults, totalKids, totalRooms;

       backToHome: while(true) {
            System.out.println("Ingresa los datos de alojamiento: ");

            System.out.print("Ciudad: ");
            city = scanner.nextLine();

            System.out.print("Tipo de alojamiento (ej. Hotel, Apartamento, Finca, Dia de Sol): ");
            lodgingType = scanner.nextLine();

            System.out.print("Fecha de inicio (formato dd/mm/yyyy): ");
            startDay = scanner.nextLine();

            System.out.print("Fecha de finalización (formato dd/mm/yyyy): ");
            finalDay = scanner.nextLine();

            System.out.print("Número total de adultos: ");
            totalAdults = Integer.parseInt(scanner.nextLine());

            System.out.print("Número total de niños: ");
            totalKids = Integer.parseInt(scanner.nextLine());

            System.out.print("Número total de habitaciones: ");
            totalRooms = Integer.parseInt(scanner.nextLine());

            getReservation(city, lodgingType, startDay, finalDay, totalAdults, totalKids, totalRooms);
        }


    }
    static void generateReservation (String userAnswer){
        System.out.println(userAnswer);
    }

    static void getReservation(String city, String lodgingType, String startDay, String finalDay,
                               int totalAdults, int totalKids, int totalRooms) {
        Scanner scanner = new Scanner(System.in);
        // Arreglos para tipos de alojamiento
        String[] lodgingName = new String[6];
        String[] location = new String[6];
        String[] typeOfLodging = new String[6];
        double[] lodgingRating = new double[6];
        int[] lodgingPricePerNight = new int[6];
        String[][] roomTypes = new String[6][];
        int[][] roomsAvailable = new int[6][];

        // Tipos de habitaciones

        // Habitaciones disponibles

        // Inicializar tipos de alojamiento
        lodgingName[0] = "Hotel Grand Salon";
        location[0] = "Medellin";
        typeOfLodging[0] = "Hotel";
        lodgingRating[0] = 3.4f;
        lodgingPricePerNight[0] = 100;
        roomTypes[0] = new String[] {"Sencilla", "King"};
        roomsAvailable[0] = new int[] {5, 3};

        lodgingName[1] = "Villa San Marcos";
        location[1] = "Medellin";
        typeOfLodging[1] = "Apartamento";
        lodgingRating[1] = 4.3f;
        lodgingPricePerNight[1] = 180;
        roomTypes[1] = new String[] {"Estudio", "Dúplex"};
        roomsAvailable[1] = new int[] {4, 2};

        lodgingName[2] = "Finca el Azul";
        location[2] = "Bogota";
        typeOfLodging[2] = "Finca";
        lodgingRating[2] = 4.4f;
        lodgingPricePerNight[2] = 320;
        roomTypes[2] = new String[] {"Estándar", "Deluxe"};
        roomsAvailable[2] = new int[] {6, 2};

        lodgingName[3] = "Florida Tropical";
        location[3] = "Santa Fe";
        typeOfLodging[3] = "Dia de Sol";
        lodgingRating[3] = 4.0f;
        lodgingPricePerNight[3] = 220;

        lodgingName[4] = "Oasis Tropical";
        location[4] = "Girardota";
        typeOfLodging[4] = "Dia de Sol";
        lodgingRating[4] = 4.2f;
        lodgingPricePerNight[4] = 200;

        lodgingName[5] = "Hotel Globo de oro";
        location[5] = "Medellin";
        typeOfLodging[5] = "Hotel";
        lodgingRating[5] = 3.4f;
        lodgingPricePerNight[5] = 100;
        roomTypes[5] = new String[] {"Sencilla"};
        roomsAvailable[5] = new int[] {5, 3};


        boolean found = false;
        // Buscar tipo de alojamiento coincidente

        for (int i = 0; i < typeOfLodging.length; i++) {
            if(typeOfLodging[i].equalsIgnoreCase(lodgingType) && location[i].equalsIgnoreCase(city)) {
                System.out.println("-----[ Alojamiento disponible en " + city + "]-----");
                System.out.println("Tipo de Alojamiento: " + typeOfLodging[i]);
                System.out.println("Ciudad: " + city);
                System.out.println("Rating: " + lodgingRating[i]);
                System.out.println("Precio por Noche: $" + lodgingPricePerNight[i]);
                System.out.println("-----");
                found = true;
            }

        }
        System.out.println("Deseas hacer la reservacion en alguno de estos lugares?");
            String userAnswer = scanner.nextLine().toLowerCase();
            if (userAnswer.equals("si")) {
                generateReservation(userAnswer);
            }else{
                System.out.println("Volviendo al inicio");
                backToHome: return;
            }

        if (!found) {
            System.out.println("No se encontraron alojamientos que coincidan con los criterios.");
        }
    }
}



