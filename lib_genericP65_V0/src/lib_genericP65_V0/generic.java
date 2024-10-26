package lib_genericP65_V0;

import java.util.ArrayList;
import java.util.List;

public class generic<T,S> {
	private T attribute1, attribute2;
	private S attribute3, attribute4;
	private T[] attArray1;
	private S[] attArray2;
	private List<S> attList1=new ArrayList();
	private List<T> attList2=new ArrayList();
	//metodos constructores
	public generic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public generic(T attribute1) {
		super();
		this.attribute1 = attribute1;
	}
	public generic(T attribute1, S attribute3) {
		super();
		this.attribute1 = attribute1;
		this.attribute3 = attribute3;
	}
	public generic(T attribute1, T attribute2, S attribute3) {
		super();
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
	}
	public generic(T attribute1, T attribute2, S attribute3, S attribute4) {
		super();
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
	}
   public generic(T attribute3, S...elements) {
	   this.attribute1=attribute1;
	   this.attArray2=elements;
   }
	public T getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(T attribute1) {
		this.attribute1 = attribute1;
	}
	public T getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(T attribute2) {
		this.attribute2 = attribute2;
	}
	public S getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(S attribute3) {
		this.attribute3 = attribute3;
	}
	public S getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(S attribute4) {
		this.attribute4 = attribute4;
	}
	public T[] getAttArray1() {
		return attArray1;
	}
	public void setAttArray1(T[] attArray1) {
		this.attArray1 = attArray1;
	}
	public List<S> getAttList1() {
		return attList1;
	}
	public S[] getAttArray2() {
		return attArray2;
	}
	public void setAttArray2(S[] attArray2) {
		this.attArray2 = attArray2;
	}
	
	public List<T> getAttList2() {
		return attList2;
	}
	public void setAttList2(List<T> attList2) {
		this.attList2 = attList2;
	}
	public void setAttList1(List<S> attList1) {
		this.attList1 = attList1;
	}
	//metodos genericos para implementar datos
	/**
	 * Metodo para agregar elementos en una interfaz List tipo S
	 * @param element Dato de tipo S
	 */
	public void addElementsList(S element) {
		this.attList1.add(element);
	}
	public void addElementsList2(T element) {
		this.attList2.add(element);
	}
	/**
	 * Metodo para agregar elementos en un arreglo de tipo T
	 * @param elements variable args de tipo T
	 */
	public void addElementArray(T...elements) {
		this.attArray1=elements;
	}
	/**
	 * Metodo para analizar datos de tipo Double y devolver su valor de acuerdo a
	 * los siguientes tipo 
	 * value=1 Numero Mayor
	 * value=2 Numero menor
	 * value=3 Promedio
	 * value=4 Sumatoria
	 * @param value de tipo generico el primer valor corresponde al tipo
	 * y el segundo al arreglo de valores
	 * @return Resultado de tipo double
	 */
//	public double  typesElements(generic<? extends Integer,? extends Double>value) {
//		double num=0;
//		num=value.attArray2[0].doubleValue();
//		switch(value.getAttribute1().intValue()) { //corregir
//		case 1:
//			for(double nums:value.attArray2) {
//				if(num<nums) {
//					num=nums;
//				}
//			}
//			break;
//		case 2:
//			for(double nums:value.attArray2) {
//				if(num>nums) {
//					num=nums;
//				}
//			}
//		case 3:
//			for(double nums:value.attArray2) {
//				num+=nums;
//			}
//			num/=value.attArray1.length;
//			break;
//		case 4:
//			num=0;
//			for(double nums:value.attArray2) {
//				num+=nums;
//			}
//			break;
//			default:
//				return 0.0;
//		}
//		
//	return num;
//	}
	@Override
	public String toString() {
		return "generic [attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3
				+ ", attribute4=" + attribute4 + "]";
	}
	
}