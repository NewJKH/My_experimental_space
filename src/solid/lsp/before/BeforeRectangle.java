package solid.lsp.before;

public class BeforeRectangle {
    private int width;
    private int height;

    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }

    public int getArea() {
        return width * height;
    }
}
