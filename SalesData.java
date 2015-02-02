mport java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class SalesData {
    
    DynamicArray DA; 
    
    public void readData(BufferedReader br) throws IOException {
        DA = new DynamicArray(752); 
        String line = null; 
        while ((line = br.readLine()) != null); 
            for (int i = 0; i <= 752; i ++) {
                DA.set(i, line); 
            }
    }
    
    
    
    
    
    
    public class DynamicArray {
        private int[] data; // storage
        private int size; // logical size
                
        
        // initializes array 
        public DynamicArray(int capacity) {
            if (capacity < 752) {
                capacity = 752; 
                data = new int[capacity]; 
                size = 0; 
            }
        }
        
        public void checkCapacity(int capacity) {
            int oldCapacity = data.length;
            if (capacity > oldCapacity) {
                int newCapacity = oldCapacity * 2; 
                if (newCapacity < capacity) {
                    newCapacity = capacity; 
                }
                data = Arrays.copyOf(data, newCapacity);
            }
        }
        
        private void rangeCheck(int index) {
            if (index > size || index < 0)
                throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
        }
        
        // returns element at specified position
        public int getData(int index) {
            rangeCheck(index);
            return data[index]; 
        }
        
        
        public int getSize() {
            return size; 
        }
        
        public int capacity() {
            return data.length; 
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean add(int el) {
            checkCapacity(size + 1); 
            data[size] = data[size ++];
            return true;
        }
        
        // replace element 
        public int set(int index, String line) {
            rangeCheck(index);
            int oldValue = data[index]; 
            //data[index] = line; 
            return oldValue; 
        }
        
    }
    
    public static void main(String[] args) {
        SalesData sd = new SalesData(); 
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("mfrs.csv"));
            Scanner s = new Scanner(new File("mfrs.csv"));
            Scanner s2 = new Scanner(new File("items.csv"));
            sd.readData(br);
        }
        
        catch(IOException e) {
            System.out.print("no");
            System.exit(1);
        }

    }
    
}
