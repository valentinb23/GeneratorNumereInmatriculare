package foo;

public class Student {
	private String name;
	private int age;
	private Gender gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;//nume prenume initiala zzz
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " gender " + getGender();
	}
}
