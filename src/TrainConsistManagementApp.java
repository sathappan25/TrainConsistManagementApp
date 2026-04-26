public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("====================================");
        System.out.println();

        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");
        System.out.println();

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Petroleum");
        System.out.println();

        System.out.println("UC15 runtime handling completed...");
    }
}         