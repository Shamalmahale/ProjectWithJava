import java.util.Scanner;

public class TemperatureConverter {

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    // Convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");

        while (true) {
            System.out.print("Enter the temperature value (or type 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            double temperature;
            try {
                temperature = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid temperature value. Please enter a valid number.");
                continue;
            }

            System.out.print("Enter the source scale (Celsius, Fahrenheit, Kelvin): ");
            String sourceScale = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter the target scale (Celsius, Fahrenheit, Kelvin): ");
            String targetScale = scanner.nextLine().trim().toLowerCase();

            double convertedTemperature = 0;
            boolean validConversion = true;

            switch (sourceScale) {
                case "celsius":
                    if (targetScale.equals("fahrenheit")) {
                        convertedTemperature = celsiusToFahrenheit(temperature);
                    } else if (targetScale.equals("kelvin")) {
                        convertedTemperature = celsiusToKelvin(temperature);
                    } else if (targetScale.equals("celsius")) {
                        convertedTemperature = temperature;
                    } else {
                        validConversion = false;
                    }
                    break;

                case "fahrenheit":
                    if (targetScale.equals("celsius")) {
                        convertedTemperature = fahrenheitToCelsius(temperature);
                    } else if (targetScale.equals("kelvin")) {
                        convertedTemperature = fahrenheitToKelvin(temperature);
                    } else if (targetScale.equals("fahrenheit")) {
                        convertedTemperature = temperature;
                    } else {
                        validConversion = false;
                    }
                    break;

                case "kelvin":
                    if (targetScale.equals("celsius")) {
                        convertedTemperature = kelvinToCelsius(temperature);
                    } else if (targetScale.equals("fahrenheit")) {
                        convertedTemperature = kelvinToFahrenheit(temperature);
                    } else if (targetScale.equals("kelvin")) {
                        convertedTemperature = temperature;
                    } else {
                        validConversion = false;
                    }
                    break;

                default:
                    validConversion = false;
                    break;
            }

            if (validConversion) {
                System.out.printf("Converted temperature: %.2f %s%n", convertedTemperature, targetScale);
            } else {
                System.out.println("Invalid source or target scale. Please enter Celsius, Fahrenheit, or Kelvin.");
            }
        }

        scanner.close();
    }
}
