public class SomeClass {
    private String someStrAttr;
    private Integer someIntAttr;

    public SomeClass(String s, int i) {
        this.someStrAttr = s;
        this.someIntAttr = i;
    }

    public String getSomeStrAttr() {
        return someStrAttr;
    }

    public void setSomeStrAttr(String someStrAttr) {
        this.someStrAttr = someStrAttr;
    }

    public Integer getSomeIntAttr() {
        return someIntAttr;
    }

    public void setSomeIntAttr(Integer someIntAttr) {
        this.someIntAttr = someIntAttr;
    }
}
