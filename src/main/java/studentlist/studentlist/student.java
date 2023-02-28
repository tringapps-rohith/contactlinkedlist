package studentlist.studentlist;
class Student
{
	public static final String COM="com.api.jar";
     String name;
    String email;
    long phno;
    public Student(String name,String email,long phno)
    {
            this.name=name;
            this.email=email;
            this.phno=phno;
    }
					Logger l=Logger.getLogger(COM);

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
    Hash<Long,String>hs=new Hashtable<>();
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
