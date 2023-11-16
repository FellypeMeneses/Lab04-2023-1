package list;
public class PilhaPanasonic {
    ListaLigada lista=null;
    
    public boolean isEmpty(){
        if(lista==null){
            return true; 
        }
        else{
        return false;
        }
    }

    public void push(int item){
        lista.insereInicio(item);
    }

    public int pop(){
        int a = lista.getValorInicio();
        lista.removeInicio();
        return a;
    }
}