n
rt java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
 

public class ProductData {
    DoublyLinkedList d; 
    // read in data of interest 
    
    public void list(BufferedReader br) throws IOException {
        d = new DoublyLinkedList(); 
         
        String line = null;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            String[] parts = line.split(",");  // chAnge
            String code = parts[0];
            String company = parts[1]; 
            Node node = new Node(code, company); 
            d.append(node);
        }
     
            
            
            
        
        
        // test
        //Node node2 = new Node("1234", "blah"); 
        //d.insert(node2, 2);
        Node check = d.get(752);
        System.out.print(check.code);
        //System.out.print(check.name);
        //System.out.print(d.length());
    
        


        
        //Node n = d.get(4); 
        //System.out.print(n.code);
        //System.out.print(n.name);
        
    
        //Node node2 = d.get(12); 
        //System.out.print(node2.code);
        //System.out.print(node2.name);
    }
    
    
    
    
    public static void main(String[] args) {
        ProductData p = new ProductData(); 
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("mfrs.csv"));
            Scanner s = new Scanner(new File("mfrs.csv"));
            Scanner s2 = new Scanner(new File("items.csv"));
            p.list(br);
        }
        
        catch(IOException e) {
            System.out.print("no");
            System.exit(1);
        }

    }
    
    
    public class Node {
        public Node next = null;
        public Node previous = null; 
        public String code; 
        public String name; 
        
        
        public Node(String code, String name) {
            this.code = code;
            this.name = name; 
        }
    }
    
    public class DoublyLinkedList {
        public Node head; 
        public Node tail; 
        

        public int length() { 
            Node current;
            int count = 0; 
            if (head != null) { 
                count = count + 1; 
                current = head; 
                while (current.next != null) {
                    count = count + 1;
                    current = current.next; 
                }
            }
            
            return count; 
        }
        
        // gaining space losing time 
        
        // not getting last element: null pointer excp
        public Node get(int idx) {
            Node current; 
            int count = 0; 
            if (head != null) {
                count = count + 1;
                current = head; 
                while (current.next != null) {
                    if (count == idx) {
                        return current;
                    }
                    current = current.next; 
                    count = count + 1; 
                }
            }
            return null; 
        }
        
        
        public void swap(int idx, int idxx) {
            Node a = get(idx); 
            Node b = get(idxx);
            Node temp = new Node(b.code, b.name); 
            
            b.code = a.code; 
            b.name = a.name; 
            a.code = temp.code; 
            a.name = temp.name; 

        }
        
        
        // not working
        public void insert(Node node, int idx) {
            Node a = get(idx); // get node at index 
            node.previous = a.previous;
            a.previous = node; 
            node.next = a; 
            
        }

        
        
        // not working
        public void append(Node n) {
            Node node = new Node(n.code, n.name); 
            if (head == null) {
                head = node; 
                tail = node; 
            }
            
            else { 
                
                tail.next = node; 
                node.previous = tail; 
                tail = node; 
                node.next = null; 
            }
            
        }
        
        // losing time gaining space
        
    }

