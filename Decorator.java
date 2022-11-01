import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 interface Greeter {
    String getMessageOfTheDay();
}
 class BasicGreeter implements Greeter {
     private final String name;
     BasicGreeter(final String name){
         this.name = name;
     }
    @Override
    public String getMessageOfTheDay() {
        return name;
    }

}
 abstract class GreeterDecorator implements Greeter {

     protected Greeter greeter;

     public GreeterDecorator(Greeter greeter) {
         this.greeter = greeter;
     }

     public String getMessageOfTheDay() {
         return greeter.getMessageOfTheDay();
     }

 }
 class StrangerDecorator extends GreeterDecorator {

     public StrangerDecorator(Greeter greeter) {
         super(greeter);
     }

     @Override
     public String getMessageOfTheDay() {
         return "Hello " + super.getMessageOfTheDay();
     }

 }
 class DecoratorDemo {

     public static void main(String[] args) throws IOException {

         File file = new File("C:\\Users\\Pavilion\\IdeaProjects\\Decorator\\.idea\\out");
         file.createNewFile();
         OutputStream oStream = new FileOutputStream(file);
         Greeter greeter = new BasicGreeter("John");

         Greeter muchNewGreeter = new StrangerDecorator(new StrangerDecorator(greeter));

         String newestMotd = muchNewGreeter.getMessageOfTheDay();

         oStream.write(newestMotd.getBytes());
         oStream.close();
     }

 }
