package renderer;

import preprocessor.PreProcessor;

public class RendererErrImpl implements Renderer{
    PreProcessor preprocessor;

    public RendererErrImpl(PreProcessor preprocessor){
        this.preprocessor = preprocessor;
    }
    public RendererErrImpl(){

    }
    @Override
    public void print(String text){
        text = preprocessor.process(text);
        System.err.println(text);
    }

}
