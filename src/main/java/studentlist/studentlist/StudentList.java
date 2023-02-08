package studentlist.studentlist;

/**
 * Hello world!
 *
 */
import java.util.*;
import java.util.logging.*;
class Student
{
     String name;
    String email;
    long phno;
    public Student(String name,String email,long phno)
    {
            this.name=name;
            this.email=email;
            this.phno=phno;
    }
					Logger l=Logger.getLogger("com.api.jar");

    public Student()
    {
    }
    public void setName(String name)
    {
            this.name=name;
    }
    public String getName()
    {
            return this.name;
    }

    public void setEmail(String email)
    {
            this.email=email;
    }
    public String getEmail()
    {
            return this.email;
    }
    public void setPhno(long phno)

    {
            this.phno=phno;
    }
    public long getPhno()
    {
            return this.phno;
    }
    public String toString()
    {
            return getName()+" "+getEmail()+" "+getPhno();
    }
    Hashtable<Long,String>hs=new Hashtable<>();
     Scanner sin=new Scanner(System.in);
       void getDetails()
        {
                l.info("\nEnter student name\n");
                String n=sin.next();
                l.info("Enter email id\n");
                String e=sin.next();
                l.info("Enter phone no\n");
                long ph=sin.nextLong();
                setName(n);
                setEmail(e);
                setPhno(ph);
         

        }
        void displayDetails()
        {
                l.log(Level.INFO,()-> "\nStudent name "+getName());
                l.log(Level.INFO,()-> "\nMail id "+getEmail());
                l.log(Level.INFO,()-> "\nPhone no "+getPhno());
        }
        void hashAdd()
        {
                getDetails();
                hs.put(getPhno(),getName());
                l.log(Level.INFO,()->""+ hs);
        }
        void hashRemove()
        {
                l.info("Enter phno\n");
                long pno=sin.nextLong();
                hs.remove(pno);
                l.log(Level.INFO,()->""+ hs);
        }

}
class Node
{
        Student data;
        Node next;
						Logger l=Logger.getLogger("com.api.jar");

        public Node(Student data,Node next)
        {
                this.data=data;
                this.next=next;
        }
        public Node()
        {
                this.data=new Student();
                next=null;
        }
        void dataDetails()
        {
                data.getDetails();
        }
        void display()
        {
                l.log(Level.INFO,()-> ""+data);
        }
}
class StudentList
{
        Node root;
						Logger l=Logger.getLogger("com.api.jar");

        int insertAtFirst(Node newNode)
        {
                if(root==null)
                {
                        root=newNode;
                }
                else
                {
                        newNode.next=root;
                        root=newNode;
                }
                return 1;
        }
        int insertAtLast(Node newNode)
        {
                if(root==null)
                {
                        root=newNode;
                }
                else
                {
                        Node temp=root;
                        while(temp.next!=null)
                        {
                                temp=temp.next;
                        }
                        temp.next=newNode;
                }
                return 1;
        }
        int insertByPos(Node newNode,int pos)
        {
                if(root==null)
                {
                        root=newNode;
                }
                else if(pos==1)
                {
                        insertAtFirst(newNode);
                }
                else
                {
                        Node temp=root;
                        Node p=root;
                        for(int i=1;i<pos;i++)
                        {
                                temp=p;
                                p=p.next;
                        }
                        temp.next=newNode;
                        newNode.next=p;
                }
                return 1;
        }
        int deleteAtFirst()
        {
                if(root==null)
                {
                        return -1;
                }
                else
		{
                       root=root.next;
                }
                return 1;
        }
        int deleteAtLast()
        {
                if(root==null)
                {
                        return -1;
                }
                else if(root.next==null)
                {
                        deleteAtFirst();
                }
                else
                {
                        Node temp=root;
                        Node prev=root;
                        while(temp.next!=null)
                        {
                                prev=temp;
                                temp=temp.next;
                        }
                        prev.next=null;
                }
                return 1;
        }
        int deleteByPos(int pos)
        {
                if(root==null)
                {
                        return -1;
                }
                else if(pos==1)
                {
                        
                        root=root.next;
                       
                }
                else
                {
                        Node temp=root;
                        Node p=root;
                        for(int i=1;i<pos;i++)
                        {
                                temp=p;
                                p=p.next;
                        }
                        temp.next=p.next;
                }
                return 1;
        }
        int search(long no)
        {
                
                if(root!=null)
                {
                        int index=1;
                        Node temp=root;
                        while(temp.next!=null && temp.data.phno!=no)
                        {
                                temp=temp.next;
                                index++;
                        }
                        if(temp.data.phno==no)
                        {
                                return index;
                        }
                        else
                                return -1;
                }
                return -2;
        }
        Scanner sin=new Scanner(System.in);
        Student s=new Student();
        void displayList()
        {
                if(root==null)
                {
                        l.info("List is empty\n");
                }
                else
                {
                        Node temp=root;
                        while(temp!=null)
                        {
                                temp.data.displayDetails();
                                temp=temp.next;
                        }
                }
        }

        public static void main(String...args)
        {
                Scanner sin=new Scanner(System.in);
								Logger l=Logger.getLogger("com.api.jar");

                Student s=new Student();
                StudentList sl=new StudentList();
              
                Node newNode;
                int res;
		int pos;
                l.info("\nEnter student details\n");
                int ch;
		String str="Enter  student details\n";
                do
                {
                        l.info("\n1.Insert At First\n2.Insert At Last\n3.Insert By Position\n4.Delete At First\n5.Delete At Last\n6.Delete By Pos\n7.Search By Contact No\n8.Add phno to Hash\n9.Remove phno to Hash\n10.Exit\n");
                        l.info("Enter your choice\n");
                        ch=sin.nextInt();
                        switch(ch)
                        {
                                case 1:
                                        l.info(str);
                                         newNode=new Node();
                                        newNode.dataDetails();
                                        res=sl.insertAtFirst(newNode);
                                          l.info("Insertion is successful\n");
                                                sl.displayList();
                                               
                                        
                                        break;
                                case 2:l.info(str);
                                        newNode=new Node();
                                        newNode.dataDetails();
                                        res=sl.insertAtLast(newNode);
                                       
                                                l.info("Insertion is successful\n");
                                      
                                        
                                        break;
                                case 3:l.info(str);
                                        newNode=new Node();
                                        newNode.dataDetails();
                                        l.info("Enter the position\n");
                                        pos=sin.nextInt();
                                        res=sl.insertByPos(newNode,pos);
                                      
                                                l.info("Insertion is not possible\n");
                                        
                                        break;
                                case 4: res=sl.deleteAtFirst();
                                       
                                                l.info("\nSuccessfully deleted\n");
                                                sl.displayList();
                                        
                                        break;
                                case 5:res=sl.deleteAtLast();
                                      
                                                l.info("\nSuccessfully deleted\n");
                                                sl.displayList();
                                        
                                        break;
                                case 6:l.info("Enter the position to delete\n");
                                       pos=sin.nextInt();
                                       res=sl.deleteByPos(pos);
                                     
                                       
                                               l.info("Deletion is successful\n");
                                               sl.displayList();
                                       
                                       break;
                                case 7:l.info("Enter th no to search\n");
                                       long no=sin.nextLong();
                                       res=sl.search(no);

                           
                                               l.log(Level.INFO,()-> "Your phone no is located in "+res+" position\n");
                                       
                                       break;
                                      case 8:s.hashAdd();
                                               break;
                                      case 9:s.hashRemove();
                                              break;
                                      case 10:l.info("\nThank u\n");
                                             break;
                                      default:l.info("Enter valid input\n");
                                              break;

                        }
                }while(ch!=10);
        }
}
