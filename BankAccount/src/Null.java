public class Null {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("김신의", 28);
        people[2] = new Person("문종모", 26);
        people[3] = new Person("서혜린", 21);

        for (int i = 0; i < people.length; i++) {
            Person p = people[i];
            if (p != null) {
                System.out.println(p.getName());
            } else {
                System.out.println(i + "번 자리는 비었습니다.");
            }
        }
    }
}
