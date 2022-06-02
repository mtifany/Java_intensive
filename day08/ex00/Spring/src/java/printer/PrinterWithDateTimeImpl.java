package printer;

    import renderer.Renderer;

    import java.time.LocalDateTime;

    public class PrinterWithDateTimeImpl implements Printer{
    Renderer renderer;


    public PrinterWithDateTimeImpl(Renderer renderer) {
                this.renderer = renderer;
    }
        public PrinterWithDateTimeImpl() {

        }

    @Override
    public void print(String text) {renderer.print(LocalDateTime.now()+ " " + text);}
}
