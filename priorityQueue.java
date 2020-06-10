import java.util.Comparator;

public class priorityQueue {

    private colorRGB data[];
    Comparator<colorRGB> comporator=null;
    int size;

    public priorityQueue(Comparator<colorRGB> cmp) {
        data=new colorRGB[100];
        comporator=cmp;
        size=0;
    }

    public boolean offer(colorRGB item){
        data[size]=item;
        size++;
        int child = size-1;
        int parent = (child -1) / 2;
        colorRGB temp;
        while (parent >= 0 && compare(data[parent],data[child])<0 ) {
            temp=data[parent];
            data[parent]=data[child];
            data[child]=temp;
            child=parent;
            parent = (child-1)/2;
        }

        return true;
    }
    public colorRGB poll(){


        colorRGB tmp=data[0];
        priorityQueue p=new priorityQueue(comporator);
        for(int i=1;i<size;i++){
            p.offer(data[i]);
        }
        this.data=p.data;
        size--;

        return tmp;
    }

    private int compare(colorRGB x, colorRGB y){

        return comporator.compare(x,y);

    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(data[i].getBlue());

        }
    }

}
