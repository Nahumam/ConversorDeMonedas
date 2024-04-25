import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        int opcion = 0;
        while (opcion != 7){
            System.out.println("************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Monedas =)");
            System.out.println("\n");
            System.out.println("""
                1) Dólar ==> Peso Argentino
                2) Peso Argentino ==> Dólar
                3) Dólar ==> Real Brasilero
                4) Real Brasilero ==> Dólar
                5) Dólar ==> Euro
                6) Euro ==> Dólar
                7) Salir
                """);
            System.out.println("Eliga una opción válida:");

            try {
                opcion = lectura.nextInt();
                switch (opcion){
                    case 1:
                        ExchangeRate monedaIngersada = consulta.moneda("USD");
                        Double valor = monedaIngersada.getConversion_rates().get("ARS");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        Double valorAConvertir = lectura.nextDouble();
                        Double total = valorAConvertir*valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" ARS");
                        break;
                    case 2:
                        monedaIngersada = consulta.moneda("ARS");
                        valor = monedaIngersada.getConversion_rates().get("USD");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        valorAConvertir = lectura.nextDouble();
                        total = valorAConvertir * valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" USD");
                        break;
                    case 3:
                        monedaIngersada = consulta.moneda("USD");
                        valor = monedaIngersada.getConversion_rates().get("BRL");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        valorAConvertir = lectura.nextDouble();
                        total = valorAConvertir*valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" BRL");
                        break;
                    case 4:
                        monedaIngersada = consulta.moneda("BRL");
                        valor = monedaIngersada.getConversion_rates().get("USD");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        valorAConvertir = lectura.nextDouble();
                        total = valorAConvertir*valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" USD");
                        break;
                    case 5:
                        monedaIngersada = consulta.moneda("USD");
                        valor = monedaIngersada.getConversion_rates().get("EUR");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        valorAConvertir = lectura.nextDouble();
                        total = valorAConvertir*valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" EUR");
                        break;
                    case 6:
                        monedaIngersada = consulta.moneda("EUR");
                        valor = monedaIngersada.getConversion_rates().get("USD");
                        System.out.println("-----------------------");
                        System.out.println("Ingrese el valor que desea convertir:");
                        valorAConvertir = lectura.nextDouble();
                        total = valorAConvertir*valor;
                        System.out.println("El valor "+valorAConvertir+" "+ monedaIngersada.getBase_code()+
                                " corresponde al valor final de ==> "+total+" USD");
                        break;
                    default:
                        if (opcion == 7){
                            System.out.println("Gracias por usar nuestra aplicación, vuelva pronto!");
                        } else {
                            System.out.println("El número ingresado es incorrecto");
                        }
                }
            } catch (NumberFormatException e) {
                System.out.println("Número no encontrado "+e.getMessage());
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación");
            }
        }
    }
}
