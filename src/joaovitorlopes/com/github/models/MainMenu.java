package joaovitorlopes.com.github.models;

import java.net.ConnectException;
import java.util.Scanner;

public class MainMenu {
    public MainMenu() {
        Scanner reading = new Scanner(System.in);
        int mainMenuOption;

        Converter converter = new Converter();

        try {
            String mainMenu = """
                     ********************MENU********************
                     1\t Dólar (USD)\t\t ==>\t Peso argentino (ARS)");
                     2\t Peso argentino (ARS)\t\t ==>\t Dólar (USD)");
                     3\t Dólar (USD)\t\t ==>\t Real brasileiro (BRL)");
                     4\t Real brasileiro (BRL) ==>\t Dólar (USD)");
                     5\t Dólar (USD) ==>\t Peso colombiano (COP)");
                     6\t Peso colombiano (COP) ==>\t Dólar (USD)");
                     7\t Sair");
                     ********************************************
                     - Escolha uma opção válida:
                    """;

            System.out.println(mainMenu);

            do {
                mainMenuOption = reading.nextInt();

                switch (mainMenuOption) {

                    case 1:
                        System.out.println("Enter a value to convert:");
                        double conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        String result = converter.toConversion("USD", "ARS", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 2:
                        System.out.println("Enter a value to convert:");
                        conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        result = converter.toConversion("ARS", "USD", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 3:
                        System.out.println("Enter a value to convert:");
                        conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        result = converter.toConversion("USD", "BRL", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 4:
                        System.out.println("Enter a value to convert:");
                        conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        result = converter.toConversion("BRL", "USD", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 5:
                        System.out.println("Enter a value to convert:");
                        conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        result = converter.toConversion("USD", "COP", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 6:
                        System.out.println("Enter a value to convert:");
                        conversionValue = reading.nextInt();
                        System.out.println("Performing conversion...");
                        result = converter.toConversion("COP", "USD", conversionValue);
                        System.out.println(result);

                        new MainMenu();
                        break;
                    case 7:
                        System.out.println("Application Finished!");
                        break;
                    default:
                        System.out.println("Invalid entry!");
                        break;
                }
            } while (mainMenuOption != 7) ;
            reading.close();
        } catch (RuntimeException e) {
            System.err.println("Error to acess API: " + e.getMessage());
        } catch (ConnectException e) {
            throw new RuntimeException(e);
        }
    }
}
