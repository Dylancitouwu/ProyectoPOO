package Model;

import lib_genericP65v0.generic;

public class acount {
	private generic<Long, Double>dt_a;
	public acount(long numberAcount, long dni, double mount) {
		dt_a=new generic<>(numberAcount,dni,mount);
	}
	public acount() {
		// TODO Auto-generated constructor stub
		dt_a=new generic<>();
	}
	public long getNumberAcount() {
		return dt_a.getAttribute1();
	}
	public void setNumberAcount(long value) {
		this.dt_a.setAttribute1(value);
	}
	public long getDni() {
		return dt_a.getAttribute2();
	}
	public void setDni(long value) {
		dt_a.setAttribute2(value);
	}
	public double getMount() {
		return dt_a.getAttribute3();
	}
	public void setMount(double value) {
		dt_a.setAttribute3(value);
	}
	public String toString() {
		return String.format("%d;%d;%s", getNumberAcount(),getDni(),String.valueOf(getMount()));
	}
}
