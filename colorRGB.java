public class colorRGB {
    private int red;
    private int green;
    private int blue;

    public colorRGB(){
        red=0;
        green=0;
        blue=0;
    }
    public void setColors(int x,int y,int z){
        red=x;
        green=y;
        blue=z;
    }
    public int getRed(){
        return red;
    }
    public int getBlue(){
        return blue;
    }
    public int getGreen(){
        return green;
    }
}
