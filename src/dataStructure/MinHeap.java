package dataStructure;

import java.io.*;

class MinHeapImpl{
    int[] heap;
    int size = 0;
    BufferedWriter bw;

    public MinHeapImpl(int n, BufferedWriter bw) {
        this.heap = new int[n+1];
        heap[0] = -1;
        this.bw = bw;
    }
    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public void putX(int putValue) throws IOException {
        if(size == 0){
            size ++;
            heap[1] = putValue;
        }else{
            int putIndex = size+1;
            while(putIndex >= 1){
                int parentValue = heap[putIndex / 2];
                if(putValue < parentValue){
                    heap[putIndex] = parentValue;
                    putIndex /= 2;
                }else{
                    heap[putIndex] = putValue;
                    break;
                }
            }
            size++;
        }
    }
    public void print() throws IOException {
        if(size == 0){
            bw.write(0 + "\n");
        }else{
            bw.write(heap[1] + "\n");
            int lastValue = heap[size];
            size--;
            heap[1] = lastValue;
            int lastIndex = 1;
            while(lastIndex <= size){

                if(lastIndex * 2 + 1 <= size){
                    //비교후 더 작은것과 스왑
                    int swapIndex = heap[lastIndex * 2] < heap[lastIndex * 2 + 1] ?
                            lastIndex * 2 : lastIndex * 2 + 1;
                    if(lastValue > heap[swapIndex]) {
                        swap(heap, lastIndex, swapIndex);
                        lastIndex = swapIndex;
                    }else{
                        break;
                    }
                }else if(lastIndex * 2 == size){
                    //왼쪽과 스왑
                    if(lastValue > heap[lastIndex * 2]) {
                        swap(heap, lastIndex, lastIndex * 2);
                        lastIndex = lastIndex * 2;
                    }else{
                        break;
                    }
                }else{
                    // 마무리
                    break;
                }
            }
        }
    }
}

// 1927
public class MinHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MinHeapImpl minHeap = new MinHeapImpl(n, bw);

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                minHeap.print();
            } else {
                minHeap.putX(value);
            }
        }
        bw.flush();
        bw.close();

    }
}
