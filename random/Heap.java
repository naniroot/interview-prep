import java.util.List;
import java.util.ArrayList;

class Heap{

    public static void main(String args[]){

        ArrayList<Integer> heap = new ArrayList<Integer>();

        heap.add(10);
        heap.add(30);
        heap.add(3);
        heap.add(300);
        heap.add(400);
        heap.add(-1);
        heap.add(-200);

        printDataStrucute(heap);
        buildMaxHeap(heap);
        printDataStrucute(heap);

    }

    public static void printDataStrucute(ArrayList<Integer> heap){

        int twoPowerIndex = 1;
        for(int i=0; i<heap.size(); i++){
            System.out.print(heap.get(i) + "    ");
            if(i+1 == Math.pow(2,twoPowerIndex)-1){
                System.out.println("");
                twoPowerIndex+=1;
            }
        }
        System.out.println("");
    }

    public static buildMaxHeap(ArrayList<Integer) heap){
        for(int i=Math.floor(heap.size()/2);i==0; i++){
            maxHeapify(heap, i);
        }
    }

    public static maxHeapify(ArrayList<Integer> heap, int pos){

        int largestPos = pos;
        int leftChild = pos*2;
        int rightChild = pos*2+1;

        if(leftChild < heap.size())
    }
}