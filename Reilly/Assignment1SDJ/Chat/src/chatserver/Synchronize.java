package chatserver;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Synchronize {
    private List<String> transcript = Collections.synchronizedList(new ArrayList<String>());
    
    public Synchronize() {
        
    }
    
    public void addComment(String comment) { transcript.add(comment); }
    public int getSize() { return transcript.size(); }
    public String getComment(int n) { return transcript.get(n); }
}
