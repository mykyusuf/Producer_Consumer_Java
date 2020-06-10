public class Main {

    public static void main(String[] args) {
        if(args.length==1) {
            ProducerConsumer p=new ProducerConsumer(args[0]);
        }
        else
            System.out.println("Enter a image path as an argument!");
    }
}
