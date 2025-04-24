package solid.lsp.before;

public class BeforeSquare extends BeforeRectangle {
    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    @Override
    public void setHeight(int h) {
        super.setWidth(h);
        super.setHeight(h);
    }
}
