package lesson8.HomeWork.Students;

public class Demo {
    /*public static void main(String[] args) {
        //Course(Date startDate, String name, int hoursDuration, String teacherName)
        Calendar c = Calendar.getInstance();

        c.set(2018, 8, 20);
        Date date1 = c.getTime();
        c.set(2018, 8, 20);
        Date date2 = c.getTime();

        Course itTechnologies = new Course(date1, "IT", 3600, "Sidorov N.I.");
        Course mathematics = new Course(date2, "Math", 7200, "Petrov D.A.");
        Course japanLanguage = new Course(date1, "Japan", 24000, "Toshiro Namazuki");
        Course embroidery = new Course(date2, "Emb", 600, "Baba Katya");

        Student student1 = CreateHighestParent("Ivan", "Ivanoff", 403, new Course[]{itTechnologies, mathematics});
        SpecialStudent student2 = CreateLowestChild("Yokika", "Madako", 403, new Course[]{japanLanguage, embroidery}, 123761587542l, "Yokika@gmail.com");
    }*/

    //static Student CreateHighestParent(String firstName, String lastName, int group, Course[] coursesTaken) {
    static Student createHighestParent() {
        return new Student("", "", 333, new Course[]{});
    }

    //static SpecialStudent CreateLowestChild(String firstName, String lastName, int group, Course[] coursesTaken, long secretKey, String email) {
    static SpecialStudent createLowestChild() {
        return new SpecialStudent("", "", 333, new Course[]{}, 654564l, "");
    }
}
