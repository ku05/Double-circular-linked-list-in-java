import java.util.*;

import javax.swing.plaf.synth.SynthSpinnerUI;
class doublecircular{
    Node head,temp,tail,prevnode,nextnode,currnode,newnode;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public void create(){
        Scanner sc=new Scanner(System.in);
        head=null;
        int i=1;
        while(i<=5){
            System.out.println("Enter the data:");
            int x=sc.nextInt();
            Node newnode=new Node(x);
            if(head==null){
                head=tail=newnode;
                newnode.next=head;
                head.prev=newnode;
            }else{
                tail.next=newnode;
                newnode.prev=tail;
                newnode.next=head;
                tail=newnode;
                head.prev=tail;
            }
            i++;
        }
    }
    public void addfirst(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data to add first:");
        int x=sc.nextInt();
        Node newnode=new Node(x);
        head.prev=newnode;
        newnode.next=head;
        newnode.prev=tail;
        tail.next=newnode;
        head=newnode;
    }
    public void addlast(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data to add last:");
        int x=sc.nextInt();
        Node newnode=new Node(x);
        tail.next=newnode;
        newnode.prev=tail;
        newnode.next=head;
        head.prev=newnode;
        tail=newnode;
    }
    public void addpos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the position to add data:");
        int pos=sc.nextInt();
        int i=1;
        temp=head;
        if(pos==1){
            addfirst();
        }else{
            while(i<pos-1){
                temp=temp.next;
                i++;
            }
            System.out.println("Enter the data to add pos:");
            int x=sc.nextInt();
            Node newnode=new Node(x);
            newnode.prev=temp;
            newnode.next=temp.next;
            temp.next=newnode;
            newnode.next.prev=newnode;
        }
    }
    public void deletefirst(){
        System.out.println("First node is deleted:");
        temp=head;
        head=head.next;
        head.prev=tail;
        tail.next=head;
    }
    public void deletelast(){
        System.out.println("Last node is deleted:");
        temp=tail;
        tail=tail.prev;
        tail.next=head;
        head.prev=tail;
    }
    public void deletepos(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the position:");
        int pos=sc.nextInt();
        int i=1;
        temp=head;
        if(pos==1){
            deletefirst();
        }else{
            while(i<pos){
                temp=temp.next;
                i++;
            }
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }

    }
    public void display(){
        System.out.println("Double circular linked list is:");
        temp=head;
        while(temp.next!=head){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data+"->");
        System.out.println("null");
        System.out.println("circular data is :"+tail.next.data);
    }
    public static void main(String args []){
        doublecircular list=new doublecircular();
        list.create();
        list.display();
        list.addfirst();
        list.display();
        list.addlast();
        list.display();
        list.addpos();
        list.display();
        list.deletefirst();
        list.display();
        list.deletelast();
        list.display();
        list.deletepos();
        list.display();
    }
}