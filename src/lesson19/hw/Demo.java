package lesson19.hw;

public class Demo {
    public static void main(String[] args) {

        //error
        try {
            File file1 = new File(123, "asdkajsldkajslkdja", "txt", 500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Controller controller = new Controller();

        Storage officeStorage = new Storage(111, new String[] {"docx", "xlsx", "pptx"}, "Ukraine", 5000);
        Storage imageStorage = new Storage(222, new String[] {"jpg", "gif", "png"}, "USA", 15000);
        Storage dbStorage = new Storage(333, new String[] {"mdb", "mdf", "sdf"}, "U.K.", 25000);

        try {
            File file1 = new File(123, "f1", "xlsx", 500);
            File file2 = new File(234, "f2", "docx", 600);
            File file3 = new File(345, "f3", "pptx", 700);

            File file4 = new File(456, "f4", "jpg", 800);
            File file5 = new File(567, "f5", "gif", 900);
            File file6 = new File(678, "f6", "png", 1100);

            File file7 = new File(789, "f7", "mdb", 9200);
            File file8 = new File(890, "f8", "mdf", 7500);
            File file9 = new File(901, "f9", "sdf", 4500);

            File file99 = new File(999, "f9", "sdf", 1);


            controller.put(officeStorage, file1);
            controller.put(officeStorage, file2);
            controller.put(officeStorage, file3);

            controller.put(imageStorage, file4);
            controller.put(imageStorage, file5);
            controller.put(imageStorage, file6);

            controller.put(dbStorage, file7);
            controller.put(dbStorage, file8);
            controller.put(dbStorage, file9);

            controller.put(dbStorage, file99);

            System.out.println(officeStorage);
            System.out.println(imageStorage);
            System.out.println(dbStorage);


            //errors
            try {
                controller.transferAll(dbStorage, officeStorage);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                controller.transferFile(dbStorage, officeStorage, 555);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                controller.put(imageStorage, new File(987, "f555", "png", 54500));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
