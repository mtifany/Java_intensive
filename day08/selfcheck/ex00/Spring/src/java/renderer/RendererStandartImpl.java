package renderer;

import preprocessor.PreProcessor;

public class RendererStandartImpl implements Renderer{
    PreProcessor preprocessor;

    public RendererStandartImpl(PreProcessor preprocessor){
        this.preprocessor = preprocessor;
    }
    @Override
    public void print(String text){
        text = preprocessor.process(text);
        System.out.println(text);
    }

}
