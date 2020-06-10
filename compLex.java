import java.util.Comparator;

public class compLex implements Comparator<colorRGB> {

    @Override
    public int compare(colorRGB o1, colorRGB o2) {

        if(o1.getRed()>o2.getRed()){
            return 1;
        }
        else if(o1.getRed()<o2.getRed()){
            return -1;
        }
        else if(o1.getGreen()>o2.getGreen()){
            return 1;
        }
        else if(o1.getGreen()<o2.getGreen()){
            return -1;
        }
        else if(o1.getBlue()>o2.getBlue()){
            return 1;
        }
        else if(o1.getBlue()<o2.getBlue()){
            return -1;
        }
        return 0;
    }
}
