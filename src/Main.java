import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------[Bienvenido a Booking Hotel!]---------- \n");
        Scanner scanner = new Scanner(System.in);

        String city, lodgingType;
        int totalAdults, totalKids, totalRooms, startDay, finalDay;

        while(true) {

            System.out.println("Ciudades Disponibles:");
            System.out.println("Ingresa los datos de alojamiento: ");

            System.out.print("Ciudad: ");
            city = scanner.nextLine();

            System.out.print("Tipo de alojamiento (ej. Hotel, Apartamento, Finca, Dia de Sol): ");
            lodgingType = scanner.nextLine();

            System.out.print("Dia de Inicio: ");
            startDay = Integer.parseInt(scanner.nextLine());

            System.out.print("Dia de Final: ");
            finalDay = Integer.parseInt(scanner.nextLine());

            System.out.print("Número total de adultos: ");
            totalAdults = Integer.parseInt(scanner.nextLine());

            System.out.print("Número total de niños: ");
            totalKids = Integer.parseInt(scanner.nextLine());

            System.out.print("Número total de habitaciones: ");
            totalRooms = Integer.parseInt(scanner.nextLine());

            getReservation(city, lodgingType, startDay, finalDay, totalAdults, totalKids, totalRooms);
        }
    }

// Segundo punto - Reciba los datos del alojamiento donde se va a hacer la reserva
    static void getAvaliableRooms(String selectedLodging, int startDay, int finalDay,
                                  int totalAdults, int totalKids, int totalRooms, String[][] roomDescriptions, int hotelId, int[] avaliableRooms, double finalPrice) {


        if (totalRooms > avaliableRooms[hotelId]){
            System.out.println("No hay habitaciones disponibles");
        }else{

        System.out.println("Detalles de la reserva:");
        System.out.println("Alojamiento seleccionado: " + selectedLodging);
        System.out.println("Dia de inicio: " + startDay);
        System.out.println("Dia final: " + finalDay);
        System.out.println("Total de adultos: " + totalAdults);
        System.out.println("Total de niños: " + totalKids);
        System.out.println("Total de habitaciones: " + totalRooms);

        System.out.println("Habitaciones disponibles:" + avaliableRooms[hotelId] + "\n -----------------------------");

        for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
            System.out.println((i + 1) + ". " + roomDescriptions[hotelId][i]);  // Mostrar la opción numerada
        }
        System.out.println("+-----------------------------+");
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona una opción para el " + selectedLodging + ":");
        int selectedLodgingRoom = scanner.nextInt();

        if (selectedLodgingRoom >= 1 && selectedLodgingRoom <= roomDescriptions[hotelId].length) {
            System.out.println("\nHas elegido la habitación número " + selectedLodgingRoom + ":");
            System.out.println(roomDescriptions[hotelId][selectedLodgingRoom - 1]);  // Mostrar solo la habitación seleccionada
        } else {
            System.out.println("La habitación que has elegido no está disponible.");
        }


    }


// Primer Punto - Metodo que reciba los parametros
    static void getReservation(String city, String lodgingType, int startDay, int finalDay,
                               int totalAdults, int totalKids, int totalRooms ) {
        Scanner scanner = new Scanner(System.in);

        // Datos de alojamientos
        String[] names = {
                "Hotel Grand Salon", "Villa San Marcos", "Finca el Azul",
                "Florida Tropical", "Oasis Tropical", "Hotel Globo de oro"
        };
        String[] locations = {
                "Medellin", "Medellin", "Bogota",
                "Santa Fe", "Girardota", "Medellin"
        };
        String[] types = {
                "Hotel", "Apartamento", "Finca",
                "Dia de Sol", "Dia de Sol", "Hotel"
        };
        double[] ratings = {
                3.4, 4.3, 4.4,
                4.0, 4.2, 3.4
        };
        int[] prices = {
                125, 180, 320,
                115, 120, 100
        };
        int[] avaliableRooms = {
                2, 1, 1,
                1, 1, 2
        };

        String[][] roomDescriptions = {
                // Para Hotel Grand Salon
                {"- Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio.\n Precio: $100 por noche",
                        " - Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha.\n Precio: $100 por noche"},

                // Para Villa San Marcos
                {" - Habitación familiar con 2 camas matrimoniales, terraza privada, cocina pequeña, baño completo, vista al jardín. Precio: $180 por noche",
                        " - Habitación King con 3 camas, dos matrimoniales y una individual, terraza privada, cocina pequeña, baño completo, vista al jardín, Jacuzzi. Precio: $280 por noche"},

                // Para Finca el Azul
                {" - Habitación rústica con 2 camas individuales, ventanas amplias, baño privado, vista a los campos, decoración tradicional. Precio: $320 por noche"},

                // Para Florida Tropical
                {" - Actividades como Mesas de Ping Pong, Piscina, Canchas de Voley, y Futbol, Juegos de mesa. \nIncluye Almuerzo y Refrigerio. Precio: $115 por dia"},

                // Para Oasis Tropical
                {" - Actividades como Botes de remo, Lago, Natación, Juegos de Salón, Pesca, Rutas de Bicicleta, Voleibol.\nIncluye Desayuno, Almuerzo, Refrigerio. Precio: $120 por dia"},

                // Para Hotel Globo de oro
                {" - Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio.\n Precio: $100 por noche",
                        "2 - Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha.\n Precio: $100 por noche"}
        };
        // Bandera para rastrear si se encontró alojamiento
        boolean foundLodging = false;
        //

        double finalPrice = 0;
        int finalPayment = 0;

        // Buscar alojamientos que coincidan
        System.out.println("Alojamientos disponibles:");
        for (int i = 0; i < names.length; i++) {
            // Verificar coincidencia de ciudad y tipo de alojamiento
            if (locations[i].equalsIgnoreCase(city) && types[i].equalsIgnoreCase(lodgingType)) {


                System.out.println("-----[ Alojamiento disponible en " + city + " ]-----");
                System.out.println("| Nombre: " + names[i]);
                System.out.println("| Tipo de Alojamiento: " + types[i]);
                System.out.println("| Ciudad: " + city);
                System.out.println("| Rating: " + ratings[i]);
                System.out.println("| Precio por Estadia: $" + prices[i]);

                // Calcular costo base
                int totalDays = finalDay - startDay;
                if (totalDays <= 0) {
                    System.out.println("Error: La fecha de inicio debe ser anterior a la de finalización.");
                    return;
                }
                int basePrice = prices[i] * totalDays;
                 finalPrice = basePrice;

                // Incrementar 15% si la reserva está en los últimos 5 días del mes
                if (startDay >= 27 && finalDay <= 31) {
                    finalPrice += basePrice * 0.15;
                    System.out.println("| Incremento del 15% por reserva al final del mes.");
                }else if (startDay >= 10 && finalDay <= 15) {
                    finalPrice += basePrice * 0.10;
                    System.out.println("| Incremento del 10% por incluir días del 10 al 15.");
                }else if (startDay >= 5 && finalDay <= 10) {
                    finalPrice -= basePrice * 0.08;
                    System.out.println("| Descuento del 8% por incluir días del 5 al 10.");
                }

                System.out.printf("| Precio final: $%.2f%n", finalPrice);
                System.out.println("-----");
                foundLodging = true;
            }
        }
        // Si no se encontraron alojamientos
        if (!foundLodging) {
            System.out.println("No se encontraron alojamientos que coincidan con los criterios.");
            return;
        }

        // Preguntar sobre reserva
        System.out.println("\n¿Deseas hacer una reservación? (si/no)");
        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("si")) {
            System.out.println("Escribe el nombre exacto del alojamiento:");
            String selectedLodging = scanner.nextLine();

            // Verificar si el alojamiento existe
            boolean validLodging = false;
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(selectedLodging)) {
                    int hotelId = i;
                    getAvaliableRooms(selectedLodging, startDay, finalDay,
                            totalAdults, totalKids, totalRooms, roomDescriptions, hotelId, avaliableRooms, finalPrice);
                             validLodging = true;
                    break;
                }
            }

            if (!validLodging) {
                System.out.println("Alojamiento no válido.");
            }
        } else {
            System.out.println("Volviendo al inicio");
        }
    }
}

