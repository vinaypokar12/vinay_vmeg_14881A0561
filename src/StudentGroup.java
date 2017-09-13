import java.util.*;

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
		if(this.students.length == 0)
			return null;
		else
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
		if(index < 0 || index >= students.length)
			throw new IllegalArgumentException();
		else if(this.students.length == 0)
			return null;
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
			students = llstudent.toArray(new Student[llstudent.size()]);
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
			students = llstudent.toArray(new Student[llstudent.size()]);
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
			students = llstudent.toArray(new Student[llstudent.size()]);
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
			students = llstudent.toArray(new Student[llstudent.size()]);
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
			students = llstudent.toArray(new Student[llstudent.size()]);
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
			//for(int i=0;i<llstudent.size();i++)
				//System.out.println("llstudent:"+llstudent.get(i).getFullName());
			students = llstudent.toArray(new Student[llstudent.size()]);
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
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
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
