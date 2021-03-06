package week8.jvm.constant;


public class FieldRefInfo extends ConstantInfo{

	private int type=ConstantInfo.Field_INFO;
	private int classInfoIndex;
	private int nameAndTypeIndex;
	
	public FieldRefInfo(ConstantPool pool){
		super(pool);
	}
	
	@Override
	public int getType() {
		return this.type;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitFieldRef(this);
	}
	
    @Override
	public String toString(){
		
		NameAndTypeInfo  typeInfo = (NameAndTypeInfo)this.getConstantInfo(this.getNameAndTypeIndex());
		
		return getClassName() +" : "+  typeInfo.getName() + ":" + typeInfo.getTypeInfo() +"]";
	}
	
	public String getClassName(){
		ClassInfo classInfo=(ClassInfo) this.getConstantInfo(this.getClassInfoIndex());
	    UTF8Info utf8Info=(UTF8Info) this.getConstantInfo(classInfo.getUtf8Index());
	    return utf8Info.getValue();
	}
	

	public String getFieldName(){
		NameAndTypeInfo  typeInfo = (NameAndTypeInfo)this.getConstantInfo(this.getNameAndTypeIndex());
		return typeInfo.getName();		
	}
	
	public String getFieldType(){
		NameAndTypeInfo  typeInfo = (NameAndTypeInfo)this.getConstantInfo(this.getNameAndTypeIndex());
		return typeInfo.getTypeInfo();	
	}

	public int getClassInfoIndex() {
		return classInfoIndex;
	}

	public void setClassInfoIndex(int classInfoIndex) {
		this.classInfoIndex = classInfoIndex;
	}

	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}

	public void setNameAndTypeIndex(int nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
}
