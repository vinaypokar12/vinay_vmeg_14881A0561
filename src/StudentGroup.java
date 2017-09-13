import java.util.*;
import java.text.*;
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
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index < 0 || index >= this.students.length)
			throw new IllegalArgumentException();
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else if(index < 0 || index >= this.students.length)
			throw new IllegalArgumentException();
		else
			this.students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			llstudent.addFirst(student);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			llstudent.addLast(student);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else if(index < 0 || index >= this.students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			llstudent.add(index,student);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			llstudent.remove(index);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
		int firstIndex = llstudent.indexOf(student);
		if(firstIndex == -1)
			throw new IllegalArgumentException("Student not exist");
		else if(student == null)
			throw new IllegalArgumentException();
		else{
			llstudent.remove(firstIndex);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=index;i<llstudent.size();i++)
			{	
				llstudent.remove(i);
				
			}
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			for(int i=firstIndex+1;i<llstudent.size();i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			for(int i=0;i<index-1;i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			for(int i=0;i<firstIndex+1;i++)
				llstudent.remove(i);
			this.students = llstudent.toArray(new Student[llstudent.size()]);
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<this.students.length;i++){
			for(int j=0;j<this.students.length-i-1;j++){
				int id1=this.students[j].getId();
				int id2=this.students[j+1].getId();
				if(id1 > id2){
					Student temp = this.students[j];
					this.students[j] = this.students[j+1];
					this.students[j+1] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		if(date == null)
			throw new IllegalArgumentException();
		LinkedList<Student> llstudent=new LinkedList<Student>();
		for(Student stud:this.students)
		{
			if((stud.getBirthDate())==(date))
			{
				llstudent.add(stud);
			}
		}
		return llstudent.toArray(new Student[llstudent.size()]);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate == null || lastDate==null)
			throw new IllegalArgumentException();
		LinkedList<Student> llstudent=new LinkedList<Student>();
		for(Student stud:this.students)
		{
			if(stud.getBirthDate().after(firstDate) && stud.getBirthDate().before(lastDate))
			{
				llstudent.add(stud);
			}
		}
		
		return llstudent.toArray(new Student[llstudent.size()]);
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		if(date == null)
			throw new IllegalArgumentException();
		LinkedList<Student> llstudent=new LinkedList<Student>();
		Calendar cal=getCalander(date);
		cal.add(Calendar.DATE,days);
		date=cal.getTime();
		for(Student stud:this.students){
			if(stud.getBirthDate().before(date))
				llstudent.add(stud);
		}
		return llstudent.toArray(new Student[llstudent.size()]);
	}
	public Calendar getCalander(Date date)
	{
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		int age=0;
		if(indexOfStudent == 0)
			throw new IllegalArgumentException();
		Date curdate=new Date();
		return this.students[indexOfStudent].getBirthDate().getYear() - curdate.getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		LinkedList<Student> llstudent=new LinkedList<Student>();
		for(int i=0;i<this.students.length;i++)
		{
			if(getCurrentAgeByDate(i) == age)
				llstudent.add(getStudent(i));
		}
		
		
		return llstudent.toArray(new Student[llstudent.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		LinkedList<Student> llstudent=new LinkedList<Student>();
		double max=0;
		for(Student stud:this.students)
		{
			if(stud.getAvgMark() > max)
				max=stud.getAvgMark();
		}
		for(Student stud:this.students)
		{
			if(stud.getAvgMark() == max)
				llstudent.add(stud);
		}
		
		return llstudent.toArray(new Student[llstudent.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		if(student == null)
			throw new IllegalArgumentException();
		else{
			LinkedList<Student> llstudent = new LinkedList<Student>(Arrays.asList(this.students));
			int firstIndex = llstudent.indexOf(student);
			return llstudent.get(firstIndex+1);
		}
	}
}
