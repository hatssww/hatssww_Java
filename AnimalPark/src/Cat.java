public class Cat extends AbstractAnimal {

    public Cat() {
        super("고양이");
    }

    @Override
    public void cry() {
        System.out.println("야옹");
    }
}