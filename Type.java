public class Type implements Comparable<Type> {
    private final int var1;
    
    public Type() {
        var1 = -2;
    }
    
    Type(int var1) {
        this.var1 = var1;
    }
    
    public int getVar1() { return var1; }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Type)) return false;
        return var1 == ((Type) obj).getVar1();
    }
    
    @Override
    public int compareTo(Type type) {
        return var1 - type.getVar1();
    }
}
