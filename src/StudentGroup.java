import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 *
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;

	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length)
	{
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents()
	{
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students)
	{
		// Add your implementation here
		if(students==null)
            throws IllegalArgumentException;
        else
            this.students=students;
	}

	@Override
	public Student getStudent(int index)
	{
		// Add your implementation here
		if(index<0||index>=students.length)
            throws IllegalArgumentException;
        else
            return students[index];
	}

	@Override
	public void setStudent(Student student, int index)
	{
		// Add your implementation here
		if(student==null)
            throws IllegalArgumentException;
        if(index<0||index>=students.length)
            throws IllegalArgumentException;
        else
            students[index]=student;
	}

	@Override
	public void addFirst(Student student)
	{
		// Add your implementation here
		int in;
		if(student==null)
            throws IllegalArgumentException;
        else
        {
        Student[] newstd=new Student[students.length+1];
        newstd[0]=student;
        for(in=1;in<stdn.length;in++)
            stdn[in]=students[in-1];
        students=newstd;
        }
	}

	@Override
	public void addLast(Student student)
	{
		// Add your implementation here
		int in;
		if(student==null)
            throws IllegalArgumentException;
        else
        {
        Student[] newstd=new Student[students.length+1];
        for(in=0;in<students.length;in++)
            newstd[in]=students[in];
        newstd[in]=student;
        students=newstd;
        }
	}

	@Override
	public void add(Student student, int index)
	{
		// Add your implementation here
		if(student==null||index<0||index>=students.length)
            throws IllegalArgumentException;
        else
        {
        Student[] newstd=new Student[students.length+1];
        for(int in=0;in<index;in++)
            newstd[in]=students[in];
        newstd[index]=student;
        for(int in=index;in<students.length;in++)
            newstd[in+1]=students[in];
        students=newstd;
        }
	}

	@Override
	public void remove(int index)
	{
		// Add your implementation here
		if(index<0||index>=students.length)
            throws IllegalArgumentException;
        else
        {
            Student[] newstd=new Student[students.length-1];
            for(int in=0;in<index;in++)
                newstd[in]=students[in];
            for(int in=index+1;in<students.length;in++)
                newstd[in-1]=students[in];
            students=newstd;
        }
	}

	@Override
	public void remove(Student student)
	{
		// Add your implementation here
		int in,temp=0;
		if(student==null)
            throws IllegalArgumentException;
        else
        {
            for(in=0;in<students.length;in++)
            {
                if(student.compareTo(students[in])==0)
                {
                    temp=1;
                    break;
                }
            }
            if(temp==0)
                throws IllegalArgumentException;
            else
                remove(in);
        }
	}

	@Override
	public void removeFromIndex(int index)
	{
		// Add your implementation here
        if(index<0||index>=students.length)
            throws IllegalArgumentException;
        else
        {
            Student[] newstd=new Student[index];
            for(int in=0;in<=index;in++)
                newstd[in]=students[in];
            students=newstd;
        }
	}

	@Override
	public void removeFromElement(Student student)
	{
		// Add your implementation here
		int in,temp=0;
		if(student==null)
            throws IllegalArgumentException;
        else
        {
            for(in=0;in<students.length;in++)
            {
                if(student.compareTo(students[in])==0)
                {
                    temp=1;
                    break;
                }
            }
            if(temp==0)
                throws IllegalArgumentException;
            else
                removeFromIndex(in);
        }
	}

	@Override
	public void removeToIndex(int index)
	{
		// Add your implementation here
		if(index<0||index>=students.length)
            throws IllegalArgumentException;
        else
        {
            int in1=0;
            Student[] newstd=new Student[students.length-index];
            for(int in=index;in<students.length;in++)
                std[in1++]=students[in];
            students=newstd;
        }
	}

	@Override
	public void removeToElement(Student student)
	{
		// Add your implementation here
		int in,temp=0;
		if(student==null)
            throws IllegalArgumentException;
        else
        {
            for(in=0;in<students.length;in++)
            {
                if(student.compareTo(students[in])==0)
                {
                    temp=1;
                    break;
                }
            }
            if(temp==0)
                throws IllegalArgumentException;
            else
                removeToIndex(in);
        }
	}

	@Override
	public void bubbleSort()
	{
		// Add your implementation here
		Student t;
		for(int in=0;in<students.length-1;in++)
        {
            for(int in1=i+1;in1<students.length;in1++)
            {
                if(students[in].compareTo(students[in1])>0)
                {
                    t=students[in];
                    students[in]=students[in1];
                    students[in1]=t;
                }
            }
        }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		ArrayList<Student> arl=new ArrayList<Student>();
		if(date==null)
            throws IllegalArgumentException;
        else
        {
            for(int in=0;in<students.length;in++)
                if(students[in].birthDate.compareTo(date)==0)
                    arl.add(students[in]);
            Student[] newstd=arl.toArray();
            return newstd;
        }
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null||lastDate==null)
            throws IllegalArgumentException;
		else
		{
            ArrayList<Student> arl=new ArrayList<Student>();
            for(int in=0;in<students.length;in++)
                if(students[in].birthDate.compareTo(lastDate)<=0&&students[in].birthDate.compareTo(firstDate)>=0)
                    arl.add(students[in]);
            Student[] newstd=arl.toArray();
            return newstd;
		}
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		String dt=date.toString();
		if(date==null)
            throws IllegalArgumentException;
        else
        {
            ArrayList<Student> arl=new ArrayList<Student>();
            for(int in=0;in<students.length;in++)
                if(students[in].birthDate.toString().compareTo(dt)<=days&&students[in].birthDate.toString().compareTo(dt)>=0)
                    arl.add(students[in]);
            Student[] newstd=arl.toArray();
            return newstd;
        }
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent<0 || indexOfStudent>=students.length)
           throws IllegalArgumentException;
       else
       {
           String dt=students[indexOfStudent].birthDate.toString();
           LocalDate ldt=LocalDate.parse(dt);
           LocalDate presentDate=LocalDate.now();
           return Period.between(ldt,presentDate).getYears();
       }

	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
