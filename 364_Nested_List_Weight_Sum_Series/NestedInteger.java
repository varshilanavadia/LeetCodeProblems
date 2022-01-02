import java.util.ArrayList;
import java.util.List;

public interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger() throws Exception;

    public void setInteger(int value) throws Exception;

    public void add(NestedInteger ni) throws Exception;

    public List<NestedInteger> getList() throws Exception;
}

class NestedInt implements NestedInteger{
    Integer value;

    public NestedInt(Integer value) {
        this.value = value;
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public Integer getInteger() {
        return this.value;
    }

    @Override
    public void setInteger(int value) {
        this.value = value;
    }

    @Override
    public void add(NestedInteger ni) throws Exception {
        throw new Exception();
    }

    @Override
    public List<NestedInteger> getList() throws Exception {
        throw new Exception();
    }
}

class NestedList implements NestedInteger{
    List<NestedInteger> list = new ArrayList();

    public NestedList(List<NestedInteger> list) {
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() throws Exception {
        throw new Exception();
    }

    @Override
    public void setInteger(int value) throws Exception {
        throw new Exception();
    }

    @Override
    public void add(NestedInteger ni){
        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return this.list;
    }
}