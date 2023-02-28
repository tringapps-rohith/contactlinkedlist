package studentlist.studentlist;

class Node
{
        Student data;
        Node next;
						

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
      
}
