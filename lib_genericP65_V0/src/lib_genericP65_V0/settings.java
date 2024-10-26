package lib_genericP65_V0;

import java.util.ArrayList;
import java.util.List;

public interface settings <T> {
	
	public final String developer="MarcoEspinosa-1751579010";
	
	public final List<String> elements=new ArrayList();
	 
	public default void addElements(String element) {
		this.elements.add(element);
	}
	
	public default void listElements() {
		for (int i=0;i<elements.size();i++) {
			System.out.printf("%d. &s", (i+1), elements.get(i));
		}
	}
	
	public default T searchElement(T...elements) {
		T element=elements[0];
		
		for (int i=0;i<elements.length;i++) {
			if (element.toString().equals(elements[i].toString())) {
				return element;
			}
		}
		
		return null;
	};
	
	
	
	
	
	
};
