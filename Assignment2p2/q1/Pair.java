package Assignment2p2.q1;
public class Pair<K,V>{
    K key;
    V value;
    Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setK(K key){
        this.key = key;
    }
    public void setV(V value){
        this.value = value;
    }
    public String toString(){
        return "Key: "+key+" Value: "+value;
    }
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("ABC", 1);
        System.out.println(pair1);
        Pair<String,Integer> pair2 = new Pair<>("DEF", 2);
        System.out.println(pair2);
        Pair<String,Integer> pair3 = new Pair<>("PQR", 3);
        System.out.println(pair3);
    }
}