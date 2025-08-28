public class Can <T> {
    private T product;

    public Can(T product){
        this.product = product;
    }

    @Override
    public String toString() {
        return "Can{" +
                "product=" + product +
                '}';
    }
}
