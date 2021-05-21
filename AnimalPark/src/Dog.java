public class Dog extends AbstractAnimal{
    public Dog() {
        super("강아지");
    }

    @Override
    public void cry() {
        System.out.println("왈왈");
    }
}