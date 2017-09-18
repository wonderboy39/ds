package tree;

public class LCRSTree {
	private String str_data;
	private LCRSTree child = null;		// left - child
	private LCRSTree sibling = null;	// right - sibling
	
	public LCRSTree(){}
	public LCRSTree(String str_data){
		this.str_data = str_data;
	}
	
	public void appendChild(LCRSTree child){
		
		if (child == null){
			this.child = child;			
		}
		else{
			LCRSTree temp = this.child;
			while(temp.sibling != null)
				temp = temp.sibling;
			temp.sibling = child;
		}
	}
}
