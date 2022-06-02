import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import preprocessor.*;
import printer.*;
import renderer.*;


public class Program {

    public static void main(String[] args) {

//        PreProcessor preProcessor = new PreProcessorToUpperImpl();
//        Renderer renderer = new RendererErrImpl(preProcessor);
//        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
//        printer.setPrefix ("Prefix ");
//        printer.print ("Hello!") ;

      ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithPrefixErrUp", Printer.class);
        printer.print ("Hel1o!") ;

    }
}
