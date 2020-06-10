import java.util.Comparator;

public class compEuc implements Comparator<colorRGB> {

    @Override
    public int compare(colorRGB o1, colorRGB o2) {

        if( ( o1.getRed()*o1.getRed() + o1.getGreen()*o1.getGreen() + o1.getBlue()*o1.getBlue() ) >  ( o2.getRed()*o2.getRed() + o2.getGreen()*o2.getGreen() + o2.getBlue()*o2.getBlue() ))  {
            return 1;
        }
        else if( ( o1.getRed()*o1.getRed() + o1.getGreen()*o1.getGreen() + o1.getBlue()*o1.getBlue() ) <  ( o2.getRed()*o2.getRed() + o2.getGreen()*o2.getGreen() + o2.getBlue()*o2.getBlue() ))  {
            return -1;
        }
        else
            return 0;
    }
}
