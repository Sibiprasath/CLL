import java.util.Scanner;

public class CLLdeletion{
    Node last;
    class Node{
        int data;
        Node next;
        
        Node(int val){
            data = val;
            next = null;
        }
    }
    CLLdeletion(){
        last = null;
    }
    public void insertbegin(int val){
        Node newnode = new Node(val);
         
        if (last==null){
            newnode.next=newnode;
            last=newnode;
        }
        else{
            newnode.next=last.next;
            last.next=newnode;
            last=newnode;
        }
    }
    public void deletebegin(){
        last.next=last.next.next;
    }
    public void deleteend(){
        Node temp;
        temp=last.next;
        while(temp.next!=last){
            temp=temp.next;
        }
        temp.next=last.next;
        last=temp;
    }
    public void position(int pos){
        Node temp;Node prev;
        temp=last.next;
        prev=last;
        for(int i=1;i<pos;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
    }
    public void display(){
        Node temp = last.next;
        
        do{
            System.out.print(temp.data+"-->");
            temp =temp.next;
        }
        while(temp!=last.next);

    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        CLLdeletion list = new CLLdeletion();
        
        int m = sc.nextInt();
        for (int i =0 ;i<m;i++){
            int val = sc.nextInt();
            list.insertbegin(val);
        }
        int pos=sc.nextInt();
        list.deletebegin();
        list.display();
        System.out.println("\n");
        list.deleteend();
        list.display();
        System.out.println("\n");
        list.position(pos);
        list.display();
    }
}