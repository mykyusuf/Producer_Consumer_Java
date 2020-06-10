import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Comparator;

public class ProducerConsumer {

    static procuder p = new procuder();
    static consumer1 c = new consumer1();
    static consumer2 c2 = new consumer2();
    static consumer3 c3 = new consumer3();

    public static int width;
    public static int height;
    public static BufferedImage image;
    static monitor m = new monitor(new compLex());
    static monitor m2 = new monitor(new compEuc());
    static monitor m3 = new monitor(new compBmx());

    public ProducerConsumer(String s){
        try {

            File input = new File(s);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

        }
        catch (IOException e){

        };

        p.start();
        c.start();
        c2.start();
        c3.start();
    }

    static class procuder extends Thread {

        int f=0;
        public void run() {

                for(int i=0; i<height; i++) {

                    for(int j=0; j<width; j++) {

                        Color c = new Color(image.getRGB(j, i));
                        colorRGB r=new colorRGB();
                        r.setColors(c.getRed(),c.getGreen(),c.getBlue());
                        m.insert(r);
                        m2.insert(r);
                        m3.insert(r);
                        f++;


                    }
                }


        }


    }
    static class consumer3 extends Thread {
        int count=0;

        public void run(){
            while(count<(width*height)){
                colorRGB it=m3.remove();
                System.out.println("Thread4: ["+it.getRed()+","+it.getGreen()+","+it.getBlue()+"]");
                count++;
            }
        }


    }
    static class consumer2 extends Thread {
        int count=0;

        public void run(){
            while(count<(width*height)){
                colorRGB it=m2.remove();
                System.out.println("Thread3: ["+it.getRed()+","+it.getGreen()+","+it.getBlue()+"]");
                count++;
            }
        }


    }

    static class consumer1 extends Thread {
        int count=0;

        public void run(){
            while(count<(width*height)){
                colorRGB it=m.remove();
                System.out.println("Thread2: ["+it.getRed()+","+it.getGreen()+","+it.getBlue()+"]");
                count++;
            }
        }


    }

    static class monitor {

        private int counter;

        private priorityQueue q;

        public monitor(Comparator<colorRGB> cmp){
            q=new priorityQueue(cmp);
            counter=0;
        }

        public synchronized void insert(colorRGB c) {
            if(counter==100)
                uyu();
                q.offer(c);
                counter++;
                System.out.println("Thread1: ["+c.getRed()+","+c.getGreen()+","+c.getBlue()+"]");

            if (counter==1)
                notify();

        }

        public synchronized colorRGB remove() {
            colorRGB item = null;
            if (counter==0)
                uyu();

            item=q.poll();

            counter--;
            if (counter>0)
                notify();

            return item;
        }



        private void uyu(){
            try {
                wait();
            }
            catch (InterruptedException e){

            };
        }

    }





}
