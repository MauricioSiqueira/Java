import java.util.*;

public class hash {
    private List<List<String>> table = new ArrayList<List<String>>();

    public hash(){
        for ( int i=0; i < 26; i++){
            LinkedList<String> list = new LinkedList<String>();
            table.add(list);
        }

    }
    private int large = 0;

    public int large(){
        return this.large;
    }

    public boolean exist (String word){
        int index = this.calcIndexHash(word);
        List<String> list = this.table.get(index);
        return  list.contains(word);
    }

    private int calcIndexHash(Object $object){
        int codeSpread = $object.hashCode();
        codeSpread = Math.abs(codeSpread);
        return  codeSpread % table.size();
    }

    public void addWord(String word){
        if (!this.exist(word)){
            int index = this.calcIndexHash(word);
            List<String> list = this.table.get(index);
            list.add(word);
            this.large++;
        }
    }

    public List<String> getAll() {
        List<String> words = new ArrayList<String>();
        for(int i = 0; i < this.table.size(); i++){
            words.addAll(this.table.get(i));
        }
        return words;
    }

    public void remove(String word){
        if(this.exist(word)){
            int index = this.calcIndexHash(word);
            List<String> list = this.table.get(index);
            list.remove(word);
            this.large--;
        }
    }

    public void printTable(){
        for(List<String> list : this.table) {
            System.out.print("[");
            for (int i =0; i< list.size(); i++){
                System.out.print("*");
            }
            System.out.println("]");
        }
    }

    private int calcCodeSpread(String word){
        int code = 1;
        for (int i=0;i<word.length();i++){
            code = 31*code+word.charAt(i);
        }
        return code;
    }
}
