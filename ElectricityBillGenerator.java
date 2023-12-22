import java.util.Scanner;

public class ElectricityBillGenerator {
    private int consumerNo;
    private String consumerName;
    private double previousMonthReading;
    private double currentMonthReading;
    private String ebConnectionType;

    public void inputDetails() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Consumer No.: ");
        consumerNo = input.nextInt();

        System.out.print("Enter Consumer Name: ");
        input.nextLine(); // Consume the newline character
        consumerName = input.nextLine();

        System.out.print("Enter Previous Month Reading: ");
        previousMonthReading = input.nextDouble();

        System.out.print("Enter Current Month Reading: ");
        currentMonthReading = input.nextDouble();

        System.out.print("Enter EB Connection Type (domestic/commercial): ");
        ebConnectionType = input.next();

        input.close();
    }

    public double calculateBillAmount() {
        double unitsConsumed = currentMonthReading - previousMonthReading;
        double billAmount = 0.0;

        if (ebConnectionType.equalsIgnoreCase("domestic")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 1.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 1.0 + (unitsConsumed - 100) * 2.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 1.0 + 100 * 2.5 + (unitsConsumed - 200) * 4.0;
            } else {
                billAmount = 100 * 1.0 + 100 * 2.5 + 300 * 4.0 + (unitsConsumed - 500) * 6.0;
            }
        } else if (ebConnectionType.equalsIgnoreCase("commercial")) {
            if (unitsConsumed <= 100) {
                billAmount = unitsConsumed * 2.0;
            } else if (unitsConsumed <= 200) {
                billAmount = 100 * 2.0 + (unitsConsumed - 100) * 4.5;
            } else if (unitsConsumed <= 500) {
                billAmount = 100 * 2.0 + 100 * 4.5 + (unitsConsumed - 200) * 6.0;
            } else {
                billAmount = 100 * 2.0 + 100 * 4.5 + 300 * 6.0 + (unitsConsumed - 500) * 7.0;
            }
        }

        return billAmount;
    }

    public void printBill() {
        System.out.println("\nElectricity Bill");
        System.out.println("<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<");
        System.out.println("Consumer No.: " + consumerNo);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Month Reading: " + previousMonthReading);
        System.out.println("Current Month Reading: " + currentMonthReading);
        System.out.println("EB Connection Type: " + ebConnectionType);
        System.out.println("Bill Amount: Rs. " + calculateBillAmount());
		System.out.println("<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<<-<");
    }

    public static void main(String[] args) {
        ElectricityBillGenerator billGenerator = new ElectricityBillGenerator();
        billGenerator.inputDetails();
        billGenerator.printBill();
    }
}