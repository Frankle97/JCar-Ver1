
package mycar;

public class UserDto {
	private String id, pw, name, phonenumber, whenadd, model;
	private int price;
	private String incolor, outcolor, option;

	private String reservYear, reservMonth, reservDate, reservTime;

	public String getReservTime() {
		return reservTime;
	}

	public void setReservTime(String reservTime) {
		this.reservTime = reservTime;
	}

	public String getReservYear() {
		return reservYear;
	}

	public void setReservYear(String reservYear) {
		this.reservYear = reservYear;
	}

	public String getReservMonth() {
		return reservMonth;
	}

	public void setReservMonth(String reservMonth) {
		this.reservMonth = reservMonth;
	}

	public String getReservDate() {
		return reservDate;
	}

	public void setReservDate(String reservDate) {
		this.reservDate = reservDate;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getIncolor() {
		return incolor;
	}

	public void setIncolor(String incolor) {
		this.incolor = incolor;
	}

	public String getOutcolor() {
		return outcolor;
	}

	public void setOutcolor(String outcolor) {
		this.outcolor = outcolor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getWhenadd() {
		return whenadd;
	}

	public void setWhenadd(String whenadd) {
		this.whenadd = whenadd;
	}

	@Override
	public String toString() {
		String tmp = Integer.toString(this.price);
		return "모델 : " + this.model + "\n외장색상 : " + this.incolor + "\n내장색상 : " + this.outcolor
				+ "\n▽선택 옵션 ▽\n======================\n" + this.option + "======================\n총  견적금액 : "
				+ tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원";
	}

	public UserDto(int price) {
		this.price += price;
	}

	public UserDto(String incolor, String outcolor, String option) {
		super();
		this.incolor = incolor;
		this.outcolor = outcolor;
		this.option = option;
	}

	public UserDto(String id, String pw, String name, String phonenumber, String when) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenumber = phonenumber;
		this.whenadd = when;
	}

	public UserDto() {
	}

}
