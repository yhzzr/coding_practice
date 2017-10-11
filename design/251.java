public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> list;
    Iterator<Integer> m;
    
    public Vector2D(List<List<Integer>> vec2d) {
        
        list = vec2d.iterator();
        if(list.hasNext()){
            m = list.next().iterator();
        }else{
            m = null;
        }
    }

    @Override
    public Integer next() {
        return m.next();
    }

    @Override
    public boolean hasNext() {
        if(m==null) return false;
        if(m.hasNext()) {
            return true;
        }else{
            while( list.hasNext()){
                m = list.next().iterator();
                if(m.hasNext()) 
                    return true;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */